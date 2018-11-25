package cn.zxy.zmanager.service.impl;

import java.util.Calendar;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZElectricRecord;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.dao.mapper.ZElectricMeterMapper;
import cn.zxy.zmanager.dao.mapper.ZElectricRecordMapper;
import cn.zxy.zmanager.dto.ElectricRecordDTO;
import cn.zxy.zmanager.service.ZElectricRecordAddService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.DateUtils;
import lombok.Data;

@Service
public class ZElectricRecordAddServiceImpl implements ZElectricRecordAddService {

	@Autowired
	private ZContractMapper contractMapper;

	@Autowired
	private ZElectricMeterMapper electricMeterMapper;

	@Autowired
	private ZElectricRecordMapper electricRecordMapper;

	@Transactional
	@Override
	public ZManagerResult<?> addElectricRecord(ElectricRecordDTO electricRecordDTO, LoginUser loginUser) {
		ZElectricMeter electricMeterFromDB = electricMeterMapper
				.selectByPrimaryKey(electricRecordDTO.getElectricMeterId());
		if (isIllegalMark(electricRecordDTO, electricMeterFromDB)) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "您录入的电表刻度有误，电表刻度不能小于当前系统的终止刻度，新增失败！");
		}
		ZElectricRecord electricRecord = getElectricRecord(electricMeterFromDB, electricRecordDTO, loginUser);
		ZElectricMeter newElectricMeter = getNewElectricMeter(electricMeterFromDB, electricRecord, loginUser);
		ZContract newContract = getNewContract(newElectricMeter, loginUser);

		electricMeterMapper.updateByPrimaryKeySelective(newElectricMeter);
		electricRecordMapper.insertSelective(electricRecord);
		contractMapper.updateByPrimaryKeySelective(newContract);

		return ZManagerResult.success();
	}

	private boolean isIllegalMark(ElectricRecordDTO electricRecordDTO, ZElectricMeter electricMeterFromDB) {
		int oldMark = Optional.ofNullable(electricMeterFromDB.getTotalUseElectric()).orElse(0)
				+ Optional.ofNullable(electricMeterFromDB.getInitMark()).orElse(0);
		return electricRecordDTO.getCurrentMark() < oldMark;
	}

	private ZContract getNewContract(ZElectricMeter newElectricMeter, LoginUser loginUser) {
		ZContract contractFromDB = contractMapper.selectByPrimaryKey(newElectricMeter.getContractId());
		ZContract e = ZElectricMeter.genContract(newElectricMeter);
		e.setTotalUseElectric(contractFromDB.getTotalUseElectric() + e.getTotalUseElectric());
		e.setTotalUseElectricFee(e.getTotalUseElectric() * contractFromDB.getElectricFee());
		e.setModifyTime(DateUtils.getCurrentDate());
		e.setModifyEmp(loginUser.getName());
		e.setModifyEmpId(loginUser.getId());

		return e;
	}

	private ZElectricMeter getNewElectricMeter(ZElectricMeter electricMeterFromDB, ZElectricRecord electricRecord,
			LoginUser loginUser) {
		ZElectricMeter e = ZElectricRecord.genElectricMeter(electricRecord);
		e.setContractId(electricMeterFromDB.getContractId());
		e.setId(electricMeterFromDB.getId());
		e.setTotalUseElectric(e.getTotalUseElectric() - electricMeterFromDB.getInitMark());
		e.setTotalUseElectricFee(electricMeterFromDB.getElectricFee() * e.getTotalUseElectric());
		e.setModifyTime(DateUtils.getCurrentDate());
		e.setModifyEmp(loginUser.getName());
		e.setModifyEmpId(loginUser.getId());
		e.setModifyTime(DateUtils.getCurrentDate());

		return e;
	}

	private ZElectricRecord getElectricRecord(ZElectricMeter electricMeterFromDB, ElectricRecordDTO electricRecordDTO,
			LoginUser loginUser) {
		ZElectricRecord record = ZElectricMeter.genElectricMeterRecord(electricMeterFromDB);
		Calendar c = Calendar.getInstance();
		c.setTime(electricRecordDTO.getMarkDate());
		record.setMarkDate(electricRecordDTO.getMarkDate());
		record.setYear(c.get(Calendar.YEAR));
		record.setMonth(c.get(Calendar.MONTH) + 1);
		record.setEndMark(electricRecordDTO.getCurrentMark());
		record.setElectricMeterCode(electricMeterFromDB.getElectricMeterCode());
		record.setCreateEmp(loginUser.getName());
		record.setCreateEmpId(loginUser.getId());
		record.setCreateTime(DateUtils.getCurrentDate());

		return record;
	}

}
