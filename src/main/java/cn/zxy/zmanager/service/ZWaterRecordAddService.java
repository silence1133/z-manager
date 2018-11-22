package cn.zxy.zmanager.service;

import cn.zxy.zmanager.dto.WaterRecordDTO;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZWaterRecordAddService {

	ZManagerResult<?> addWaterRecord(WaterRecordDTO waterRecordDTO, LoginUser loginUser);

}
