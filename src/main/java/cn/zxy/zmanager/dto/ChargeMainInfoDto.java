package cn.zxy.zmanager.dto;

import lombok.Data;

@Data
public class ChargeMainInfoDto {
	private Integer contractId;
    private String merchantCode;
    private String company;
    private String coporateBody;
    private String contractCode;
    private Integer totalRentFee;
    private Integer paidRentFee;
    private Integer restRentFee;
    private Integer totalPropertyFee;
    private Integer paidPropertyFee;
    private Integer restPropertyFee;
    private Integer totalWaterFee;
    private Integer paidWaterFee;
    private Integer restWaterFee;
    private Integer paidElectricFee;
    private Integer usedElectricFee;
    private Integer restElectricFee;
}
