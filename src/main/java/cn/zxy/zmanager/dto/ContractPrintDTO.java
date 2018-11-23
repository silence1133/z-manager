package cn.zxy.zmanager.dto;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZContractHouse;
import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import lombok.Data;

@Data
public class ContractPrintDTO {

	private ZContract contract;
	private List<ZContractHouse> houseList;
	private List<ZWaterMeter> waterMeterList;
	private List<ZElectricMeter> electricMeterList;
	private List<HouseFeeDetailDto> houseFeeList;
	private ChargeMainInfoDto chargeMainInfo;
	
	public ContractPrintDTO() {}
	
	public ContractPrintDTO(ZContract contract, 
			List<ZContractHouse> houseList, 
			List<ZWaterMeter> waterMeterList, 
			List<ZElectricMeter> electricMeterList,
			List<HouseFeeDetailDto> houseFeeList,
			ChargeMainInfoDto chargeMainInfo) {
		this.contract = contract;
		this.houseList = houseList;
		this.waterMeterList = waterMeterList;
		this.electricMeterList = electricMeterList;
		this.houseFeeList = houseFeeList;
		this.chargeMainInfo = chargeMainInfo;
	}
	
	
}
