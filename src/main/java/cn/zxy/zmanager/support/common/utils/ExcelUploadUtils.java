package cn.zxy.zmanager.support.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelUploadUtils {
	
	public static boolean isIllegalFileType(MultipartFile excel) {
		return !(excel.getOriginalFilename().endsWith(".xls") || excel.getOriginalFilename().endsWith(".xlsx")); 
	}
	
	public static File getExcelFile(MultipartFile excel) throws IOException {
		File excelFile = new File(excel.getOriginalFilename());
		excelFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(excelFile);
		fos.write(excel.getBytes());
		fos.close();
		return excelFile;
	}
	
	public static boolean isBlankRow(Row row) {
		for (int i = 0; i <= 2; i++) {
			Cell cell = row.getCell(i);
			if (cell.getCellType() != CellType.BLANK && cell != null) {
				return false;
			}
		}
		return true;
	}
	
	@SuppressWarnings("resource")
	public static Iterator<Row> getRowIterator(File excelFile) throws Exception {
		Workbook wb = null;
		Sheet sheet = null;
		if (excelFile.getName().endsWith(".xls")) {
			wb = new HSSFWorkbook(new FileInputStream(excelFile));
		} else {
			wb = new XSSFWorkbook(new FileInputStream(excelFile));
		}
		sheet = wb.getSheetAt(0);

		return sheet.rowIterator();
	}

}
