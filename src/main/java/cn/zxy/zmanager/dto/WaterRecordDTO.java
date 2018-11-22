package cn.zxy.zmanager.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class WaterRecordDTO {

	private Integer waterMeterId;
	
	private Integer currentMark;
	
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date markDate;
	
}
