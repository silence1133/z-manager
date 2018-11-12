package cn.zxy.zmanager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zxy.zmanager.dao.dataobject.ZMerchant;
import cn.zxy.zmanager.service.ZMerchantService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.annotation.User;
import cn.zxy.zmanager.support.common.ZManagerResult;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
@RestController
@RequestMapping("merchant")
public class MerchantController {

	@Autowired
	private ZMerchantService merchantService;

	@PostMapping("add")
	public ZManagerResult<ZMerchant> addMerchant(@RequestBody ZMerchant merchant, @User LoginUser loginUser) {
		return merchantService.addMerchant(merchant, loginUser);
	}

	@GetMapping("list")
	public ZManagerResult<List<ZMerchant>> listMerchant(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, String keyWord) {
		return merchantService.listMerchant(pageNum, pageSize, keyWord);
	}
	
	@PostMapping("update/status")
	public ZManagerResult<?> updateMerchantStatus(@RequestBody ZMerchant merchant, @User LoginUser loginUser) {
		return merchantService.updateMerchantStatus(merchant, loginUser);
	}

}
