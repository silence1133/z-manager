package cn.zxy.zmanager.service;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZContractService {

	ZManagerResult<List<ZContract>> listContract(int pageNum, int pageSize, String keyWord);

}
