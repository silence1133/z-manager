package cn.zxy.zmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zxy.zmanager.dao.dataobject.ZPaidFeeDetail;
import cn.zxy.zmanager.dao.dataobject.ZPaidFeeDetailExample;
import cn.zxy.zmanager.dao.mapper.ZPaidFeeDetailMapper;
import cn.zxy.zmanager.service.ZChargeLogService;
import cn.zxy.zmanager.support.common.ZManagerResult;

@Service
public class ZChargeLogServiceImpl implements ZChargeLogService {

	@Autowired
	private ZPaidFeeDetailMapper feeDetailMapper;
	
	@Override
	public ZManagerResult<List<ZPaidFeeDetail>> listChargeLog(int contractId, int feeType) {
		ZPaidFeeDetailExample example = new ZPaidFeeDetailExample();
		example.createCriteria().andContractIdEqualTo(contractId).andFeeTypeEqualTo(feeType);
		List<ZPaidFeeDetail> result = feeDetailMapper.selectByExample(example);
		
		return ZManagerResult.success(result);
	}

}
