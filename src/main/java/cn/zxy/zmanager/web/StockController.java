package cn.zxy.zmanager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zxy.zmanager.dao.dataobject.ZStockInLog;
import cn.zxy.zmanager.dao.dataobject.ZStockOutLog;
import cn.zxy.zmanager.service.ZStockService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.annotation.User;
import cn.zxy.zmanager.support.common.ZManagerResult;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
@RestController
@RequestMapping("stock")
public class StockController {

	@Autowired
	private ZStockService stockService;
	
	@PostMapping("in")
	public ZManagerResult<?> addStockInLog(@RequestBody ZStockInLog inLog, @User LoginUser loginUser) {
		return stockService.addStockInLog(inLog, loginUser);
	}
	
	// 只能修改物资名，类型，规格，存储地址和备注
	@PostMapping("out")
	public ZManagerResult<?> addStockOutLog(@RequestBody ZStockOutLog outLog, @User LoginUser loginUser) {
		return stockService.addStockOutLog(outLog, loginUser);
	}

	@GetMapping("list/material/in")
	public ZManagerResult<List<ZStockInLog>> listStockInLog(Integer materialId) {
		return stockService.listStockInLog(materialId);
	}

	@GetMapping("list/material/out")
	public ZManagerResult<List<ZStockOutLog>> listStockOutLog(Integer materialId) {
		return stockService.listStockOutLog(materialId);
	}
	
}
