package cn.zxy.zmanager.dto;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZContractHouse;
import lombok.Data;

@Data
public class ZContractListDto {
	
	private ZContract contract;
	private List<ZContractHouse> houseList;
	
	public ZContractListDto(ZContract contract, List<ZContractHouse> houseList) {
		this.contract = contract;
		this.houseList = houseList;
	}

}
