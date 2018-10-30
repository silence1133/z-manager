package cn.zxy.zmanager.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZWaterRecordService {

	ZManagerResult<String> addWaterRecord(MultipartFile excel, LoginUser loginUser) throws IOException;

}
