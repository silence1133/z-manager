package cn.zxy.zmanager.service;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZContractUpdateService {

	ZManagerResult<?> updateContractStatus(ZContract contract, LoginUser loginUser);

}
