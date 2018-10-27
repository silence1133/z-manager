package cn.zxy.zmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zxy.zmanager.dao.dataobject.ZPaidFeeDetail;
import cn.zxy.zmanager.service.ZChargeService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.annotation.User;
import cn.zxy.zmanager.support.common.ZManagerResult;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
@RestController
@RequestMapping("contract")
public class ChargeController {

	@Autowired
	private ZChargeService chargeService;
	

	@PostMapping("add")
	public ZManagerResult<?> addCharge(@RequestBody ZPaidFeeDetail paidFeeDetail, @User LoginUser loginUser) {
		return chargeService.addCharge(paidFeeDetail, loginUser);
	}

//	@GetMapping("list")
//	public ZManagerResult<List<ZContractListDto>> listContract(@RequestParam(defaultValue = "1") int pageNum,
//			@RequestParam(defaultValue = "10") int pageSize, String keyWord) {
//		return contractService.listContract(pageNum, pageSize, keyWord);
//	}

}
