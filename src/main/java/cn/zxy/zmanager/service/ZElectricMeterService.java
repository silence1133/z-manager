package cn.zxy.zmanager.service;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZElectricMeterService {

	ZManagerResult<ZElectricMeter> addElectricMeter(ZElectricMeter electricMeter, LoginUser loginUser);

	ZManagerResult<List<ZElectricMeter>> listElectricMeterByContractId(Integer contractId);

}
