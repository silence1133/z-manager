package cn.zxy.zmanager.service;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZStockInLog;
import cn.zxy.zmanager.dao.dataobject.ZStockOutLog;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZStockService {

	ZManagerResult<?> addStockInLog(ZStockInLog inLog, LoginUser loginUser);

	ZManagerResult<?> addStockOutLog(ZStockOutLog outLog, LoginUser loginUser);

	ZManagerResult<List<ZStockInLog>> listStockInLog(Integer materialId);

	ZManagerResult<List<ZStockOutLog>> listStockOutLog(Integer materialId);

}
