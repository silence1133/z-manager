package cn.zxy.zmanager.service;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZMaterial;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZMaterialService {

	ZManagerResult<ZMaterial> addMaterial(ZMaterial material, LoginUser loginUser);

	ZManagerResult<?> updMaterial(ZMaterial material, LoginUser loginUser);

	ZManagerResult<List<ZMaterial>> listMaterial(int pageNum, int pageSize, String keyWord);

}
