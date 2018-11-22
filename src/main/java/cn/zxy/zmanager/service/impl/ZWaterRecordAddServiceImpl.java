package cn.zxy.zmanager.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterRecord;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.dao.mapper.ZWaterMeterMapper;
import cn.zxy.zmanager.dao.mapper.ZWaterRecordMapper;
import cn.zxy.zmanager.dto.WaterRecordDTO;
import cn.zxy.zmanager.service.ZWaterRecordAddService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.DateUtils;

@Service
public class ZWaterRecordAddServiceImpl implements ZWaterRecordAddService {
	
	@Autowired
	private ZWaterRecordMapper waterRecordMapper;

	@Autowired
	private ZWaterMeterMapper waterMeterMapper;

	@Autowired
	private ZContractMapper contractMapper;


	@Transactional
	@Override
	public ZManagerResult<?> addWaterRecord(WaterRecordDTO waterRecordDTO, LoginUser loginUser) {
		ZWaterMeter waterMeterFromDB = waterMeterMapper.selectByPrimaryKey(waterRecordDTO.getWaterMeterId());
		ZWaterRecord waterRecord = getWaterRecrod(waterRecordDTO, waterMeterFromDB, loginUser);
		ZWaterMeter newWaterMeter = getNewWaterMeter(waterMeterFromDB, waterRecord, loginUser);
		ZContract newContract = getNewContract(newWaterMeter, loginUser);
		
		waterMeterMapper.updateByPrimaryKeySelective(newWaterMeter);
		waterRecordMapper.insertSelective(waterRecord);
		contractMapper.updateByPrimaryKeySelective(newContract);
		
		return ZManagerResult.success();
	}


	private ZContract getNewContract(ZWaterMeter newWaterMeter, LoginUser loginUser) {
		ZContract contractFromDB = contractMapper.selectByPrimaryKey(newWaterMeter.getContractId());
		ZContract e = ZWaterMeter.genContract(newWaterMeter);
		e.setTotalUseWater(e.getTotalUseWater() + contractFromDB.getTotalUseWater());
		e.setModifyEmp(loginUser.getName());
		e.setModifyEmpId(loginUser.getId());
		e.setModifyTime(DateUtils.getCurrentDate());
		
		return e;
	}


	private ZWaterMeter getNewWaterMeter(ZWaterMeter waterMeterFromDB, ZWaterRecord waterRecord, LoginUser loginUser) {
		ZWaterMeter e = ZWaterRecord.genWaterMeter(waterRecord);
		e.setContractId(waterMeterFromDB.getContractId());
		e.setId(waterMeterFromDB.getId());
		e.setTotalWater(e.getTotalWater() - waterMeterFromDB.getInitMark());
		e.setTotalWaterFee(waterMeterFromDB.getWaterFee() * e.getTotalWater());
		e.setModifyTime(DateUtils.getCurrentDate());
		e.setModifyEmp(loginUser.getName());
		e.setModifyEmpId(loginUser.getId());
		
		return e;
	}


	private ZWaterRecord getWaterRecrod(WaterRecordDTO waterRecordDTO, ZWaterMeter waterMeterFromDB, LoginUser loginUser) {
		ZWaterRecord record = ZWaterMeter.genWaterMeterRecord(waterMeterFromDB);
		
		record.setEndMark((int)(Math.floor(Double.valueOf(waterRecordDTO.getCurrentMark()))));
		Calendar c = Calendar.getInstance();
		c.setTime(waterRecordDTO.getMarkDate());
		record.setMarkDate(waterRecordDTO.getMarkDate());
		record.setYear(c.get(Calendar.YEAR));
		record.setMonth(c.get(Calendar.MONTH) + 1);
		record.setWaterMeterCode(waterMeterFromDB.getWaterMeterCode());
		record.setCreateEmp(loginUser.getName());
		record.setCreateEmpId(loginUser.getId());
		record.setCreateTime(DateUtils.getCurrentDate());
		
		return record;
	}

}
