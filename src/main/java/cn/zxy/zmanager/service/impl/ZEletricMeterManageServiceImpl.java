package cn.zxy.zmanager.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZElectricMeterExample;
import cn.zxy.zmanager.dao.dataobject.ZElectricRecord;
import cn.zxy.zmanager.dao.dataobject.ZElectricRecordExample;
import cn.zxy.zmanager.dao.mapper.ZElectricMeterMapper;
import cn.zxy.zmanager.dao.mapper.ZElectricRecordMapper;
import cn.zxy.zmanager.service.ZEletricMeterManageService;
import cn.zxy.zmanager.support.common.ZManagerResult;

@Service
public class ZEletricMeterManageServiceImpl implements ZEletricMeterManageService {

	@Autowired
	private ZElectricMeterMapper electricMeterMapper;
	
	@Autowired
	private ZElectricRecordMapper electricRecordMapper;
	
	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ZElectricMeter>> listElectricMeter(int pageNum, int pageSize, String keyWord) {
		ZElectricMeterExample example = new ZElectricMeterExample();
		if (StringUtils.isNotBlank(keyWord)) {
			keyWord = "%" + keyWord + "%";
			example.or().andContractCodeLike(keyWord);
			example.or().andElectricMeterCodeLike(keyWord);
		}
		
		PageHelper.startPage(pageNum, pageSize);
		Page<ZElectricMeter> waterMeterPage = (Page<ZElectricMeter>) electricMeterMapper.selectByExample(example);
		return ZManagerResult.success(waterMeterPage.getResult(), waterMeterPage.getPages());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ZManagerResult<List<ZElectricRecord>> listElectricReocrdByMeterId(Integer electricMeterId) {
		ZElectricRecordExample example = new ZElectricRecordExample();
		example.createCriteria().andElectricMeterIdEqualTo(electricMeterId);
		List<ZElectricRecord> result = electricRecordMapper.selectByExample(example);
		
		return ZManagerResult.success(result);
	}

}
