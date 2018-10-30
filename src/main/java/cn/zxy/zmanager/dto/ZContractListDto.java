package cn.zxy.zmanager.dto;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZContractHouse;
import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import lombok.Data;

@Data
public class ZContractListDto {
	
	private ZContract contract;
	private List<ZContractHouse> houseList;
	private List<ZWaterMeter> waterMeterList;
	private List<ZElectricMeter> electricMeterList;
	
	public ZContractListDto(ZContract contract, List<ZContractHouse> houseList) {
		this.contract = contract;
		this.houseList = houseList;
	}

	public ZContractListDto(ZContract contract, List<ZContractHouse> contractHouseList,
			List<ZWaterMeter> waterMeterList, List<ZElectricMeter> electricMeterList) {
		this(contract, contractHouseList);
		this.waterMeterList = waterMeterList;
		this.electricMeterList = electricMeterList;
	}

}
