package cn.zxy.zmanager.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeterExample;
import cn.zxy.zmanager.dao.dataobject.ZWaterRecord;
import cn.zxy.zmanager.dao.dataobject.ZWaterRecordExample;
import cn.zxy.zmanager.dao.mapper.ZWaterMeterMapper;
import cn.zxy.zmanager.dao.mapper.ZWaterRecordMapper;
import cn.zxy.zmanager.service.ZWaterMeterManageService;
import cn.zxy.zmanager.support.common.ZManagerResult;

@Service
public class ZWaterMeterManageServiceImpl implements ZWaterMeterManageService {
	
	@Autowired
	private ZWaterMeterMapper waterMeterMapper;
	
	@Autowired
	private ZWaterRecordMapper waterRecordMapper;

	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ZWaterMeter>> listWaterMeter(int pageNum, int pageSize, String keyWord) {
		ZWaterMeterExample example = new ZWaterMeterExample();
		if (StringUtils.isNotBlank(keyWord)) {
			keyWord = "%" + keyWord + "%";
			example.or().andContractCodeLike(keyWord);
			example.or().andWaterMeterCodeLike(keyWord);
		}
		
		PageHelper.startPage(pageNum, pageSize);
		Page<ZWaterMeter> waterMeterPage = (Page<ZWaterMeter>) waterMeterMapper.selectByExample(example);
		return ZManagerResult.success(waterMeterPage.getResult(), waterMeterPage.getPages());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ZWaterRecord>> listWaterReocrdByMeterId(Integer waterMeterId) {
		ZWaterRecordExample example = new ZWaterRecordExample();
		example.createCriteria().andWaterMeterIdEqualTo(waterMeterId);
		List<ZWaterRecord> result = waterRecordMapper.selectByExample(example);
		
		return ZManagerResult.success(result);
	}

}
