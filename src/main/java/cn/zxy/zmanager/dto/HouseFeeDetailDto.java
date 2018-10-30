package cn.zxy.zmanager.dto;

import java.util.Date;

import lombok.Data;

@Data
public class HouseFeeDetailDto {
	
	private Integer contractId;
	private Date payDeadline;
	private Integer sortYear;
	private Integer totalRentFee;
	private Integer totalPropertyFee;
	private Integer paidRentFee;
	private Integer paidPropertyFee;
	private Integer restRentFee;
	private Integer restPropertyFee;

}
