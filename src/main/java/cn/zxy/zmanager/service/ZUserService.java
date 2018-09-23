package cn.zxy.zmanager.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.zxy.zmanager.common.ZManagerResult;
import cn.zxy.zmanager.dao.dataobject.ZUser;

public interface ZUserService {

	ZManagerResult login(ZUser user, HttpServletRequest request);

	ZManagerResult<ZUser> addUser(ZUser user);

	ZManagerResult<ZUser> updateUser(ZUser user);

	ZManagerResult<List<ZUser>> listUsers(ZUser user);

	ZManagerResult deleteUserByPrimaryKey(Integer id);

}
