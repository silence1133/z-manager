package cn.zxy.zmanager.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zxy.zmanager.dao.dataobject.ZElectricRecord;
import cn.zxy.zmanager.service.ZElectricRecordService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

@Service
public class ZElectricRecordServiceImpl implements ZElectricRecordService {

	@Transactional
	@Override
	public ZManagerResult<ZElectricRecord> addElectricRecord(ZElectricRecord electricRecord, LoginUser loginUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
