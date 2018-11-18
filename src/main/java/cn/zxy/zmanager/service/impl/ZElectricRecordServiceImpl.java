package cn.zxy.zmanager.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZElectricMeter;
import cn.zxy.zmanager.dao.dataobject.ZElectricRecord;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterRecord;
import cn.zxy.zmanager.dao.mapper.ZContractMapper;
import cn.zxy.zmanager.dao.mapper.ZElectricMeterMapper;
import cn.zxy.zmanager.dao.mapper.ZElectricRecordMapper;
import cn.zxy.zmanager.dto.ElectricRecordExcelRowDto;
import cn.zxy.zmanager.dto.ExcelErrorMessageDto;
import cn.zxy.zmanager.service.ZElectricRecordService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.support.common.utils.CommonUtils;
import cn.zxy.zmanager.support.common.utils.DateUtils;
import cn.zxy.zmanager.support.common.utils.ExcelUploadUtils;

@Service
public class ZElectricRecordServiceImpl implements ZElectricRecordService {
	
	@Autowired
	private ZContractMapper contractMapper;
	
	@Autowired
	private ZElectricMeterMapper electricMeterMapper;
	
	@Autowired
	private ZElectricRecordMapper electricRecordMapper;

	@Transactional
	@Override
	public ZManagerResult<?> addElectricRecord(MultipartFile excel, LoginUser loginUser) throws Exception {
		if (ExcelUploadUtils.isIllegalFileType(excel)) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "非法文件类型，新增失败!");
		}
		File excelFile = ExcelUploadUtils.getExcelFile(excel);
		List<ElectricRecordExcelRowDto> recordExcelRows = getElectircRecordExcelRows(excelFile);
		ZManagerResult<?> checkResult = checkExcelDate(recordExcelRows);
		if (!checkResult.isSuccess()) {
			return checkResult;
		}
		 
		List<ZElectricMeter> electricMeterList = getElectricMeterListFromDB(recordExcelRows);
		List<ZElectricRecord> recordList = getRecordList(recordExcelRows, electricMeterList);
		List<ZElectricMeter> newElectricMeterList = getNewElectricMeterList(electricMeterList, recordList);
		List<ZContract> newContractList = getNewContractList(newElectricMeterList);
		
		electricRecordMapper.insertBatch(recordList, loginUser); 
		electricMeterMapper.updateBatchSelective(newElectricMeterList, loginUser); 
		contractMapper.updateBatchSelective(newContractList, loginUser); 

		return ZManagerResult.success();
	}

	private List<ZContract> getNewContractList(List<ZElectricMeter> newElectricMeterList) {
		List<Integer> contractIdList = newElectricMeterList.stream().map(ZElectricMeter::getContractId)
				.collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
		List<ZContract> contractListFromDB = contractMapper.selectByIdList(contractIdList); 
		List<ZContract> contractListFromWaterMeter = newElectricMeterList.stream()
				.collect(Collectors.groupingBy(ZElectricMeter::getContractId)).values().stream()
				.map(ZElectricRecordServiceImpl::genContractByMeterList).collect(Collectors.toList());

		return Stream.of(contractListFromDB, contractListFromWaterMeter).flatMap(List::stream) 
				.collect(Collectors.toList()).stream().collect(Collectors.groupingBy(ZContract::getId)).values()
				.stream().map(ZElectricRecordServiceImpl::genContractByList).collect(Collectors.toList());
	}
	
	private static ZContract genContractByList(List<ZContract> e) {
		return e.stream().reduce(ZElectricRecordServiceImpl::mergeTwoContract).get();
	}
	
	private static ZContract mergeTwoContract(ZContract e1, ZContract e2) {
		ZContract e = new ZContract();
		e.setId(e1.getId());
		e.setTotalUseElectric(e1.getTotalUseElectric() + e2.getTotalUseElectric());
		int electricPrice = 0;
		if (StringUtils.isBlank(e1.getContractCode())) {
			electricPrice = e2.getElectricFee();
		} else {
			electricPrice = e1.getElectricFee();
		}
		e.setTotalUseElectricFee(e.getTotalUseElectric() * electricPrice);
		e.setModifyTime(DateUtils.getCurrentDate());

		return e;
	}
	
	private static ZContract genContractByMeterList(List<ZElectricMeter> e) {
		return e.stream().map(ZElectricMeter::genContract).collect(Collectors.toList()).stream()
				.reduce(ZElectricRecordServiceImpl::mergeContract).get();
	}
	
	private static ZContract mergeContract(ZContract e1, ZContract e2) {
		ZContract e = new ZContract();
		e.setId(e1.getId());
		if (e2 == null) {
			e.setTotalUseElectric(e1.getTotalUseElectric());;
		} else {
			e.setTotalUseElectric(e1.getTotalUseElectric() + e2.getTotalUseElectric());
		}
		return e;
	}

	private List<ZElectricMeter> getNewElectricMeterList(List<ZElectricMeter> oldElectricMeterList,
			List<ZElectricRecord> recordList) {
		List<ZElectricMeter> electricMeterListByRecordList = recordList.stream().map(ZElectricRecord::genElectricMeter)
				.collect(Collectors.toList());
		return Stream.of(oldElectricMeterList, electricMeterListByRecordList).flatMap(List::stream)
				.collect(Collectors.toList()).stream().collect(Collectors.groupingBy(ZElectricMeter::getId)).values()
				.stream().map(ZElectricRecordServiceImpl::genElectricMeterToUpdate).collect(Collectors.toList());
	}
	
	private static ZElectricMeter genElectricMeterToUpdate(List<ZElectricMeter> e) {
		return  e.stream().reduce(ZElectricRecordServiceImpl::mergeElectricMeterToUpdate).get();
	}
	
	private static ZElectricMeter mergeElectricMeterToUpdate(ZElectricMeter e1, ZElectricMeter e2) {
		ZElectricMeter e = new ZElectricMeter();

		ZElectricMeter meterFromDB = null;
		ZElectricMeter meterFromRecord = null;
		if (StringUtils.isBlank(e1.getElectricMeterCode())) {
			meterFromDB = e2;
			meterFromRecord = e1;
		} else {
			meterFromDB = e1;
			meterFromRecord = e2;
		}

		e.setContractId(meterFromDB.getContractId());
		e.setId(meterFromDB.getId());
		e.setTotalUseElectric(meterFromRecord.getTotalUseElectric() - meterFromDB.getInitMark());
		e.setTotalUseElectricFee(meterFromDB.getElectricFee() * e.getTotalUseElectric());
		e.setModifyTime(DateUtils.getCurrentDate());

		return e;
	}

	private List<ZElectricRecord> getRecordList(List<ElectricRecordExcelRowDto> recordExcelRows,
			List<ZElectricMeter> electricMeterList) {
		List<ZElectricRecord> recordListFromMeterList = electricMeterList.stream().map(ZElectricMeter::genElectricMeterRecord)
				.collect(Collectors.toList());
		List<ZElectricRecord> recordListFromExcelData = recordExcelRows.stream()
				.map(ElectricRecordExcelRowDto::genElectricRecord).collect(Collectors.toList());
		
		return Stream.of(recordListFromExcelData, recordListFromMeterList).flatMap(List::stream)
				.collect(Collectors.toList()).stream().collect(Collectors.groupingBy(ZElectricRecord::getElectricMeterCode))
				.values().stream().map(ZElectricRecordServiceImpl::genOneRecordByRecordList).collect(Collectors.toList());
	}
	
	private static ZElectricRecord genOneRecordByRecordList(List<ZElectricRecord> e) {
		return e.stream().reduce(ZElectricRecordServiceImpl::mergeTwoRecord).get();
	}
	
	private static ZElectricRecord mergeTwoRecord(ZElectricRecord e1, ZElectricRecord e2) {
		ZElectricRecord e = new ZElectricRecord();
		ZElectricRecord temp = null;
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

	private List<ZElectricMeter> getElectricMeterListFromDB(List<ElectricRecordExcelRowDto> recordExcelRows) {
		List<String> excelMeterCodeList = recordExcelRows.stream().map(ElectricRecordExcelRowDto::getMeterCode)
				.collect(Collectors.toList());
		return electricMeterMapper.selectByCodeList(excelMeterCodeList);
	}

	private ZManagerResult<?> checkExcelDate(List<ElectricRecordExcelRowDto> recordExcelRows) {
		if (CommonUtils.isListEmpty(recordExcelRows)) {
			return ZManagerResult.fail(ResultCode.FAILURE.getCode(), "excel 为空，导入失败");
		}
		List<ExcelErrorMessageDto> errorMessageList = getExcelErrorMessages(recordExcelRows);
		if (errorMessageList.size() > 0) {
			return ZManagerResult.fail(errorMessageList, ResultCode.EXCEL_DATA_ERROR.getCode(), "excel 数据有问题，导入失败");
		}

		return ZManagerResult.success();
	}

	private List<ExcelErrorMessageDto> getExcelErrorMessages(List<ElectricRecordExcelRowDto> recordExcelRows) {
		List<ExcelErrorMessageDto> blankMessages = recordExcelRows.stream()
				.filter(ZElectricRecordServiceImpl::isContainBlankDate).map(ElectricRecordExcelRowDto::genBlankMessage)
				.collect(Collectors.toList());
		
		List<ExcelErrorMessageDto> formatMessages = recordExcelRows.stream()
				.filter(ZElectricRecordServiceImpl::isContainIllegalFormat)
				.map(ElectricRecordExcelRowDto::genFormatErrorMessage).collect(Collectors.toList());
		
		List<ExcelErrorMessageDto> repeatCodeMessages = recordExcelRows.stream()
				.collect(Collectors.groupingBy(ElectricRecordExcelRowDto::getMeterCode)).entrySet().stream()
				.filter(e -> e.getValue().size() > 1).map(e -> e.getValue()).flatMap(List::stream)
				.collect(Collectors.toList()).stream().map(ElectricRecordExcelRowDto::genRepeatCodeMessage)
				.collect(Collectors.toList());
		
		List<ExcelErrorMessageDto> notExistMeterCodeMessages = getNotExistMeterCodeMessages(recordExcelRows);

		return Stream.of(blankMessages, formatMessages, repeatCodeMessages, notExistMeterCodeMessages)
				.flatMap(List::stream).collect(Collectors.toList());
	}
	
	private List<ExcelErrorMessageDto> getNotExistMeterCodeMessages(List<ElectricRecordExcelRowDto> recordExcelRows) {
		List<String> excelMeterCodeList = recordExcelRows.stream().map(ElectricRecordExcelRowDto::getMeterCode)
				.collect(Collectors.toList());
		List<ZElectricMeter> electricMeterList = electricMeterMapper.selectByCodeList(excelMeterCodeList);
		List<String> dbMeterCodeList = electricMeterList.stream().map(ZElectricMeter::getElectricMeterCode)
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
	
	private static boolean isContainIllegalFormat(ElectricRecordExcelRowDto e) {
		return !(e.getMeterMark().matches(ExcelErrorMessageDto.POSITIVE_INTEGER_REGEX)
				&& e.getMarkDate().matches(ExcelErrorMessageDto.DATE_REGEX));
	}
	
	private static boolean isContainBlankDate(ElectricRecordExcelRowDto e) {
		return StringUtils.isBlank(e.getMeterCode()) || StringUtils.isBlank(e.getMeterMark())
				|| StringUtils.isBlank(e.getMarkDate());
	}

	private List<ElectricRecordExcelRowDto> getElectircRecordExcelRows(File excelFile) throws Exception {
		Iterator<Row> rowIt = ExcelUploadUtils.getRowIterator(excelFile);
		List<ElectricRecordExcelRowDto> recordRowList = new ArrayList<>();
		int lineNum = 0;
		while (rowIt.hasNext()) {
			Row row = rowIt.next();
			lineNum++;
			if (row.getRowNum() < 1 || ExcelUploadUtils.isBlankRow(row)) {
				continue;
			}

			ElectricRecordExcelRowDto recordRow = getRecordExcelRow(row, lineNum);
			recordRowList.add(recordRow);
		}

		return recordRowList;
	}

	private ElectricRecordExcelRowDto getRecordExcelRow(Row row, int lineNum) {
		ElectricRecordExcelRowDto recordRow = new ElectricRecordExcelRowDto();
		recordRow.setLineNum(lineNum);
		recordRow.setMeterCode(row.getCell(0).getStringCellValue());
		recordRow.setMeterMark(row.getCell(1).getNumericCellValue() + "");
		recordRow.setMarkDate(row.getCell(2).getStringCellValue());

		return recordRow;
	}

}
