package cn.zxy.zmanager.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterRecord;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.dao.mapper.ZWaterMeterMapper;
import cn.zxy.zmanager.dao.mapper.ZWaterRecordMapper;
import cn.zxy.zmanager.dto.ExcelErrorMessageDto;
import cn.zxy.zmanager.dto.WaterRecordExcelRowDto;
import cn.zxy.zmanager.service.ZWaterRecordService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.CommonUtils;
import cn.zxy.zmanager.support.common.utils.DateUtils;
import cn.zxy.zmanager.support.common.utils.ExcelUploadUtils;

@Service
public class ZWaterRecordServiceImpl implements ZWaterRecordService {

	@Autowired
	private ZWaterRecordMapper waterRecordMapper;

	@Autowired
	private ZWaterMeterMapper waterMeterMapper;

	@Autowired
	private ZContractMapper contractMapper;

	@Transactional
	@Override
	public ZManagerResult<?> addWaterRecord(MultipartFile excel, LoginUser loginUser) throws Exception {
		if (ExcelUploadUtils.isIllegalFileType(excel)) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "非法文件类型，新增失败！");
		}
		File excelFile = ExcelUploadUtils.getExcelFile(excel);
		List<WaterRecordExcelRowDto> recordExcelRows = getWaterRecordExcelRows(excelFile);

		ZManagerResult<?> checkResult = checkExcelDate(recordExcelRows);
		if (!checkResult.isSuccess()) {
			return checkResult;
		}

		List<ZWaterMeter> waterMeterList = getWaterMeterListFromDB(recordExcelRows);
		List<ZWaterRecord> recordList = getRecordList(recordExcelRows, waterMeterList);
		List<ZWaterMeter> newWaterMeterList = getNewWaterMeterList(waterMeterList, recordList);
		List<ZContract> newContractList = getNewContractList(newWaterMeterList);

		waterRecordMapper.insertBatch(recordList, loginUser); 
		waterMeterMapper.updateBatchSelective(newWaterMeterList, loginUser); 
		contractMapper.updateBatchSelective(newContractList, loginUser); 

		return ZManagerResult.success();
	}

	private List<ZContract> getNewContractList(List<ZWaterMeter> newWaterMeterList) {
		List<Integer> contractIdList = newWaterMeterList.stream().map(ZWaterMeter::getContractId)
				.collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
		List<ZContract> contractListFromDB = contractMapper.selectByIdList(contractIdList); 
		List<ZContract> contractListFromWaterMeter = newWaterMeterList.stream()
				.collect(Collectors.groupingBy(ZWaterMeter::getContractId)).values().stream()
				.map(ZWaterRecordServiceImpl::genContractByMeterList).collect(Collectors.toList());

		return Stream.of(contractListFromDB, contractListFromWaterMeter).flatMap(List::stream) 
				.collect(Collectors.toList()).stream().collect(Collectors.groupingBy(ZContract::getId)).values()
				.stream().map(ZWaterRecordServiceImpl::genContractByList).collect(Collectors.toList());
	}

	private static ZContract genContractByList(List<ZContract> e) {
		return e.stream().reduce(ZWaterRecordServiceImpl::mergeTwoContract).get();
	}

	private static ZContract mergeTwoContract(ZContract e1, ZContract e2) {
		ZContract e = new ZContract();
		e.setId(e1.getId());
		e.setTotalUseWater(e1.getTotalUseWater() + e2.getTotalUseWater());
		int waterPrice = 0;
		if (StringUtils.isBlank(e1.getContractCode())) {
			waterPrice = e2.getWaterFee();
		} else {
			waterPrice = e1.getWaterFee();
		}
		e.setTotalUseWaterFee(e.getTotalUseWater() * waterPrice);
		e.setModifyTime(DateUtils.getCurrentDate());
		return e;
	}

	private static ZContract genContractByMeterList(List<ZWaterMeter> e) {
		return e.stream().map(ZWaterMeter::genContract).collect(Collectors.toList()).stream()
				.reduce(ZWaterRecordServiceImpl::mergeContract).get();
	}

	private static ZContract mergeContract(ZContract e1, ZContract e2) {
		ZContract e = new ZContract();
		e.setId(e1.getId());
		if (e2 == null) {
			e.setTotalUseWater(e1.getTotalUseWater());
		} else {
			e.setTotalUseWater(e1.getTotalUseWater() + e2.getTotalUseWater());
		}
		return e;
	}

	private List<ZWaterMeter> getNewWaterMeterList(List<ZWaterMeter> oldWaterMeterList, List<ZWaterRecord> recordList) {
		List<ZWaterMeter> waterMeterListByRecordList = recordList.stream().map(ZWaterRecord::genWaterMeter)
				.collect(Collectors.toList());
		return Stream.of(oldWaterMeterList, waterMeterListByRecordList).flatMap(List::stream)
				.collect(Collectors.toList()).stream().collect(Collectors.groupingBy(ZWaterMeter::getId)).values()
				.stream().map(ZWaterRecordServiceImpl::genWaterMeterToUpdate).collect(Collectors.toList());
	}

	private static ZWaterMeter genWaterMeterToUpdate(List<ZWaterMeter> e) {
		return e.stream().reduce(ZWaterRecordServiceImpl::mergeWaterMeterToUpdate).get();
	}

	private static ZWaterMeter mergeWaterMeterToUpdate(ZWaterMeter e1, ZWaterMeter e2) {
		ZWaterMeter e = new ZWaterMeter();

		ZWaterMeter meterFromDB = null;
		ZWaterMeter meterFromRecord = null;
		if (StringUtils.isBlank(e1.getWaterMeterCode())) {
			meterFromDB = e2;
			meterFromRecord = e1;
		} else {
			meterFromDB = e1;
			meterFromRecord = e2;
		}

		e.setContractId(meterFromDB.getContractId());
		e.setId(meterFromDB.getId());
		e.setTotalWater(meterFromRecord.getTotalWater() - meterFromDB.getInitMark());
		e.setTotalWaterFee(meterFromDB.getWaterFee() * e.getTotalWater());
		e.setModifyTime(DateUtils.getCurrentDate());

		return e;
	}

	private List<ZWaterMeter> getWaterMeterListFromDB(List<WaterRecordExcelRowDto> recordExcelRows) {
		List<String> excelMeterCodeList = recordExcelRows.stream().map(WaterRecordExcelRowDto::getMeterCode)
				.collect(Collectors.toList());
		return waterMeterMapper.selectByCodeList(excelMeterCodeList);
	}

	private List<ZWaterRecord> getRecordList(List<WaterRecordExcelRowDto> recordExcelRows,
			List<ZWaterMeter> waterMeterList) {
		List<ZWaterRecord> recordListFromMeterList = waterMeterList.stream().map(ZWaterMeter::genWaterMeterRecord)
				.collect(Collectors.toList());
		List<ZWaterRecord> recordListFromExcelData = recordExcelRows.stream()
				.map(WaterRecordExcelRowDto::genWaterRecord).collect(Collectors.toList());
		
		return Stream.of(recordListFromExcelData, recordListFromMeterList).flatMap(List::stream)
				.collect(Collectors.toList()).stream().collect(Collectors.groupingBy(ZWaterRecord::getWaterMeterCode))
				.values().stream().map(ZWaterRecordServiceImpl::genOneRecordByRecordList).collect(Collectors.toList());
	}

	private static ZWaterRecord genOneRecordByRecordList(List<ZWaterRecord> e) {
		return e.stream().reduce(ZWaterRecordServiceImpl::mergeTwoRecord).get();
	}

	private static ZWaterRecord mergeTwoRecord(ZWaterRecord e1, ZWaterRecord e2) {
		ZWaterRecord e = new ZWaterRecord();
		ZWaterRecord temp = null;
		if (StringUtils.isNotBlank(e1.getContractCode())) {
			BeanUtils.copyProperties(e1, e);
			temp = e2;
		} else {
			BeanUtils.copyProperties(e2, e);
			temp = e1;
		}
		e.setEndMark(temp.getEndMark());
		e.setMarkDate(temp.getMarkDate());
		e.setYear(temp.getYear());
		e.setMonth(temp.getMonth());
		e.setCreateTime(DateUtils.getCurrentDate());

		return e;
	}

	private ZManagerResult<?> checkExcelDate(List<WaterRecordExcelRowDto> recordExcelRows) {
		if (CommonUtils.isListEmpty(recordExcelRows)) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "excel 为空，导入失败");
		}
		List<ExcelErrorMessageDto> errorMessageList = getExcelErrorMessages(recordExcelRows);
		if (errorMessageList.size() > 0) {
			return ZManagerResult.fail(errorMessageList, ResultCode.EXCEL_DATA_ERROR.getCode(), "excel 数据有问题，导入失败");
		}

		return ZManagerResult.success();
	}

	private List<ExcelErrorMessageDto> getExcelErrorMessages(List<WaterRecordExcelRowDto> recordExcelRows) {
		List<ExcelErrorMessageDto> blankMessages = recordExcelRows.stream()
				.filter(ZWaterRecordServiceImpl::isContainBlankDate).map(WaterRecordExcelRowDto::genBlankMessage)
				.collect(Collectors.toList());

		List<ExcelErrorMessageDto> formatMessages = recordExcelRows.stream()
				.filter(ZWaterRecordServiceImpl::isContainIllegalFormat)
				.map(WaterRecordExcelRowDto::genFormatErrorMessage).collect(Collectors.toList());

		List<ExcelErrorMessageDto> repeatCodeMessages = recordExcelRows.stream()
				.collect(Collectors.groupingBy(WaterRecordExcelRowDto::getMeterCode)).entrySet().stream()
				.filter(e -> e.getValue().size() > 1).map(e -> e.getValue()).flatMap(List::stream)
				.collect(Collectors.toList()).stream().map(WaterRecordExcelRowDto::genRepeatCodeMessage)
				.collect(Collectors.toList());

		List<ExcelErrorMessageDto> notExistMeterCodeMessages = getNotExistMeterCodeMessages(recordExcelRows);

		return Stream.of(blankMessages, formatMessages, repeatCodeMessages, notExistMeterCodeMessages)
				.flatMap(List::stream).collect(Collectors.toList());
	}

	private List<ExcelErrorMessageDto> getNotExistMeterCodeMessages(List<WaterRecordExcelRowDto> recordExcelRows) {
		List<String> excelMeterCodeList = recordExcelRows.stream().map(WaterRecordExcelRowDto::getMeterCode)
				.collect(Collectors.toList());
		List<ZWaterMeter> waterMeterList = waterMeterMapper.selectByCodeList(excelMeterCodeList);
		List<String> dbMeterCodeList = waterMeterList.stream().map(ZWaterMeter::getWaterMeterCode)
				.collect(Collectors.toList());
		excelMeterCodeList.removeAll(dbMeterCodeList);
		List<ExcelErrorMessageDto> notExistMeterCodeMessages = new ArrayList<>();
		if (excelMeterCodeList.size() > 0) {
			ExcelErrorMessageDto msg = new ExcelErrorMessageDto(1,
					ExcelErrorMessageDto.NOT_EXIST_MESSAGE + String.join(",", excelMeterCodeList));
			notExistMeterCodeMessages.add(msg);
		}

		return notExistMeterCodeMessages;
	}

	private static boolean isContainIllegalFormat(WaterRecordExcelRowDto e) {
		return !(e.getMeterMark().matches(ExcelErrorMessageDto.POSITIVE_INTEGER_REGEX)
				&& e.getMarkDate().matches(ExcelErrorMessageDto.DATE_REGEX));
	}

	private static boolean isContainBlankDate(WaterRecordExcelRowDto e) {
		return StringUtils.isBlank(e.getMeterCode()) || StringUtils.isBlank(e.getMeterMark())
				|| StringUtils.isBlank(e.getMarkDate());
	}

	private List<WaterRecordExcelRowDto> getWaterRecordExcelRows(File excelFile) throws Exception {
		Iterator<Row> rowIt = ExcelUploadUtils.getRowIterator(excelFile);
		List<WaterRecordExcelRowDto> recordRowList = new ArrayList<>();
		int lineNum = 0;
		while (rowIt.hasNext()) {
			Row row = rowIt.next();
			lineNum++;
			if (row.getRowNum() < 1 || ExcelUploadUtils.isBlankRow(row)) {
				continue;
			}

			WaterRecordExcelRowDto recordRow = getRecordExcelRow(row, lineNum);
			recordRowList.add(recordRow);
		}

		return recordRowList;
	}

	private WaterRecordExcelRowDto getRecordExcelRow(Row row, int lineNum) {
		WaterRecordExcelRowDto recordRow = new WaterRecordExcelRowDto();
		recordRow.setLineNum(lineNum);
		recordRow.setMeterCode(row.getCell(0).getStringCellValue());
		recordRow.setMeterMark(row.getCell(1).getNumericCellValue() + "");
		recordRow.setMarkDate(row.getCell(2).getStringCellValue());

		return recordRow;
	}

}
