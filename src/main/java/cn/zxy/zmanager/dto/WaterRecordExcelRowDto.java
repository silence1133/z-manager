package cn.zxy.zmanager.dto;

import java.util.Calendar;
import java.util.Date;

import cn.zxy.zmanager.dao.dataobject.ZWaterRecord;
import cn.zxy.zmanager.support.common.utils.DateUtils;
import lombok.Data;

@Data
public class WaterRecordExcelRowDto {

	private int lineNum;
	private String meterCode;
	private String meterMark;
	private String markDate;
	
	public static ExcelErrorMessageDto genBlankMessage(WaterRecordExcelRowDto e) {
		return new ExcelErrorMessageDto(e.getLineNum(), ExcelErrorMessageDto.BLANK_MESSAGE);
	}
	
	public static ExcelErrorMessageDto genFormatErrorMessage(WaterRecordExcelRowDto e) {
		return new ExcelErrorMessageDto(e.getLineNum(), ExcelErrorMessageDto.FORMAT_MESSAGE);
	}
	
	public static ExcelErrorMessageDto genRepeatCodeMessage(WaterRecordExcelRowDto e) {
		return new ExcelErrorMessageDto(e.getLineNum(), ExcelErrorMessageDto.REPEAT_CODE_MESSAGE + e.getMeterCode());
	}
	
	public static ZWaterRecord genWaterRecord(WaterRecordExcelRowDto e) {
		ZWaterRecord record = new ZWaterRecord();
		record.setEndMark((int)(Math.floor(Double.valueOf(e.getMeterMark()))));
		Date markDate = DateUtils.parseStrToDate(e.getMarkDate(), "yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(markDate);
		record.setMarkDate(markDate);
		record.setYear(c.get(Calendar.YEAR));
		record.setMonth(c.get(Calendar.MONTH) + 1);
		record.setWaterMeterCode(e.getMeterCode());
		
		return record;
	}
	
	
}
