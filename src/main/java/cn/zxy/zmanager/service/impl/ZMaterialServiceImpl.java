package cn.zxy.zmanager.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.zxy.zmanager.dao.dataobject.ZMaterial;
import cn.zxy.zmanager.dao.dataobject.ZMaterialExample;
import cn.zxy.zmanager.dao.mapper.ZMaterialMapper;
import cn.zxy.zmanager.service.ZMaterialService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.DateUtils;

@Service
public class ZMaterialServiceImpl implements ZMaterialService {

	@Autowired
	private ZMaterialMapper materialMapper;

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<ZMaterial> addMaterial(ZMaterial material, LoginUser loginUser) {
		material.setName(material.getName().trim());
		if (isExistMateria(material)) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "物资名已存在，新增失败!");
		}

		material.setCreateEmp(loginUser.getName());
		material.setCreateEmpId(loginUser.getId());
		material.setCreateTime(DateUtils.getCurrentDate());
		materialMapper.insertSelective(material);

		return ZManagerResult.success(ResultCode.SUCCESS);
	}

	private boolean isExistMateria(ZMaterial material) {
		ZMaterialExample example = new ZMaterialExample();
		example.createCriteria().andNameEqualTo(material.getName());
		List<ZMaterial> materials = materialMapper.selectByExample(example);
		return materials.size() > 0;
	}

	@Transactional
	@Override
	public ZManagerResult<?> updMaterial(ZMaterial material, LoginUser loginUser) {
		String name = StringUtils.isBlank(material.getName()) ? null : material.getName().trim();
		material.setName(name);
		if (StringUtils.isNotBlank(name) && isExistMateriaName(material)) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "物资名已存在，修改失败!");
		}
		if (StringUtils.isBlank(material.getName())) {
			material.setName(null);
		}
		material.setStockNum(null);
		material.setModifyEmp(loginUser.getName());
		material.setModifyEmpId(loginUser.getId());
		material.setModifyTime(DateUtils.getCurrentDate());
		materialMapper.updateByPrimaryKeySelective(material);

		return ZManagerResult.success(ResultCode.SUCCESS);
	}

	private boolean isExistMateriaName(ZMaterial material) {
		ZMaterialExample example = new ZMaterialExample();
		example.createCriteria().andNameEqualTo(material.getName()).andIdNotEqualTo(material.getId());
		List<ZMaterial> materials = materialMapper.selectByExample(example);

		return materials.size() > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ZMaterial>> listMaterial(int pageNum, int pageSize, String keyWord) {
		ZMaterialExample example = new ZMaterialExample();
		example.setOrderByClause("create_time desc, modify_time desc");
		if (StringUtils.isNotBlank(keyWord)) {
			keyWord = "%" + keyWord + "%";
			example.or().andNameLike(keyWord);
			example.or().andTypeLike(keyWord);
		}
		
		PageHelper.startPage(pageNum, pageSize);
		Page<ZMaterial> materialPage = (Page<ZMaterial>) materialMapper.selectByExample(example);
		
		return ZManagerResult.success(materialPage.getResult(), materialPage.getPages());
	}

}
