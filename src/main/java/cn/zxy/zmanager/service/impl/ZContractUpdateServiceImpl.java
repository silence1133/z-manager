package cn.zxy.zmanager.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZHouse;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.dao.mapper.ZHouseMapper;
import cn.zxy.zmanager.service.ZContractUpdateService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.DateUtils;

@Service
public class ZContractUpdateServiceImpl implements ZContractUpdateService {
	
	@Autowired
	private ZContractMapper contractMapper;
	
	@Autowired
	private ZHouseMapper houseMapper;

	@Transactional
	@Override
	public ZManagerResult<?> updateContractStatus(ZContract contract, LoginUser loginUser) {
		ZContract contractFromDB = contractMapper.selectByPrimaryKey(contract.getId());
		if (contractFromDB.getStatus() != ZContract.VALID_STATUS) {
			return ZManagerResult.fail(ResultCode.BAN_MODIFY_CONTRACT_STATUS);
		}
		
		updateStatusOfContract(contract, loginUser);
		updateStatusOfHouseList(contractFromDB, loginUser);
		
		return ZManagerResult.success();
	}

	private void updateStatusOfHouseList(ZContract contractFromDB, LoginUser loginUser) {
		String[] houseIdStrArray = contractFromDB.getHouseIds().split(",");
		List<String> houseIdStrList = Arrays.asList(houseIdStrArray);
		List<ZHouse> houseList = houseIdStrList.stream().map(ZContractUpdateServiceImpl::genAvailableRentHouse).collect(Collectors.toList());
		
		houseMapper.updateHouseListStatus(houseList, loginUser);
	}
	
	private static ZHouse genAvailableRentHouse(String houseIdStr) {
		ZHouse result = new ZHouse();
		result.setId(Integer.valueOf(houseIdStr));
		result.setStatus(ZHouse.AVAILABLE_RENT);
		result.setModifyTime(DateUtils.getCurrentDate());
		
		return result;
	}

	private void updateStatusOfContract(ZContract contract, LoginUser loginUser) {
		contract.setModifyEmp(loginUser.getName());
		contract.setModifyEmpId(loginUser.getId());
		contract.setModifyTime(DateUtils.getCurrentDate());
		
		contractMapper.updateByPrimaryKeySelective(contract);
	}

}
