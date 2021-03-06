package cn.zxy.zmanager.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.zxy.zmanager.dao.dataobject.ZContractHouseExample;
import cn.zxy.zmanager.dao.dataobject.ZHouse;
import cn.zxy.zmanager.dao.dataobject.ZHouseExample;
import cn.zxy.zmanager.dao.mapper.ZContractHouseMapper;
import cn.zxy.zmanager.dao.mapper.ZHouseMapper;
import cn.zxy.zmanager.service.ZHouseService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.CommonUtils;
import cn.zxy.zmanager.support.common.utils.DateUtils;

@Service
public class ZHouseServiceImpl implements ZHouseService {
	
	@Autowired
	private ZHouseMapper houseMapper;
	
	@Autowired
	private ZContractHouseMapper contractHouseMapper;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public ZManagerResult<ZHouse> addHouse(ZHouse house, LoginUser loginUser) {
		house.setHouseCode(house.getHouseCode().trim());
		ZHouseExample example = new ZHouseExample();
		ZHouseExample.Criteria cri = example.createCriteria();
		cri.andHouseCodeEqualTo(house.getHouseCode());
		List<ZHouse> dbHouses =  houseMapper.selectByExample(example);
		
		if (dbHouses.size() > 0) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "房屋编号已存在，新增失败！");
		}
		
		house.setCreateEmp(loginUser.getName());
		house.setCreateEmpId(loginUser.getId());
		house.setCreateTime(DateUtils.getCurrentDate());
		
		int result = houseMapper.insertSelective(house);
		if (result > 0) {
			return ZManagerResult.success(house);
		}
		return ZManagerResult.fail(ResultCode.FAILURE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ZHouse>> listHouse(int pageNum, int pageSize, String keyWord) {
		PageHelper.startPage(pageNum, pageSize);
		ZHouseExample example = new ZHouseExample();
		example.setOrderByClause("create_time desc, modify_time desc");
		if (StringUtils.isNotEmpty(keyWord)) {
			example.or().andHouseCodeLike("%" + keyWord + "%");
			example.or().andAddressLike("%" + keyWord + "%");
		}
		
		Page<ZHouse> housePages = (Page<ZHouse>) houseMapper.selectByExample(example);
		
		return ZManagerResult.success(housePages.getResult(), housePages.getPages());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ZHouse>> listAvailableHouse() {
		ZHouseExample example = new ZHouseExample();
		example.setOrderByClause("create_time desc");
		example.createCriteria().andStatusEqualTo(ZHouse.AVAILABLE_RENT);
		List<ZHouse> houses = houseMapper.selectByExample(example);
		return ZManagerResult.success(houses);
	}

	@Transactional
	@Override
	public ZManagerResult<?> updateHouse(ZHouse house, LoginUser loginUser) {
		ZHouse houseFromDB = houseMapper.selectByPrimaryKey(house.getId());
		if (houseFromDB.getStatus() == ZHouse.ALREADY_RENTED) {
			return ZManagerResult.fail(ResultCode.BAN_MODIFY_HOUSE_STATUS);
		}
		
		house.setHouseCode(null);
		house.setModifyEmp(loginUser.getName());
		house.setModifyEmpId(loginUser.getId());
		house.setModifyTime(DateUtils.getCurrentDate());
		houseMapper.updateByPrimaryKeySelective(house);
		
		return ZManagerResult.success();
	}

	@Transactional
	@Override
	public ZManagerResult<?> deleteHouseByPrimaryKey(Integer houseId) {
		ZContractHouseExample contractHouseExample = new ZContractHouseExample();
		contractHouseExample.createCriteria().andHouseIdEqualTo(houseId);
		if (contractHouseMapper.selectByExample(contractHouseExample).size() > 0) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "此商铺有出租记录，禁止删除!");
		}
		
		houseMapper.deleteByPrimaryKey(houseId);
		return ZManagerResult.success();
	}

}
