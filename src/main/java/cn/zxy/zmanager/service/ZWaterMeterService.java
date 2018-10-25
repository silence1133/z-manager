package cn.zxy.zmanager.service;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZWaterMeterService {

	ZManagerResult<ZWaterMeter> addWaterMeter(ZWaterMeter waterMeter, LoginUser loginUser);

	ZManagerResult<List<ZWaterMeter>> listWaterMeterByContractId(Integer contractId);

}
