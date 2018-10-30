package cn.zxy.zmanager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
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
import cn.zxy.zmanager.dao.dataobject.ZContractHouse;
import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import cn.zxy.zmanager.dao.mapper.ZContractHouseMapper;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.dao.mapper.ZElectricMeterMapper;
import cn.zxy.zmanager.dao.mapper.ZWaterMeterMapper;
import cn.zxy.zmanager.dto.ZContractListDto;
import cn.zxy.zmanager.service.ZContractService;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.CommonUtils;

@Service
public class ZContractServiceImpl implements ZContractService {

	@Autowired
	private ZContractMapper contractMapper;

	@Autowired
	private ZContractHouseMapper contractHouseMapper;
	
	@Autowired
	private ZElectricMeterMapper electricMeterMapper;
	
	@Autowired
	private ZWaterMeterMapper waterMeterMapper;

	@Override
	public ZManagerResult<List<ZContractListDto>> listContract(int pageNum, int pageSize, String keyWord) {
		Page<ZContract> contractPages = getContractPages(pageNum, pageSize, keyWord);
		List<ZContract> contractList = contractPages.getResult();

		if (CommonUtils.isListEmpty(contractList)) {
			return ZManagerResult.success(new ArrayList<>(), contractPages.getPages());
		}

		List<ZContractListDto> result = getZContractListDto(contractList);

		return ZManagerResult.success(result, contractPages.getPages());
	}

	private List<ZContractListDto> getZContractListDto(List<ZContract> contractList) {
		List<Integer> contractIdList = contractList.stream().map(ZContract::getId).collect(Collectors.toList());
		
		Map<Integer, List<ZContractHouse>> kOfcontractIdAndVOfHouseListMap = getKOfcontractIdAndVOfHouseListMap(contractIdList);
		Map<Integer, List<ZWaterMeter>> kOfContractIdAndVofWaterMeterListMap = getKOfContractIdAndVofWaterMeterListMap(contractIdList);
		Map<Integer, List<ZElectricMeter>> kOfContractIdAndVofElectricMeterListMap = getKOfContractIdAndVofElectricMeterListMap(contractIdList);
		
		return contractList.stream().map(e -> {
			ZContract contract = new ZContract();
			BeanUtils.copyProperties(e, contract);
			List<ZContractHouse> contractHouseList = kOfcontractIdAndVOfHouseListMap.get(contract.getId());
			List<ZWaterMeter> waterMeterList = kOfContractIdAndVofWaterMeterListMap.get(contract.getId());
			List<ZElectricMeter> electricMeterList = kOfContractIdAndVofElectricMeterListMap.get(contract.getId());
			return new ZContractListDto(contract, contractHouseList, waterMeterList, electricMeterList);
		}).collect(Collectors.toList());
	}

	private Map<Integer, List<ZElectricMeter>> getKOfContractIdAndVofElectricMeterListMap(
			List<Integer> contractIdList) {
		List<ZElectricMeter> meterList = electricMeterMapper.selectByContractIdList(contractIdList);
		if (CommonUtils.isListEmpty(meterList)) {
			return new HashMap<>();
		}
		return meterList.stream().collect(Collectors.groupingBy(ZElectricMeter::getContractId));
	}

	private Map<Integer, List<ZWaterMeter>> getKOfContractIdAndVofWaterMeterListMap(List<Integer> contractIdList) {
		List<ZWaterMeter> meterList = waterMeterMapper.selectByContractIdList(contractIdList);
		if (CommonUtils.isListEmpty(meterList)) {
			return new HashMap<>();
		}
		return meterList.stream().collect(Collectors.groupingBy(ZWaterMeter::getContractId));
	}

	private Map<Integer, List<ZContractHouse>> getKOfcontractIdAndVOfHouseListMap(List<Integer> contractIdList) {
		List<ZContractHouse> houseList = contractHouseMapper.selectByContractIdList(contractIdList);
		return houseList.stream()
				.collect(Collectors.groupingBy(ZContractHouse::getContractId));
	}

	private Page<ZContract> getContractPages(int pageNum, int pageSize, String keyWord) {
		PageHelper.startPage(pageNum, pageSize);
		ZContractExample example = new ZContractExample();

		if (StringUtils.isNotEmpty(keyWord)) {
			keyWord = "%" + keyWord + "%";
			example.or().andContractCodeLike(keyWord);
			example.or().andMerchantCodeLike(keyWord);
			example.or().andCompanyLike(keyWord);
			example.or().andCoporateBodyLike(keyWord);
		}

		return (Page<ZContract>) contractMapper.selectByExample(example);
	}

}
