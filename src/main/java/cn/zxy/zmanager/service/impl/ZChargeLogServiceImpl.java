package cn.zxy.zmanager.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.beans.BeanUtils;
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
//		ZPaidFeeDetailExample example = getPaidFeeDetailExample(searchDTO);
//		
//		Page<ZPaidFeeDetail> result = (Page<ZPaidFeeDetail>) feeDetailMapper.selectByExample(example);
		if (searchDTO.getKeyWord() != null) {
			searchDTO.setKeyWord("%" + searchDTO.getKeyWord().trim() + "%");
		}
		Page<ZPaidFeeDetail> result = (Page<ZPaidFeeDetail>) feeDetailMapper.selectByPaidFeeDetailSearchDTO(searchDTO);
		List<ZPaidFeeDetail> newPaidFeeDetailList = getNewPaidFeeDetailList(result);
		
		return ZManagerResult.success(newPaidFeeDetailList, result.getPages());
	}


	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ZPaidFeeDetail>> listChargeLog(PaidFeeDetailSearchDTO searchDTO) {
//		ZPaidFeeDetailExample example = getPaidFeeDetailExample(searchDTO);
//		List<ZPaidFeeDetail> result = feeDetailMapper.selectByExample(example);
//		List<ZPaidFeeDetail> newPaidFeeDetailList = getNewPaidFeeDetailList(result);
		if (searchDTO.getKeyWord() != null) {
			searchDTO.setKeyWord("%" + searchDTO.getKeyWord().trim() + "%");
		}
		List<ZPaidFeeDetail> result = feeDetailMapper.selectByPaidFeeDetailSearchDTO(searchDTO);
		List<ZPaidFeeDetail> newPaidFeeDetailList = getNewPaidFeeDetailList(result);
		return ZManagerResult.success(newPaidFeeDetailList);
	}
	
	private List<ZPaidFeeDetail> getNewPaidFeeDetailList(List<ZPaidFeeDetail> result) {
		return result.stream().map(ZChargeLogServiceImpl::genNewPaidFeeDetail).collect(Collectors.toList());
	}
	
	private static ZPaidFeeDetail genNewPaidFeeDetail(ZPaidFeeDetail e) {
		ZPaidFeeDetail result = new ZPaidFeeDetail();
		BeanUtils.copyProperties(e, result);
		result.setReceiptCode(result.getId() + result.getReceiptCode());
		
		return result;
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
			example.or().andPaidManLike(keyWord);
			example.or().andCompanyLike(keyWord);
			example.or().andCoporateBodyLike(keyWord);
		}
		
		return example;
	}

}
