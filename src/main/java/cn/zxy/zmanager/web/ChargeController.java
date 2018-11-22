package cn.zxy.zmanager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zxy.zmanager.dao.dataobject.ZPaidFeeDetail;
import cn.zxy.zmanager.dto.ChargeShowInfoDto;
import cn.zxy.zmanager.dto.PaidFeeDetailSearchDTO;
import cn.zxy.zmanager.service.ZChargeLogService;
import cn.zxy.zmanager.service.ZChargeService;
import cn.zxy.zmanager.service.ZChargeShowService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.annotation.User;
import cn.zxy.zmanager.support.common.ZManagerResult;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
@RestController
@RequestMapping("charge")
public class ChargeController {

	@Autowired
	private ZChargeService chargeService;
	
	@Autowired
	private ZChargeShowService chargeShowService;
	
	@Autowired
	private ZChargeLogService chargeLogService;
	

	@PostMapping("add")
	public ZManagerResult<?> addCharge(@RequestBody ZPaidFeeDetail paidFeeDetail, @User LoginUser loginUser) {
		return chargeService.addCharge(paidFeeDetail, loginUser);
	}

	@GetMapping("list")
	public ZManagerResult<List<ChargeShowInfoDto>> listContract(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, String keyWord) {
		return chargeShowService.listChargeShowInfo(pageNum, pageSize, keyWord);
	}
	
	@GetMapping("log/list")
	public ZManagerResult<List<ZPaidFeeDetail>> listContractPaidFee(int contractId, int feeType) {
		return chargeLogService.listChargeLog(contractId, feeType);
	}
	
	@GetMapping("log/page")
	public ZManagerResult<?> listPaidFeeDetail(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, PaidFeeDetailSearchDTO searchDTO) {
		return chargeLogService.listChargeLog(pageNum, pageSize, searchDTO);
	}
	
	@GetMapping("log/all")
	public ZManagerResult<List<ZPaidFeeDetail>> listPaidFeeDetail(PaidFeeDetailSearchDTO searchDTO) {
		return chargeLogService.listChargeLog(searchDTO);
	}
	

}
