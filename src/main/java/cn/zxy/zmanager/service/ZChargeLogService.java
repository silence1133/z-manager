package cn.zxy.zmanager.service;

import java.util.List;

import cn.zxy.zmanager.dao.dataobject.ZPaidFeeDetail;
import cn.zxy.zmanager.dto.PaidFeeDetailSearchDTO;
import cn.zxy.zmanager.support.common.ZManagerResult;

public interface ZChargeLogService {

	ZManagerResult<List<ZPaidFeeDetail>> listChargeLog(int contractId, int feeType);

	ZManagerResult<?> listChargeLog(int pageNum, int pageSize, PaidFeeDetailSearchDTO searchDTO);

	ZManagerResult<List<ZPaidFeeDetail>> listChargeLog(PaidFeeDetailSearchDTO searchDTO);

}
