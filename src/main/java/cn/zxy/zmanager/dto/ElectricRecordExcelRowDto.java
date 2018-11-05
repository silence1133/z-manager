package cn.zxy.zmanager.dto;

import java.util.Calendar;
import java.util.Date;

import cn.zxy.zmanager.dao.dataobject.ZElectricRecord;
import cn.zxy.zmanager.support.common.utils.DateUtils;
import lombok.Data;

@Data
public class ElectricRecordExcelRowDto {

	private int lineNum;
	private String meterCode;
	private String meterMark;
	private String markDate;
	
	public static ExcelErrorMessageDto genBlankMessage(ElectricRecordExcelRowDto e) {
		return new ExcelErrorMessageDto(e.getLineNum(), ExcelErrorMessageDto.BLANK_MESSAGE);
	}
	
	public static ExcelErrorMessageDto genFormatErrorMessage(ElectricRecordExcelRowDto e) {
		return new ExcelErrorMessageDto(e.getLineNum(), ExcelErrorMessageDto.FORMAT_MESSAGE);
	}
	
	public static ExcelErrorMessageDto genRepeatCodeMessage(ElectricRecordExcelRowDto e) {
		return new ExcelErrorMessageDto(e.getLineNum(), ExcelErrorMessageDto.REPEAT_CODE_MESSAGE + e.getMeterCode());
	}
	
	public static ZElectricRecord genElectricRecord(ElectricRecordExcelRowDto e) {
		ZElectricRecord record = new ZElectricRecord();
		
		Date markDate = DateUtils.parseStrToDate(e.getMarkDate(), "yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(markDate);
		record.setMarkDate(markDate);
		record.setYear(c.get(Calendar.YEAR));
		record.setMonth(c.get(Calendar.MONTH) + 1);
		record.setEndMark((int)(Math.floor(Double.valueOf(e.getMeterMark()))));
		record.setElectricMeterCode(e.getMeterCode());
		
		return record;
	}
	
	public static void main(String[] args) {
		String date = "2018-11-04";
		Date markDate = DateUtils.parseStrToDate(date, "yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(markDate);
		System.out.println(c.get(Calendar.MONTH) + 1);
	}
	
	
}
