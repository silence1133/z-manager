package cn.zxy.zmanager.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ElectricRecordDTO {

	private Integer electricMeterId;
	
	private Integer currentMark;
	
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date markDate;
	
}
