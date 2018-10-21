package cn.zxy.zmanager.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZContractExample;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.service.ZContractService;
import cn.zxy.zmanager.support.common.ZManagerResult;

@Service
public class ZContractServiceImpl implements ZContractService {
	
	@Autowired
	private ZContractMapper contractMapper;

	@Override
	public ZManagerResult<List<ZContract>> listContract(int pageNum, int pageSize, String keyWord) {
		PageHelper.startPage(pageNum, pageSize);
		ZContractExample example = new ZContractExample();
		
		if (StringUtils.isNotEmpty(keyWord)) {
			keyWord = "%" + keyWord + "%";
			example.or().andContractCodeLike(keyWord);
			example.or().andMerchantCodeLike(keyWord);
			example.or().andCompanyLike(keyWord);
			example.or().andCoporateBodyLike(keyWord);
		}
		
		Page<ZContract> contractPages = (Page<ZContract>) contractMapper.selectByExample(example);
		return ZManagerResult.success(contractPages.getResult(), contractPages.getPages());
	}

}
