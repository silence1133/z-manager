package cn.zxy.zmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZElectricMeterExample;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.dao.mapper.ZElectricMeterMapper;
import cn.zxy.zmanager.service.ZElectricMeterService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.DateUtils;

@Service
public class ZElectricMeterServiceImpl implements ZElectricMeterService {

	@Autowired
	private ZElectricMeterMapper electricMapper;
	
	@Autowired
	private ZContractMapper contractMapper;
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public ZManagerResult<ZElectricMeter> addElectricMeter(ZElectricMeter electricMeter, LoginUser loginUser) {
		electricMeter.setElectricMeterCode(electricMeter.getElectricMeterCode().trim());
		
		List<ZElectricMeter> meterListFromDB = getMeterListByMeterCodeAndStatus(electricMeter.getElectricMeterCode(), ZElectricMeter.USING_STATUS);
		if (meterListFromDB.size() > 0) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "电表编号已被使用，新增失败！");
		}
		
		ZContract contract = contractMapper.selectByPrimaryKey(electricMeter.getContractId());
		electricMeter.setContractCode(contract.getContractCode());
		electricMeter.setCreateEmp(loginUser.getName());
		electricMeter.setCreateEmpId(loginUser.getId());
		electricMeter.setCreateTime(DateUtils.getCurrentDate());
		electricMeter.setStatus(ZElectricMeter.USING_STATUS);
		electricMeter.setElectricFee(contract.getElectricFee());
		
		electricMapper.insertSelective(electricMeter);
		
		return ZManagerResult.success(electricMeter);
	}

	private List<ZElectricMeter> getMeterListByMeterCodeAndStatus(String electricMeterCode, Integer usingStatus) {
		ZElectricMeterExample example = new ZElectricMeterExample();
		example.createCriteria().andElectricMeterCodeEqualTo(electricMeterCode).andStatusEqualTo(usingStatus);
		return electricMapper.selectByExample(example);
	}

	@Override
	public ZManagerResult<List<ZElectricMeter>> listElectricMeterByContractId(Integer contractId) {
		ZElectricMeterExample example = new ZElectricMeterExample();
		example.setOrderByClause("create_time desc");
		example.createCriteria().andContractIdEqualTo(contractId);
		List<ZElectricMeter> data = electricMapper.selectByExample(example);
		
		return ZManagerResult.success(data);
	}

}
