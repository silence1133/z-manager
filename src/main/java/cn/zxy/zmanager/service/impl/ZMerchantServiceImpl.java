package cn.zxy.zmanager.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.zxy.zmanager.dao.dataobject.ZMerchant;
import cn.zxy.zmanager.dao.dataobject.ZMerchantExample;
import cn.zxy.zmanager.dao.mapper.ZMerchantMapper;
import cn.zxy.zmanager.service.ZMerchantService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.DateUtils;

@Service
public class ZMerchantServiceImpl implements ZMerchantService {

	@Autowired
	private ZMerchantMapper merchantMapper;

	@Transactional
	@Override
	public ZManagerResult<ZMerchant> addMerchant(ZMerchant merchant, LoginUser loginUser) {
		merchant.setMerchantCode(merchant.getMerchantCode().trim());
		ZMerchantExample example = new ZMerchantExample();
		ZMerchantExample.Criteria cri = example.createCriteria();
		cri.andMerchantCodeEqualTo(merchant.getMerchantCode());
		List<ZMerchant> dbMerchants = merchantMapper.selectByExample(example);
		if (dbMerchants.size() > 0) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "商户编号已存在，新增失败!");
		}
		
		merchant.setStatus(ZMerchant.ON_LINE);
		merchant.setCreateEmp(loginUser.getName());
		merchant.setCreateEmpId(loginUser.getId());
		merchant.setCreateTime(DateUtils.getCurrentDate());

		int result = merchantMapper.insertSelective(merchant);
		if (result > 0) {
			return ZManagerResult.success(merchant);
		}
		return ZManagerResult.fail(ResultCode.FAILURE);
	}

	@Override
	public ZManagerResult<List<ZMerchant>> listMerchant(int pageNum, int pageSize, String keyWord) {
		PageHelper.startPage(pageNum, pageSize);
		ZMerchantExample example = new ZMerchantExample();
		
		if (StringUtils.isNotEmpty(keyWord)) {
			keyWord = "%" + keyWord + "%";
			example.or().andCompanyLike(keyWord);
			example.or().andIdCardLike(keyWord);
			example.or().andLinkManLike(keyWord);
			example.or().andMerchantCodeLike(keyWord);
		}

		Page<ZMerchant> merchantPages = (Page<ZMerchant>) merchantMapper.selectByExample(example);

		return ZManagerResult.success(merchantPages.getResult(), merchantPages.getPages());
	}

}
