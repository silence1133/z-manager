package cn.zxy.zmanager.service;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZElectricRecord;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZEletricMeterManageService {

	ZManagerResult<List<ZElectricMeter>> listElectricMeter(int pageNum, int pageSize, String keyWord);

	ZManagerResult<List<ZElectricRecord>> listElectricReocrdByMeterId(Integer electricMeterId);

}
