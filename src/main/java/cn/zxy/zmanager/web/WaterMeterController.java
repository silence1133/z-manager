package cn.zxy.zmanager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import cn.zxy.zmanager.service.ZWaterMeterService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.annotation.User;
import cn.zxy.zmanager.support.common.ZManagerResult;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
@RestController
@RequestMapping("waterMeter")
public class WaterMeterController {

	@Autowired
	private ZWaterMeterService waterMeterService;

	@PostMapping("add")
	public ZManagerResult<ZWaterMeter> addWaterMeter(@RequestBody ZWaterMeter waterMeter, @User LoginUser loginUser) {
		return waterMeterService.addWaterMeter(waterMeter, loginUser);
	}

	@GetMapping("list")
	public ZManagerResult<List<ZWaterMeter>> listWaterMeterByContractId(Integer contractId) {
		return waterMeterService.listWaterMeterByContractId(contractId);
	}

}
