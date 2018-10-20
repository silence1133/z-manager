package cn.zxy.zmanager.dto;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZHouse;
import lombok.Data;

@Data
public class ZContractAddDto {
	
	private ZContract contract;
	private List<ZHouse> houseList;
	private List<Integer> rentMonthList;
	private List<Integer> propertyMonthList;

}
