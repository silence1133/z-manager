package cn.zxy.zmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZElectricMeterExample;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeterExample;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.dao.mapper.ZWaterMeterMapper;
import cn.zxy.zmanager.service.ZWaterMeterService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.DateUtils;

@Service
public class ZWaterMeterServiceImpl implements ZWaterMeterService {
	
	@Autowired
	private ZWaterMeterMapper waterMapper;
	
	@Autowired
	private ZContractMapper contractMapper;

	@Override
	public ZManagerResult<ZWaterMeter> addWaterMeter(ZWaterMeter waterMeter, LoginUser loginUser) {
		waterMeter.setWaterMeterCode(waterMeter.getWaterMeterCode().trim());
		
		List<ZWaterMeter> meterListFromDB = getMeterListByMeterCodeAndStatus(waterMeter.getWaterMeterCode(), ZWaterMeter.USING_STATUS);
		if (meterListFromDB.size() > 0) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "水表编号已被使用，新增失败！");
		}
		
		ZContract contract = contractMapper.selectByPrimaryKey(waterMeter.getContractId());
		waterMeter.setContractCode(contract.getContractCode());
		waterMeter.setCreateEmp(loginUser.getName());
		waterMeter.setCreateEmpId(loginUser.getId());
		waterMeter.setCreateTime(DateUtils.getCurrentDate());
		waterMeter.setStatus(ZWaterMeter.USING_STATUS);
		
		waterMapper.insert(waterMeter);
		
		return ZManagerResult.success(waterMeter);
	}

	private List<ZWaterMeter> getMeterListByMeterCodeAndStatus(String waterMeterCode, Integer usingStatus) {
		ZWaterMeterExample example = new ZWaterMeterExample();
		example.createCriteria().andWaterMeterCodeEqualTo(waterMeterCode).andStatusEqualTo(usingStatus);
		return waterMapper.selectByExample(example);
	}
	
	@Override
	public ZManagerResult<List<ZWaterMeter>> listWaterMeterByContractId(Integer contractId) {
		ZWaterMeterExample example = new ZWaterMeterExample();
		example.createCriteria().andContractIdEqualTo(contractId);
		List<ZWaterMeter> data = waterMapper.selectByExample(example);
		
		return ZManagerResult.success(data);
	}

}
