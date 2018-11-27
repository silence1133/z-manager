package cn.zxy.zmanager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZContractExample;
import cn.zxy.zmanager.dao.dataobject.ZContractHouse;
import cn.zxy.zmanager.dao.dataobject.ZHouse;
import cn.zxy.zmanager.dao.dataobject.ZHouseFee;
import cn.zxy.zmanager.dao.dataobject.ZMerchant;
import cn.zxy.zmanager.dao.mapper.ZContractHouseMapper;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.dao.mapper.ZHouseFeeMapper;
import cn.zxy.zmanager.dao.mapper.ZHouseMapper;
import cn.zxy.zmanager.dao.mapper.ZMerchantMapper;
import cn.zxy.zmanager.dto.ZContractAddDto;
import cn.zxy.zmanager.service.ZContractAddService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.DateUtils;

@Service
public class ZContractAddServiceImpl implements ZContractAddService {

	@Autowired
	private ZContractMapper contractMapper;

	@Autowired
	private ZContractHouseMapper contractHouseMapper;

	@Autowired
	private ZHouseFeeMapper houseFeeMapper;

	@Autowired
	private ZMerchantMapper merchantMapper;

	@Autowired
	private ZHouseMapper houseMapper;

	@Transactional
	@Override
	public ZManagerResult<?> addContract(ZContractAddDto contractAddDto, LoginUser loginUser) {
		List<Integer> houseIdList = getHouseIdList(contractAddDto.getHouseList());
		if (houseIdList.size() != contractAddDto.getHouseList().size()) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "存在重复商铺，新增失败！");
		}
		ZContract contract = getContract(contractAddDto.getContract(), loginUser, houseIdList);

		ZContractExample example = new ZContractExample();
		example.createCriteria().andContractCodeEqualTo(contract.getContractCode())
				.andStatusNotEqualTo(ZContract.INVALID_STATUS);
		List<ZContract> dbContracts = contractMapper.selectByExample(example);
		if (dbContracts.size() > 0) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "合同编号已存在，新增失败！");
		}
		contractMapper.insertSelective(contract);

		List<ZContractHouse> contractHouseList = getContractHouseList(contract, contractAddDto, loginUser);
		contractHouseMapper.batchInsert(contractHouseList);

		List<ZHouseFee> houseFeeList = getHouseFeeList(contractHouseList, contractAddDto, contract);
		houseFeeMapper.batchInsert(houseFeeList);

		houseMapper.updateStatusByIdList(houseIdList, ZHouse.ALREADY_RENTED);

		return ZManagerResult.success(contract.getId());
	}

	private List<Integer> getHouseIdList(List<ZHouse> houseList) {
		return houseList.stream().map(ZHouse::getId).distinct().collect(Collectors.toList());
	}

	private List<ZHouseFee> getHouseFeeList(List<ZContractHouse> contractHouseList, ZContractAddDto contractAddDto,
			ZContract contract) {
		List<Integer> rentMonthList = contractAddDto.getRentMonthList();
		List<Integer> propertyMonthList = contractAddDto.getPropertyMonthList();

		List<ZHouseFee> houseFeeList = new ArrayList<>();

		for (int i = 0; i < contract.getRentYear(); i++) {
			int rentMonth = rentMonthList.get(i);
			int propertyMonth = propertyMonthList.get(i);

			for (ZContractHouse contractHouse : contractHouseList) {
				ZHouseFee houseFee = getHouseFee(contractHouse, contract, rentMonth, propertyMonth, i);
				houseFeeList.add(houseFee);
			}
		}

		return houseFeeList;
	}

	private ZHouseFee getHouseFee(ZContractHouse contractHouse, ZContract contract, int rentMonth, int propertyMonth,
			int i) {
		ZHouseFee houseFee = new ZHouseFee();
		houseFee.setArea(contractHouse.getArea());
		houseFee.setCompany(contract.getCompany());
		houseFee.setContractCode(contract.getContractCode());
		houseFee.setContractHouseId(contractHouse.getId());
		houseFee.setContractId(contract.getId());
		houseFee.setCorporateBody(contract.getCoporateBody());
		houseFee.setCreateTime(DateUtils.getCurrentDate());
		houseFee.setHouseCode(contractHouse.getHouseCode());
		houseFee.setHouseId(contractHouse.getId());
		houseFee.setMerchantCode(contract.getMerchantCode());
		houseFee.setMerchantId(contract.getMerchantId());
		Integer totalRentFee = (int) Math.floor(rentMonth * contractHouse.getRentFee() * contractHouse.getArea());
		houseFee.setTotalRentFee(totalRentFee);
		Integer totalPropertyFee = (int) Math
				.floor(propertyMonth * contractHouse.getPropertyFee() * contractHouse.getArea());
		houseFee.setTotalPropertyFee(totalPropertyFee);
		houseFee.setPropertyFee(contractHouse.getPropertyFee());
		houseFee.setRentFee(contractHouse.getRentFee());
		houseFee.setSort(i + 1);
		houseFee.setRentMonth(rentMonth);
		houseFee.setPropertyMonth(propertyMonth);
		houseFee.setPayDeadline(DateUtils.getDate(contract.getStartDate(), i));

		return houseFee;
	}

	private List<ZContractHouse> getContractHouseList(ZContract contract, ZContractAddDto contractAddDto,
			LoginUser loginUser) {
		List<ZHouse> houseList = contractAddDto.getHouseList();
		List<Integer> houseIdList = houseList.stream().map(e -> e.getId()).collect(Collectors.toList());
		List<ZHouse> houseListFromDB = houseMapper.selectByPrimaryKeies(houseIdList);
		return Stream.of(houseList, houseListFromDB).flatMap(List::stream).collect(Collectors.toList()).stream()
				.collect(Collectors.groupingBy(ZHouse::getId)).entrySet().stream()
				.map(e -> e.getValue().stream().reduce(ZContractAddServiceImpl::mergeZHouse).get())
				.map(ZContractAddServiceImpl::houseToContractHouse).map(e -> {
					e.setContractCode(contract.getContractCode());
					e.setContractId(contract.getId());
					e.setCreateEmpId(loginUser.getId());
					e.setCreateEmp(loginUser.getName());
					e.setCreateTime(DateUtils.getCurrentDate());

					return e;
				}).collect(Collectors.toList());
	}

	private ZContract getContract(ZContract contract, LoginUser loginUser, List<Integer> houseIdList) {
		ZMerchant merchant = merchantMapper.selectByPrimaryKey(contract.getMerchantId());
		contract.setContractCode(contract.getContractCode().trim());
		contract.setMerchantCode(merchant.getMerchantCode());
		contract.setCompany(merchant.getCompany());
		contract.setCoporateBody(merchant.getCorporateBody());
		contract.setCreateEmp(loginUser.getName());
		contract.setCreateEmpId(loginUser.getId());
		contract.setCreateTime(DateUtils.getCurrentDate());
		contract.setStatus(ZContract.VALID_STATUS);
		String houseIdsStr = StringUtils.join(houseIdList, ",");
		contract.setHouseIds(houseIdsStr);

		return contract;
	}

	private static ZHouse mergeZHouse(ZHouse e1, ZHouse e2) {
		ZHouse e = new ZHouse();
		ZHouse temp = null;
		if (StringUtils.isEmpty(e1.getHouseCode())) {
			// e1 的 houseCode 为 null，说明 e2 来自于数据库
			// 这时 e2 中的属性复制到新对象 e 中
			BeanUtils.copyProperties(e2, e);
			temp = e1;
		} else {
			// e1 来自于数据库
			BeanUtils.copyProperties(e1, e);
			temp = e2;
		}
		// temp 为来自于前台的数据
		e.setRentFee(temp.getRentFee());
		e.setPropertyFee(temp.getPropertyFee());
		return e;
	}

	private static ZContractHouse houseToContractHouse(ZHouse house) {
		ZContractHouse contractHouse = new ZContractHouse();
		contractHouse.setArea(house.getArea());
		contractHouse.setHouseCode(house.getHouseCode());
		contractHouse.setHouseId(house.getId());
		contractHouse.setPropertyFee(house.getPropertyFee());
		contractHouse.setRentFee(house.getRentFee());

		return contractHouse;
	}

}
