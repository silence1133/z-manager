package cn.zxy.zmanager.service.impl;

import java.util.ArrayList;
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
import cn.zxy.zmanager.dao.mapper.ZContractHouseMapper;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
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
		List<ZContractHouse> houseList = contractHouseMapper.selectByContractIdList(contractIdList);

		Map<Integer, List<ZContractHouse>> kOfcontractIdAndVOfHouseListMap = houseList.stream()
				.collect(Collectors.groupingBy(ZContractHouse::getContractId));
		
		return contractList.stream().map(e -> {
			ZContract contract = new ZContract();
			BeanUtils.copyProperties(e, contract);
			List<ZContractHouse> contractHouseList = kOfcontractIdAndVOfHouseListMap.get(contract.getId());
			return new ZContractListDto(contract, contractHouseList);
		}).collect(Collectors.toList());
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
