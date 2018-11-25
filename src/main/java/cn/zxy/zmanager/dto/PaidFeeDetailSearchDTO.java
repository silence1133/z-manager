package cn.zxy.zmanager.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PaidFeeDetailSearchDTO {
	
	private String keyWord;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startPayTime;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endPayTime;
    
    private Integer feeType;
    
    private Integer payType;
    
}
