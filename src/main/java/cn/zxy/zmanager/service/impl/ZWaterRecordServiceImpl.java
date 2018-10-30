package cn.zxy.zmanager.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.zxy.zmanager.dao.mapper.ZWaterRecordMapper;
import cn.zxy.zmanager.service.ZWaterRecordService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

@Service
public class ZWaterRecordServiceImpl implements ZWaterRecordService {

	@Autowired
	private ZWaterRecordMapper waterRecordMapper;
	
	@Transactional
	@Override
	public ZManagerResult<String> addWaterRecord(MultipartFile excel, LoginUser loginUser) throws IOException {
		File excelFile = getExcelFile(excel);
		return null;
	}

	private File getExcelFile(MultipartFile excel) throws IOException {
		File excelFile = new File(excel.getOriginalFilename());
		excelFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(excelFile); 
	    fos.write(excel.getBytes());
	    fos.close(); 
		return excelFile;
	}

}
