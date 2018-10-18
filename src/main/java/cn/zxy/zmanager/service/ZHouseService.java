package cn.zxy.zmanager.service;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZHouse;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZHouseService {

	ZManagerResult<ZHouse> addHouse(ZHouse house, LoginUser loginUser);

	ZManagerResult<List<ZHouse>> listHouse(int pageNum, int pageSize, String keyWord);

	ZManagerResult<List<ZHouse>> listAvailableHouse();

}
