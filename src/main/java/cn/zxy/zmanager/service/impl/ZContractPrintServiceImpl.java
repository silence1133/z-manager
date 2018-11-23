package cn.zxy.zmanager.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZContractHouse;
import cn.zxy.zmanager.dao.dataobject.ZContractHouseExample;
import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZElectricMeterExample;
import cn.zxy.zmanager.dao.dataobject.ZHouseFee;
import cn.zxy.zmanager.dao.dataobject.ZHouseFeeExample;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeterExample;
import cn.zxy.zmanager.dao.mapper.ZContractHouseMapper;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.dao.mapper.ZElectricMeterMapper;
import cn.zxy.zmanager.dao.mapper.ZHouseFeeMapper;
import cn.zxy.zmanager.dao.mapper.ZWaterMeterMapper;
import cn.zxy.zmanager.dto.ChargeMainInfoDto;
import cn.zxy.zmanager.dto.ContractPrintDTO;
import cn.zxy.zmanager.dto.HouseFeeDetailDto;
import cn.zxy.zmanager.service.ZContractPrintService;
import cn.zxy.zmanager.support.common.ZManagerResult;

@Service
public class ZContractPrintServiceImpl implements ZContractPrintService {

	@Autowired
	private ZContractMapper contractMapper;

	@Autowired
	private ZContractHouseMapper contractHouseMapper;

	@Autowired
	private ZElectricMeterMapper electricMeterMapper;

	@Autowired
	private ZWaterMeterMapper waterMeterMapper;

	@Autowired
	private ZHouseFeeMapper houseFeeMapper;

	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<ContractPrintDTO> printContract(Integer contractId) {
		ZContract contract = contractMapper.selectByPrimaryKey(contractId);
		List<ZContractHouse> contractHouseList = getContractHouseList(contractId);
		List<ZElectricMeter> electricMeterList = getElectricMeterList(contractId);
		List<ZWaterMeter> waterMeterList = getWaterMeterList(contractId);
		List<HouseFeeDetailDto> houseFeeList = getHouseFeeDetailDtoList(contractId);
		ChargeMainInfoDto chargeMainInfo = getChargeMainInfoDto(contract, houseFeeList);

		ContractPrintDTO contractPrintDTO = new ContractPrintDTO(contract, contractHouseList, waterMeterList,
				electricMeterList, houseFeeList, chargeMainInfo);
		return ZManagerResult.success(contractPrintDTO);
	}

	private ChargeMainInfoDto getChargeMainInfoDto(ZContract contract, List<HouseFeeDetailDto> feeDetailDtoList) {
		ChargeMainInfoDto result = new ChargeMainInfoDto();
		result.setCompany(contract.getCompany());
		result.setContractCode(contract.getContractCode());
		result.setContractId(contract.getId());
		result.setCoporateBody(contract.getCoporateBody());
		result.setMerchantCode(contract.getMerchantCode());

		result.setPaidElectricFee(contract.getTotalPaidElectricFee());
		result.setUsedElectricFee(contract.getTotalUseElectricFee());
		result.setRestElectricFee(contract.getTotalPaidElectricFee() - contract.getTotalUseElectricFee());

		result.setPaidWaterFee(contract.getTotalPaidWaterFee());
		result.setTotalWaterFee(contract.getTotalUseWaterFee());
		int restWaterFee = contract.getTotalUseWaterFee() - contract.getTotalPaidWaterFee();
		if (restWaterFee < 0) {
			restWaterFee = 0;
		}
		result.setRestWaterFee(restWaterFee);

		result.setPaidPropertyFee(feeDetailDtoList.stream().mapToInt(HouseFeeDetailDto::getPaidPropertyFee).sum());
		result.setPaidRentFee(feeDetailDtoList.stream().mapToInt(HouseFeeDetailDto::getPaidRentFee).sum());
		result.setTotalPropertyFee(feeDetailDtoList.stream().mapToInt(HouseFeeDetailDto::getTotalPropertyFee).sum());
		result.setTotalRentFee(feeDetailDtoList.stream().mapToInt(HouseFeeDetailDto::getTotalRentFee).sum());
		result.setRestPropertyFee(feeDetailDtoList.stream().mapToInt(HouseFeeDetailDto::getRestPropertyFee).sum());
		result.setRestRentFee(feeDetailDtoList.stream().mapToInt(HouseFeeDetailDto::getRestRentFee).sum());

		return result;
	}

