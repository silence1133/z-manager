package cn.zxy.zmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zxy.zmanager.dao.dataobject.ZPaidFeeDetail;
import cn.zxy.zmanager.dao.mapper.ZPaidFeeDetailMapper;
import cn.zxy.zmanager.service.ZChargeService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

@Service
public class ZChargeServiceImpl implements ZChargeService {
	
	@Autowired
	private ZPaidFeeDetailMapper paidFeeDetailMapper;

	@Override
	public ZManagerResult<?> addCharge(ZPaidFeeDetail paidFeeDetail, LoginUser loginUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
