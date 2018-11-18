package cn.zxy.zmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zxy.zmanager.dao.dataobject.ZMaterial;
import cn.zxy.zmanager.dao.dataobject.ZStockInLog;
import cn.zxy.zmanager.dao.dataobject.ZStockInLogExample;
import cn.zxy.zmanager.dao.dataobject.ZStockOutLog;
import cn.zxy.zmanager.dao.dataobject.ZStockOutLogExample;
import cn.zxy.zmanager.dao.mapper.ZMaterialMapper;
import cn.zxy.zmanager.dao.mapper.ZStockInLogMapper;
import cn.zxy.zmanager.dao.mapper.ZStockOutLogMapper;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.DateUtils;

@Service
public class ZStockService implements cn.zxy.zmanager.service.ZStockService {
	
	@Autowired
	private ZStockInLogMapper inLogMapper;
	
	@Autowired
	private ZStockOutLogMapper outLogMapper;
	
	@Autowired
	private ZMaterialMapper materialMapper;

	@Transactional
	@Override
	public ZManagerResult<?> addStockInLog(ZStockInLog inLog, LoginUser loginUser) {
		ZMaterial material = getMaterial(inLog.getMaterialId(), inLog.getNum(), loginUser);
		
		inLog.setCreateEmp(loginUser.getName());
		inLog.setCreateEmpId(loginUser.getId());
		inLog.setCreateTime(DateUtils.getCurrentDate());
		
		materialMapper.updateByPrimaryKeySelective(material);
		inLogMapper.insertSelective(inLog);
		
		return ZManagerResult.success();
	}

	private ZMaterial getMaterial(Integer materialId, Integer inNum, LoginUser loginUser) {
		ZMaterial material = materialMapper.selectByPrimaryKey(materialId);
		
		return getNewMaterial(material.getId(), material.getStockNum() + inNum, loginUser);
	}

	@Transactional
	@Override
	public ZManagerResult<?> addStockOutLog(ZStockOutLog outLog, LoginUser loginUser) {
		ZMaterial material = materialMapper.selectByPrimaryKey(outLog.getMaterialId());
		if (outLog.getNum() > material.getStockNum()) {
			return ZManagerResult.fail(ResultCode.OUT_STOCK_NUM_BIG_THAN_STOCK);
		}
		ZMaterial newMaterail = getNewMaterial(material.getId(), material.getStockNum() - outLog.getNum(), loginUser);
		outLog.setCreateEmp(loginUser.getName());
		outLog.setCreateEmpId(loginUser.getId());
		outLog.setCreateTime(DateUtils.getCurrentDate());
		
		materialMapper.updateByPrimaryKeySelective(newMaterail);
		outLogMapper.insertSelective(outLog);
		
		return ZManagerResult.success();
	}

	private ZMaterial getNewMaterial(Integer id, int num, LoginUser loginUser) {
		ZMaterial newMaterial = new ZMaterial();
		newMaterial.setId(id);
		newMaterial.setStockNum(num);
		newMaterial.setModifyEmp(loginUser.getName());
		newMaterial.setModifyEmpId(loginUser.getId());
		newMaterial.setModifyTime(DateUtils.getCurrentDate());
		
		return newMaterial;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ZStockInLog>> listStockInLog(Integer materialId) {
		ZStockInLogExample example = new ZStockInLogExample();
		example.setOrderByClause("create_time desc");
		example.createCriteria().andMaterialIdEqualTo(materialId);
		
		List<ZStockInLog> result = inLogMapper.selectByExample(example);
		return ZManagerResult.success(result);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ZStockOutLog>> listStockOutLog(Integer materialId) {
		ZStockOutLogExample example = new ZStockOutLogExample();
		example.setOrderByClause("create_time desc");
		example.createCriteria().andMaterialIdEqualTo(materialId);
		
		List<ZStockOutLog> result = outLogMapper.selectByExample(example);
		return ZManagerResult.success(result);
	}

	

}
