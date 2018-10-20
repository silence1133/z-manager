package cn.zxy.zmanager.service;

import cn.zxy.zmanager.dto.ZContractAddDto;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZContractAddService {

	ZManagerResult addContract(ZContractAddDto contractAddDto, LoginUser loginUser);

}
