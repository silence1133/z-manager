package cn.zxy.zmanager.service;

import org.springframework.web.multipart.MultipartFile;

import cn.zxy.zmanager.dao.dataobject.ZElectricRecord;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZElectricRecordService {

	ZManagerResult<?> addElectricRecord(MultipartFile excel, LoginUser loginUser) throws Exception;

}
