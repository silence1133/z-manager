package cn.zxy.zmanager.service;

import cn.zxy.zmanager.dto.ContractPrintDTO;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZContractPrintService {

	ZManagerResult<ContractPrintDTO> printContract(Integer contractId);

}
