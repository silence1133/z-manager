package cn.zxy.zmanager.dto;

import lombok.Data;

@Data
public class ExcelErrorMessageDto {
	
	public static final String BLANK_MESSAGE = "存在空数据";
	
	public static final String FORMAT_MESSAGE = "日期不是 2018-10-31 这种格式 或者刻度值不为正整数";
	
	public static final String REPEAT_CODE_MESSAGE = "在 excel 中存在多个此编号:";
	
	public static final String NOT_EXIST_MESSAGE = "这些列出来的表编号在系统中不存在：";
	
	public static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*(.0){0,1}";
	
	public static final String DATE_REGEX = "^\\d{4}-\\d{1,2}-\\d{1,2}";

	private int lineNum;
	private String message;
	
	public ExcelErrorMessageDto(int lineNum, String message) {
		super();
		this.lineNum = lineNum;
		this.message = message;
	}
	
}
