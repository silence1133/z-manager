package cn.zxy.zmanager.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.zxy.zmanager.support.LoginUser;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.constant.ZUserConstant;
import cn.zxy.zmanager.support.common.utils.CommonUtils;
import cn.zxy.zmanager.dao.dataobject.ZUser;
import cn.zxy.zmanager.dao.dataobject.ZUserExample;
import cn.zxy.zmanager.dao.mapper.ZUserMapper;
import cn.zxy.zmanager.service.ZUserService;

@Service
public class ZUserServiceImpl implements ZUserService {

	@Autowired
	private ZUserMapper userMapper;

	@Override
	public ZManagerResult<?> login(ZUser user, HttpServletRequest request) {
		ZUserExample example = new ZUserExample();
		ZUserExample.Criteria cri = example.createCriteria();

		cri.andAccountEqualTo(user.getAccount()).andPasswordEqualTo(user.getPassword());
		List<ZUser> users = userMapper.selectByExample(example);

		if (CommonUtils.isListEmpty(users)) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "账号或密码有误");
		}

		ZUser zUser = users.get(0);
		zUser.setPassword("");
		// 登陆的会话user
		LoginUser loginUser = new LoginUser();
		BeanUtils.copyProperties(zUser, loginUser);
		request.getSession().setAttribute(ZUserConstant.USER_LOGIN_SUCCESS, loginUser);
		return ZManagerResult.success(zUser);
	}

	@SuppressWarnings("unchecked")
	@Transactional
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
		int result = userMapper.insertSelective(user);

		if (result > 0) {
			user.setPassword("");
			return ZManagerResult.success(user);
		}

		return ZManagerResult.fail(ResultCode.FAILURE);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public ZManagerResult<ZUser> updateUser(ZUser user) {
		user.setUpdateTime(CommonUtils.getFormatTime());
		int result = userMapper.updateByPrimaryKeySelective(user);
		if (result > 0) {
			return ZManagerResult.success();
		}

		return ZManagerResult.fail(ResultCode.FAILURE);
	}

	@SuppressWarnings({ "unchecked", "resource" })
	@Override
	public ZManagerResult<List<ZUser>> listUsers(ZUser user) {
		ZUserExample example = new ZUserExample();
		ZUserExample.Criteria cri = example.or();

		if (StringUtils.isNotBlank(user.getAccount())) {
			cri.andAccountLike(user.getAccount());
		}
		if (StringUtils.isNotBlank(user.getName())) {
			cri.andNameLike(user.getName());
		}
		example.setOrderByClause("id");
		List<ZUser> users = userMapper.selectByExample(example);
		Page<ZUser> userPages = (Page<ZUser>) users;
		return ZManagerResult.success(userPages.getResult(), userPages.getPages());
	}

	@Transactional
	@Override
	public ZManagerResult<?> deleteUserByPrimaryKey(Integer id) {
		int result = userMapper.deleteByPrimaryKey(id);
		if (result > 0) {
			return ZManagerResult.success();
		}

		return ZManagerResult.fail(ResultCode.FAILURE);
	}

}
