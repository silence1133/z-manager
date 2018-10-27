package cn.zxy.zmanager.service;

import cn.zxy.zmanager.dao.dataobject.ZPaidFeeDetail;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZChargeService {

	ZManagerResult<?> addCharge(ZPaidFeeDetail paidFeeDetail, LoginUser loginUser);

}
