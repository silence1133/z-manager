package cn.zxy.zmanager.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZContractExample;
import cn.zxy.zmanager.dao.dataobject.ZHouseFee;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.dao.mapper.ZHouseFeeMapper;
import cn.zxy.zmanager.dto.ChargeMainInfoDto;
import cn.zxy.zmanager.dto.ChargeShowInfoDto;
import cn.zxy.zmanager.dto.HouseFeeDetailDto;
import cn.zxy.zmanager.service.ZChargeShowService;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.CommonUtils;

@Service
public class ZChargeShowServiceImpl implements ZChargeShowService {

	@Autowired
	private ZContractMapper contractMapper;

	@Autowired
	private ZHouseFeeMapper houseFeeMapper;

	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ChargeShowInfoDto>> listChargeShowInfo(int pageNum, int pageSize, String keyWord) {
		Page<ZContract> contractPage = getContractPage(pageNum, pageSize, keyWord);
		if (CommonUtils.isListEmpty(contractPage.getResult())) {
			return ZManagerResult.success(contractPage.getResult(), contractPage.getPages());
		}
		List<HouseFeeDetailDto> houseFeeDetailDtoList = getHouseFeeDetailDtoList(contractPage.getResult());
		
		List<ChargeShowInfoDto> result = getChargeShowInfoDtoList(contractPage.getResult(), houseFeeDetailDtoList);
		
		return ZManagerResult.success(result, contractPage.getPages());
	}

	private List<ChargeShowInfoDto> getChargeShowInfoDtoList(List<ZContract> contractList,
			List<HouseFeeDetailDto> houseFeeDetailDtoList) {
		Map<Integer, List<HouseFeeDetailDto>> feeDetailDtoMap = houseFeeDetailDtoList.stream().collect(Collectors.groupingBy(HouseFeeDetailDto::getContractId));
		return contractList.stream().map(e -> {
			return getChargeShowInfoDto(e, feeDetailDtoMap.get(e.getId()));
		}).collect(Collectors.toList());
	}
	
	private ChargeShowInfoDto getChargeShowInfoDto(ZContract contract, List<HouseFeeDetailDto> feeDetailDtoList) {
		ChargeMainInfoDto chargeMainInfoDto = getChargeMainInfoDto(contract, feeDetailDtoList);
		return new ChargeShowInfoDto(chargeMainInfoDto, feeDetailDtoList);
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

	private List<HouseFeeDetailDto> getHouseFeeDetailDtoList(List<ZContract> contractList) {
		List<Integer> contractIdList = contractList.stream().map(ZContract::getId).collect(Collectors.toList());
		List<ZHouseFee> houseFeeList = houseFeeMapper.selectByContractIdList(contractIdList);
		List<HouseFeeDetailDto> originDetailDto = houseFeeList.stream().map(ZChargeShowServiceImpl::houseFeeToDetailDto)
				.collect(Collectors.toList());

		return originDetailDto.stream().collect(Collectors.groupingBy(e -> e.getContractId() + "=" + e.getSortYear())).values()
				.stream().map(ZChargeShowServiceImpl::mergeHouseFeeDetailDtoList).collect(Collectors.toList());
	}

	private static HouseFeeDetailDto mergeHouseFeeDetailDtoList(List<HouseFeeDetailDto> e) {
		return e.stream().reduce(ZChargeShowServiceImpl::mergeHouseFeeDetailDto).get();
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

	private Page<ZContract> getContractPage(int pageNum, int pageSize, String keyWord) {
		PageHelper.startPage(pageNum, pageSize);

		ZContractExample example = new ZContractExample();
		if (StringUtils.isNotBlank(keyWord)) {
			keyWord = "%" + keyWord.trim() + "%";
			example.or().andContractCodeLike(keyWord);
			example.or().andMerchantCodeLike(keyWord);
			example.or().andCompanyLike(keyWord);
			example.or().andCoporateBodyLike(keyWord);
		}

		return (Page<ZContract>) contractMapper.selectByExample(example);
	}

}
