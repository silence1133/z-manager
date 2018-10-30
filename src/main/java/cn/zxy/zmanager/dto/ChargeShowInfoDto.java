package cn.zxy.zmanager.dto;

import java.util.List;

import lombok.Data;

@Data
public class ChargeShowInfoDto {
	
	private ChargeMainInfoDto chargeMainInfo;
	private List<HouseFeeDetailDto> houseFeeList;
	
	public ChargeShowInfoDto(ChargeMainInfoDto chargeMainInfoDto, List<HouseFeeDetailDto> feeDetailDtoList) {
		this.chargeMainInfo = chargeMainInfoDto;
		this.houseFeeList = feeDetailDtoList;
	}
}
