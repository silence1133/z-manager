package cn.zxy.zmanager.service;

import java.util.List;

import cn.zxy.zmanager.dto.ChargeShowInfoDto;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZChargeShowService {

	ZManagerResult<List<ChargeShowInfoDto>> listChargeShowInfo(int pageNum, int pageSize, String keyWord);

}
