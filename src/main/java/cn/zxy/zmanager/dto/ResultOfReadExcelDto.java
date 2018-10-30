package cn.zxy.zmanager.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResultOfReadExcelDto<T> {

	private List<T> successDataList;
	private Integer successDataCount;
	private Integer failDataCount;
	private List<FailDataDto> failDataList;
	
}
