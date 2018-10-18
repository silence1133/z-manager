package cn.zxy.zmanager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zxy.zmanager.dao.dataobject.ZHouse;
import cn.zxy.zmanager.dao.dataobject.ZMerchant;
import cn.zxy.zmanager.service.ZHouseService;
import cn.zxy.zmanager.service.ZMerchantService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.annotation.User;
import cn.zxy.zmanager.support.common.ZManagerResult;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
@RestController
@RequestMapping("house")
public class HouseController {

	@Autowired
	private ZHouseService houseService;

	@PostMapping("add")
	public ZManagerResult<ZHouse> addHouse(@RequestBody ZHouse house, @User LoginUser loginUser) {
		return houseService.addHouse(house, loginUser);
	}

	@GetMapping("list")
	public ZManagerResult<List<ZHouse>> listUsers(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, String keyWord) {
		return houseService.listHouse(pageNum, pageSize, keyWord);
	}

}
