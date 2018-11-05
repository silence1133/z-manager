package cn.zxy.zmanager.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class HouseFeeDetailDto {
	
	// 合同 ID
	private Integer contractId;
	// 应缴截止日期
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date payDeadline;
	// 第几年
	private Integer sortYear;
	// 第 N 年的总租金
	private Integer totalRentFee;
	// 第 N 年的总物业费
	private Integer totalPropertyFee;
	// 第 N 年已缴租金
	private Integer paidRentFee;
	// 第 N 年已缴物业费
	private Integer paidPropertyFee;
	// 第 N 年剩余应缴租金
	private Integer restRentFee;
	// 第 N 年剩余应缴物业费
	private Integer restPropertyFee;

}
