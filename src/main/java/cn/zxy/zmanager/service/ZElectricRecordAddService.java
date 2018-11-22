package cn.zxy.zmanager.service;

import cn.zxy.zmanager.dto.ElectricRecordDTO;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZElectricRecordAddService {

	ZManagerResult<?> addElectricRecord(ElectricRecordDTO electricRecordDTO, LoginUser loginUser);

}
