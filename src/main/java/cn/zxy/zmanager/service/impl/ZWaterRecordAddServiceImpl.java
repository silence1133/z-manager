package cn.zxy.zmanager.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

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
import cn.zxy.zmanager.support.common.ResultCode;
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
		if (isIllegalMark(waterRecordDTO)) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "您录入的水表刻度有误，水表刻度不能小于当前系统的终止刻度，新增失败！");
		}
		ZWaterMeter waterMeterFromDB = waterMeterMapper.selectByPrimaryKey(waterRecordDTO.getWaterMeterId());
		ZWaterRecord waterRecord = getWaterRecrod(waterRecordDTO, waterMeterFromDB, loginUser);
		ZWaterMeter newWaterMeter = getNewWaterMeter(waterMeterFromDB, waterRecord, loginUser);
		ZContract newContract = getNewContract(newWaterMeter, loginUser,waterRecord.getEndMark()-waterRecord.getStartMark());

		waterMeterMapper.updateByPrimaryKeySelective(newWaterMeter);
		waterRecordMapper.insertSelective(waterRecord);
		contractMapper.updateByPrimaryKeySelective(newContract);

		return ZManagerResult.success();
	}

	private boolean isIllegalMark(WaterRecordDTO waterRecordDTO) {
		ZWaterMeter waterMeter = waterMeterMapper.selectByPrimaryKey(waterRecordDTO.getWaterMeterId());
		int oldMark = Optional.ofNullable(waterMeter.getTotalWater()).orElse(0)
				+ Optional.ofNullable(waterMeter.getInitMark()).orElse(0);
		return waterRecordDTO.getCurrentMark() < oldMark;
	}

	private ZContract getNewContract(ZWaterMeter newWaterMeter, LoginUser loginUser,Integer currentTotalUse) {
		ZContract contractFromDB = contractMapper.selectByPrimaryKey(newWaterMeter.getContractId());
		ZContract e = ZWaterMeter.genContract(newWaterMeter);
		e.setTotalUseWater(currentTotalUse + contractFromDB.getTotalUseWater());
		e.setTotalUseWaterFee(Optional.ofNullable(e.getTotalUseWater()).orElse(0) * contractFromDB.getWaterFee());
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
		e.setTotalWaterFee(waterMeterFromDB.getWaterFee() * Optional.ofNullable(e.getTotalWater()).orElse(0));
		e.setModifyTime(DateUtils.getCurrentDate());
		e.setModifyEmp(loginUser.getName());
		e.setModifyEmpId(loginUser.getId());

		return e;
	}

	private ZWaterRecord getWaterRecrod(WaterRecordDTO waterRecordDTO, ZWaterMeter waterMeterFromDB,
			LoginUser loginUser) {
		ZWaterRecord record = ZWaterMeter.genWaterMeterRecord(waterMeterFromDB);

		record.setEndMark((int) (Math.floor(Double.valueOf(waterRecordDTO.getCurrentMark()))));
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
