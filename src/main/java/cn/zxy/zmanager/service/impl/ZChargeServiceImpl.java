package cn.zxy.zmanager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZHouseFee;
import cn.zxy.zmanager.dao.dataobject.ZHouseFeeExample;
import cn.zxy.zmanager.dao.dataobject.ZPaidFeeDetail;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.dao.mapper.ZHouseFeeMapper;
import cn.zxy.zmanager.dao.mapper.ZPaidFeeDetailMapper;
import cn.zxy.zmanager.service.ZChargeService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.CommonUtils;
import cn.zxy.zmanager.support.common.utils.DateUtils;

@Service
public class ZChargeServiceImpl implements ZChargeService {

	@Autowired
	private ZPaidFeeDetailMapper paidFeeDetailMapper;

	@Autowired
	private ZContractMapper contractMapper;
	
	@Autowired
	private ZHouseFeeMapper houseFeeMapper;
	
	private static final int WATER_FEE = 0;
	
	private static final int ELECTRIC_FEE = 1;

	@Transactional
	@Override
	public ZManagerResult<?> addCharge(ZPaidFeeDetail paidFeeDetail, LoginUser loginUser) {
		ZContract contract = contractMapper.selectByPrimaryKey(paidFeeDetail.getContractId());
		ZPaidFeeDetail newPaidFeeDetail = getNewPaidFeeDetail(contract, paidFeeDetail, loginUser);

		switch (newPaidFeeDetail.getFeeType()) {
		case ZPaidFeeDetail.RENT_FEE:
			List<ZHouseFee> rentFeeList = getRentHouseFeeList(newPaidFeeDetail);
			if (CommonUtils.isListEmpty(rentFeeList)) {
				return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "租金已缴清，无需再缴，缴费失败！");
			}
			houseFeeMapper.updateFeeByHouseFeeList(rentFeeList);
			break;
		case ZPaidFeeDetail.PROPERTY_FEE:
			List<ZHouseFee> propertyFeeList = getPropertyFeeList(newPaidFeeDetail);
			if (CommonUtils.isListEmpty(propertyFeeList)) {
				return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "物业费已缴清，无需再缴，缴费失败！");
			}
			houseFeeMapper.updateFeeByHouseFeeList(propertyFeeList);
			break;
		case ZPaidFeeDetail.WATER_FEE:
			ZContract newWaterContract = getNewContract(contract, newPaidFeeDetail, WATER_FEE);
			contractMapper.updateByPrimaryKeySelective(newWaterContract);
			break;
		case ZPaidFeeDetail.ELECTRIC_FEE:
			ZContract newElectricContract = getNewContract(contract, newPaidFeeDetail, ELECTRIC_FEE);
			contractMapper.updateByPrimaryKeySelective(newElectricContract);
			break;
		default:
			break;
		}

		newPaidFeeDetail.setCompany(contract.getCompany());
		newPaidFeeDetail.setCoporateBody(contract.getCoporateBody());
		newPaidFeeDetail.setContractCode(contract.getContractCode());
		newPaidFeeDetail.setChargeMan(loginUser.getName());
		newPaidFeeDetail.setPaidTime(new Date());
		paidFeeDetailMapper.insert(newPaidFeeDetail);

		return ZManagerResult.success(newPaidFeeDetail);
	}

	private ZContract getNewContract(ZContract contract, ZPaidFeeDetail newPaidFeeDetail, int feeType) {
		ZContract newContract = new ZContract();
		if (WATER_FEE == feeType) {
			newContract.setTotalPaidWaterFee(contract.getTotalPaidWaterFee() + newPaidFeeDetail.getPaidFee());
		} else {
			newContract.setTotalPaidElectricFee(contract.getTotalPaidElectricFee() + newPaidFeeDetail.getPaidFee());
		}
		newContract.setId(contract.getId());
		newContract.setModifyEmp(newPaidFeeDetail.getCreateEmp());
		newContract.setModifyEmpId(newPaidFeeDetail.getCreateEmpId());
		newContract.setModifyTime(newPaidFeeDetail.getCreateTime());
		
		return newContract;
	}

	private static int RENT_HOSUE_FEE = 0;
	
	private static int PROPERTY_HOUSE_FEE = 1;

	private List<ZHouseFee> getPropertyFeeList(ZPaidFeeDetail newPaidFeeDetail) {
		List<ZHouseFee> dbHouseFeeList = getHouseFeeListFromDB(newPaidFeeDetail.getContractId());
		List<ZHouseFee> undoneHouseFeeList = dbHouseFeeList.stream().filter(ZChargeServiceImpl::isUndonePropertyHouseFee).collect(Collectors.toList());
		if (CommonUtils.isListEmpty(undoneHouseFeeList)) {
			return null;
		}
		undoneHouseFeeList.sort((e1, e2) -> e1.getSort() - e2.getSort());
				
		int restPaidFee = newPaidFeeDetail.getPaidFee();
		List<ZHouseFee> newHouseFeeList = new ArrayList<>();
		for (ZHouseFee houseFee : undoneHouseFeeList) {
			int useFee = getUseFee(houseFee.getTotalPropertyFee(), houseFee.getPaidPropertyFee(), restPaidFee);
			restPaidFee -= useFee;
			
			ZHouseFee newHouseFee = getNewHouseFee(houseFee, useFee, PROPERTY_HOUSE_FEE);
			newHouseFeeList.add(newHouseFee);
			
			if (restPaidFee == 0) {
				break;
			}
		}
		
		return newHouseFeeList;
	}
	
	private static boolean isUndonePropertyHouseFee(ZHouseFee e) {
		return !e.getPaidPropertyFee().equals(e.getTotalPropertyFee());
	}

	private List<ZHouseFee> getRentHouseFeeList(ZPaidFeeDetail newPaidFeeDetail) {
		List<ZHouseFee> dbHouseFeeList = getHouseFeeListFromDB(newPaidFeeDetail.getContractId());
		List<ZHouseFee> undoneHouseFeeList = dbHouseFeeList.stream().filter(ZChargeServiceImpl::isUndoneRentHouseFee).collect(Collectors.toList());
		if (CommonUtils.isListEmpty(undoneHouseFeeList)) {
			return null;
		}
		undoneHouseFeeList.sort((e1, e2) -> e1.getSort() - e2.getSort());
		
		int restPaidFee = newPaidFeeDetail.getPaidFee();
		List<ZHouseFee> newHouseFeeList = new ArrayList<>();
		for (ZHouseFee houseFee : undoneHouseFeeList) {
			int useFee = getUseFee(houseFee.getTotalRentFee(), houseFee.getPaidRentFee(), restPaidFee);
			restPaidFee -= useFee;
			
			ZHouseFee newHouseFee = getNewHouseFee(houseFee, useFee, RENT_HOSUE_FEE);
			newHouseFeeList.add(newHouseFee);
			
			if (restPaidFee == 0) {
				break;
			}
		}
		
		return newHouseFeeList;
	}
	
	private ZHouseFee getNewHouseFee(ZHouseFee houseFee, int useFee, int type) {
		ZHouseFee newHouseFee = new ZHouseFee();
		newHouseFee.setId(houseFee.getId());
		if (type == RENT_HOSUE_FEE) {
			newHouseFee.setPaidRentFee(houseFee.getPaidRentFee() + useFee);
		} else {
			newHouseFee.setPaidPropertyFee(houseFee.getPaidPropertyFee() + useFee);
		}
		
		return newHouseFee;
	}

	

	private static boolean isUndoneRentHouseFee(ZHouseFee e) {
		return !e.getPaidRentFee().equals(e.getTotalRentFee());
	}

	private int getUseFee(Integer totalRentFee, Integer paidRentFee, int restPaidFee) {
		int restFee = totalRentFee - paidRentFee;
		int useFee = restFee;
		if (restFee > restPaidFee) {
			useFee = restPaidFee;
		}
		
		return useFee;
	}
	
	private List<ZHouseFee> getHouseFeeListFromDB(Integer contractId) {
		ZHouseFeeExample example = new ZHouseFeeExample();
		example.createCriteria().andContractIdEqualTo(contractId);
		return houseFeeMapper.selectByExample(example);
	}

	private ZPaidFeeDetail getNewPaidFeeDetail(ZContract contract, ZPaidFeeDetail paidFeeDetail, LoginUser loginUser) {
		ZPaidFeeDetail newPaidFeeDetail = new ZPaidFeeDetail();
		BeanUtils.copyProperties(paidFeeDetail, newPaidFeeDetail);
		newPaidFeeDetail.setContractCode(contract.getContractCode());
		newPaidFeeDetail.setCreateEmp(loginUser.getName());
		newPaidFeeDetail.setCreateEmpId(loginUser.getId());
		newPaidFeeDetail.setCreateTime(DateUtils.getCurrentDate());
		newPaidFeeDetail.setStatus(ZPaidFeeDetail.VALID_STATUS);
		return newPaidFeeDetail;
	}

}