	private List<HouseFeeDetailDto> getHouseFeeDetailDtoList(Integer contractId) {
		List<ZHouseFee> houseFeeList = getHouseFeeList(contractId);
		return houseFeeList.stream().map(ZContractPrintServiceImpl::houseFeeToDetailDto).collect(Collectors.toList())
				.stream().collect(Collectors.groupingBy(e -> e.getContractId() + "=" + e.getSortYear())).values()
				.stream().map(ZContractPrintServiceImpl::mergeHouseFeeDetailDtoList).collect(Collectors.toList());
	}

	private static HouseFeeDetailDto mergeHouseFeeDetailDtoList(List<HouseFeeDetailDto> e) {
		return e.stream().reduce(ZContractPrintServiceImpl::mergeHouseFeeDetailDto).get();
	}

	private static HouseFeeDetailDto mergeHouseFeeDetailDto(HouseFeeDetailDto e1, HouseFeeDetailDto e2) {
		HouseFeeDetailDto e = new HouseFeeDetailDto();
		BeanUtils.copyProperties(e1, e);
		e.setPaidPropertyFee(e1.getPaidPropertyFee() + e2.getPaidPropertyFee());
		e.setPaidRentFee(e1.getPaidRentFee() + e2.getPaidRentFee());
		e.setTotalPropertyFee(e1.getTotalPropertyFee() + e2.getTotalPropertyFee());
		e.setTotalRentFee(e1.getTotalRentFee() + e2.getTotalRentFee());
		e.setRestPropertyFee(e1.getRestPropertyFee() + e2.getRestPropertyFee());
		e.setRestRentFee(e1.getRestRentFee() + e2.getRestRentFee());

		return e;
	}

	private static HouseFeeDetailDto houseFeeToDetailDto(ZHouseFee e) {
		HouseFeeDetailDto detailDto = new HouseFeeDetailDto();
		detailDto.setContractId(e.getContractId());
		detailDto.setPaidPropertyFee(e.getPaidPropertyFee());
		detailDto.setPaidRentFee(e.getPaidRentFee());
		detailDto.setTotalPropertyFee(e.getTotalPropertyFee());
		detailDto.setTotalRentFee(e.getTotalRentFee());
		detailDto.setRestPropertyFee(e.getTotalPropertyFee() - e.getPaidPropertyFee());
		detailDto.setRestRentFee(e.getTotalRentFee() - e.getPaidRentFee());
		detailDto.setPayDeadline(e.getPayDeadline());
		detailDto.setSortYear(e.getSort());

		return detailDto;
	}

	private List<ZHouseFee> getHouseFeeList(Integer contractId) {
		ZHouseFeeExample example = new ZHouseFeeExample();
		example.createCriteria().andContractIdEqualTo(contractId);
		return houseFeeMapper.selectByExample(example);
	}

	private List<ZWaterMeter> getWaterMeterList(Integer contractId) {
		ZWaterMeterExample example = new ZWaterMeterExample();
		example.createCriteria().andContractIdEqualTo(contractId);
		return waterMeterMapper.selectByExample(example);
	}

	private List<ZElectricMeter> getElectricMeterList(Integer contractId) {
		ZElectricMeterExample example = new ZElectricMeterExample();
		example.createCriteria().andContractIdEqualTo(contractId);
		return electricMeterMapper.selectByExample(example);
	}

	private List<ZContractHouse> getContractHouseList(Integer contractId) {
		ZContractHouseExample example = new ZContractHouseExample();
		example.createCriteria().andContractIdEqualTo(contractId);
		return contractHouseMapper.selectByExample(example);
	}

}
