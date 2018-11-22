package cn.zxy.zmanager.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.zxy.zmanager.dao.dataobject.ZPaidFeeDetail;
import cn.zxy.zmanager.dao.dataobject.ZPaidFeeDetailExample;
import cn.zxy.zmanager.dao.mapper.ZPaidFeeDetailMapper;
import cn.zxy.zmanager.dto.PaidFeeDetailSearchDTO;
import cn.zxy.zmanager.service.ZChargeLogService;
import cn.zxy.zmanager.support.common.ZManagerResult;

@Service
public class ZChargeLogServiceImpl implements ZChargeLogService {

	@Autowired
	private ZPaidFeeDetailMapper feeDetailMapper;
	
	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ZPaidFeeDetail>> listChargeLog(int contractId, int feeType) {
		ZPaidFeeDetailExample example = new ZPaidFeeDetailExample();
		example.setOrderByClause("paid_time desc");
		example.createCriteria().andContractIdEqualTo(contractId).andFeeTypeEqualTo(feeType);
		List<ZPaidFeeDetail> result = feeDetailMapper.selectByExample(example);
		
		return ZManagerResult.success(result);
	}

	@Override
	public ZManagerResult<?> listChargeLog(int pageNum, int pageSize,
			PaidFeeDetailSearchDTO searchDTO) {
		PageHelper.startPage(pageNum, pageSize);
		ZPaidFeeDetailExample example = getPaidFeeDetailExample(searchDTO);
		
		Page<ZPaidFeeDetail> result = (Page<ZPaidFeeDetail>) feeDetailMapper.selectByExample(example);
		
		return ZManagerResult.success(result.getResult(), result.getPages());
	}


	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ZPaidFeeDetail>> listChargeLog(PaidFeeDetailSearchDTO searchDTO) {
		ZPaidFeeDetailExample example = getPaidFeeDetailExample(searchDTO);
		List<ZPaidFeeDetail> result = feeDetailMapper.selectByExample(example);
		return ZManagerResult.success(result);
	}
	
	private ZPaidFeeDetailExample getPaidFeeDetailExample(PaidFeeDetailSearchDTO searchDTO) {
		ZPaidFeeDetailExample example = new ZPaidFeeDetailExample();
		if (searchDTO.getStartPayTime() != null && searchDTO.getEndPayTime() != null) {
			example.createCriteria().andPaidTimeBetween(searchDTO.getStartPayTime(), searchDTO.getEndPayTime());
		}
		if (StringUtils.isNotBlank(searchDTO.getKeyWord())) {
			String keyWord = "%" + searchDTO.getKeyWord() + "%";
			example.or().andChargeManLike(keyWord);
			example.or().andContractCodeLike(keyWord);
			example.or().andCreateEmpLike(keyWord);
		}
		
		return example;
	}

}
