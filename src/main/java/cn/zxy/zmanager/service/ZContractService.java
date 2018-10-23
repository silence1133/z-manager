package cn.zxy.zmanager.service;

import java.util.List;

import cn.zxy.zmanager.dto.ZContractListDto;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZContractService {

	ZManagerResult<List<ZContractListDto>> listContract(int pageNum, int pageSize, String keyWord);

}
