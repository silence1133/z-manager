package cn.zxy.zmanager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZHouse;
import cn.zxy.zmanager.service.ZElectricMeterService;
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

	@PostMapping("add")
	public ZManagerResult<ZElectricMeter> addElectricMeter(@RequestBody ZElectricMeter electricMeter, @User LoginUser loginUser) {
		return electricMeterService.addElectricMeter(electricMeter, loginUser);
	}

	@GetMapping("list")
	public ZManagerResult<List<ZElectricMeter>> listElectricMeterByContractId(Integer contractId) {
		return electricMeterService.listElectricMeterByContractId(contractId);
	}

}