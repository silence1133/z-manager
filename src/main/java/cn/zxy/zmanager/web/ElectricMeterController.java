package cn.zxy.zmanager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZElectricRecord;
import cn.zxy.zmanager.dao.dataobject.ZHouse;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterRecord;
import cn.zxy.zmanager.dto.ElectricRecordDTO;
import cn.zxy.zmanager.service.ZElectricMeterService;
import cn.zxy.zmanager.service.ZElectricRecordAddService;
import cn.zxy.zmanager.service.ZElectricRecordService;
import cn.zxy.zmanager.service.ZEletricMeterManageService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.annotation.User;
import cn.zxy.zmanager.support.common.ZManagerResult;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
@RestController
@RequestMapping("electricMeter")
public class ElectricMeterController {

	@Autowired
	private ZElectricMeterService electricMeterService;
	
	@Autowired
	private ZElectricRecordService electricRecordService;
	
	@Autowired
	private ZElectricRecordAddService electricRecordAddService;
	
	@Autowired
	private ZEletricMeterManageService waterMeterManageService;

	@PostMapping("add")
	public ZManagerResult<ZElectricMeter> addElectricMeter(@RequestBody ZElectricMeter electricMeter, @User LoginUser loginUser) {
		return electricMeterService.addElectricMeter(electricMeter, loginUser);
	}

	@GetMapping("list")
	public ZManagerResult<List<ZElectricMeter>> listElectricMeterByContractId(Integer contractId) {
		return electricMeterService.listElectricMeterByContractId(contractId);
	}
	
	@PostMapping("record/upload")
	public ZManagerResult<?> addElectricRecord(MultipartFile excel, @User LoginUser loginUser) throws Exception {
		return electricRecordService.addElectricRecord(excel, loginUser);
	}
	
	@PostMapping("record/upload")
	public ZManagerResult<?> addElectricRecord(ElectricRecordDTO electricRecordDTO, @User LoginUser loginUser) throws Exception {
		return electricRecordAddService.addElectricRecord(electricRecordDTO, loginUser);
	}
	
	@GetMapping("manage/meter/list")
	public ZManagerResult<List<ZElectricMeter>> listElectricMeter(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, String keyWord) {
		return waterMeterManageService.listElectricMeter(pageNum, pageSize, keyWord);
	}

	@GetMapping("manage/record/list")
	public ZManagerResult<List<ZElectricRecord>> listElectricRecordByMeterId(Integer electricMeterId) {
		return waterMeterManageService.listElectricReocrdByMeterId(electricMeterId);
	}

}
