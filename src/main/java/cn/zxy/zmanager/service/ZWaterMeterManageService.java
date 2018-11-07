package cn.zxy.zmanager.service;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterRecord;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZWaterMeterManageService {

	ZManagerResult<List<ZWaterMeter>> listWaterMeter(int pageNum, int pageSize, String keyWord);

	ZManagerResult<List<ZWaterRecord>> listWaterReocrdByMeterId(Integer waterMeterId);

}
