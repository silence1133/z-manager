package cn.zxy.zmanager.service;

import cn.zxy.zmanager.dao.dataobject.ZElectricRecord;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZElectricRecordService {

	ZManagerResult<ZElectricRecord> addElectricRecord(ZElectricRecord electricRecord, LoginUser loginUser);

}
