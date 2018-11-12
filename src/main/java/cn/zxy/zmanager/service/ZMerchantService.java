package cn.zxy.zmanager.service;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZMerchant;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZMerchantService {

	ZManagerResult<ZMerchant> addMerchant(ZMerchant merchant, LoginUser loginUser);

	ZManagerResult<List<ZMerchant>> listMerchant(int pageNum, int pageSize, String keyWord);

	ZManagerResult<?> updateMerchantStatus(ZMerchant merchant, LoginUser loginUser);

}
