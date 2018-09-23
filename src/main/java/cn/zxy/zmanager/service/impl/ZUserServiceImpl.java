package cn.zxy.zmanager.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zxy.zmanager.common.ResultCode;
import cn.zxy.zmanager.common.ZManagerResult;
import cn.zxy.zmanager.common.constant.ZUserConstant;
import cn.zxy.zmanager.common.utils.CommonUtils;
import cn.zxy.zmanager.dao.dataobject.ZUser;
import cn.zxy.zmanager.dao.dataobject.ZUserExample;
import cn.zxy.zmanager.dao.mapper.ZUserMapper;
import cn.zxy.zmanager.service.ZUserService;

@Service
public class ZUserServiceImpl implements ZUserService {

	@Autowired
	private ZUserMapper userMapper;

	@Override
	public ZManagerResult login(ZUser user, HttpServletRequest request) {
		ZUserExample example = new ZUserExample();
		ZUserExample.Criteria cri = example.createCriteria();

		cri.andAccountEqualTo(user.getAccount()).andPasswordEqualTo(user.getPassword());
		List<ZUser> users = userMapper.selectByExample(example);

		if (CommonUtils.isListEmpty(users)) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "账号或密码有误");
		}
		users.get(0).setPassword("");
		request.getSession().setAttribute(ZUserConstant.USER_LOGIN_SUCCESS, users.get(0));
		return ZManagerResult.success(users.get(0));
	}

	@Override
	public ZManagerResult<ZUser> addUser(ZUser user) {
		ZUserExample example = new ZUserExample();
		ZUserExample.Criteria cri = example.createCriteria();

		cri.andAccountEqualTo(user.getAccount());
		List<ZUser> users = userMapper.selectByExample(example);
		if (users.size() > 0) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "此账号已存在，不能重复添加");
		}

		user.setCreateTime(CommonUtils.getFormatTime());
		int result = userMapper.insert(user);

		if (result > 0) {
			user.setPassword("");
			return ZManagerResult.success(user);
		}

		return ZManagerResult.fail(ResultCode.FAILURE);
	}

	@Override
	public ZManagerResult<ZUser> updateUser(ZUser user) {
		user.setUpdateTime(CommonUtils.getFormatTime());
		int result = userMapper.updateByPrimaryKeySelective(user);
		if (result > 0) {
			return ZManagerResult.success();
		}

		return ZManagerResult.fail(ResultCode.FAILURE);
	}

	@Override
	public ZManagerResult<List<ZUser>> listUsers(ZUser user) {
		ZUserExample example = new ZUserExample();
		ZUserExample.Criteria cri = example.or();

		if (user.getAccount() != null) {
			cri.andAccountLike(user.getAccount());
		}
		if (user.getName() != null) {
			cri.andNameLike(user.getName());
		}
		example.setOrderByClause("id");
		List<ZUser> users = userMapper.selectByExample(example);
		return ZManagerResult.success(users);
	}

	@Override
	public ZManagerResult deleteUserByPrimaryKey(Integer id) {
		int result = userMapper.deleteByPrimaryKey(id);
		if (result > 0) {
			return ZManagerResult.success();
		}

		return ZManagerResult.fail(ResultCode.FAILURE);
	}

}
