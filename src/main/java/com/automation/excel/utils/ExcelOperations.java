package com.automation.excel.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automation.constants.GlobalConstants;

public class ExcelOperations {

	private static Workbook book;
	private static Sheet sheet;
	private static File file;

	private static int totalRows;

	private static void checkExcelType(String fileName) {
		if (fileName == null || fileName.length() <= 0) {
			try {
				throw new FileNotFoundException("File not found");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			file = new File(fileName.toLowerCase());
			FileInputStream input = null;
			try {
				input = new FileInputStream(file);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			if (file.exists() && fileName.contains(".xlxs")) {
				try {
					book = new XSSFWorkbook(input);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (file.exists() && fileName.contains(".xls")) {
				try {
					book = new HSSFWorkbook(input);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("unused")
	public static void readCellValue(String fileName, String sheetName, String rowName) {
		checkExcelType(fileName);
		if ((sheetName.length() <= 0 || sheetName == null) && (rowName.length() <= 0 || rowName == null)) {
			try {
				throw new Exception("Please provide the valid sheet name and row name");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			sheet = book.getSheet(sheetName);
			totalRows = sheet.getLastRowNum() - sheet.getFirstRowNum();
			for (int i = 0; i <= totalRows; i++) {
				System.out.println(sheet.getRow(i).getCell(0).getRichStringCellValue());
				break;
			}
		}
	}

	public static String readExcelLocators(String fileName, String sheetName, String LocatorName) {
		String locatorType = null;
		String locatorValue = null;
		checkExcelType(GlobalConstants.WebConstants.excelLocators + fileName);

		if ((sheetName.length() <= 0 || sheetName == null) && (LocatorName.length() <= 0 || LocatorName == null)) {
			try {
				throw new Exception("Please provide the valid sheet name and locator name");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			sheet = book.getSheet(sheetName);
			totalRows = sheet.getLastRowNum() - sheet.getFirstRowNum();
			for (int i = 0; i <= totalRows; i++) {
				if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(LocatorName)) {
					locatorType = sheet.getRow(i).getCell(1).getRichStringCellValue().toString();
					locatorValue = sheet.getRow(i).getCell(2).getRichStringCellValue().toString();
					break;
				}

			}
		}
		return locatorType + ":" + locatorValue;
	}
}
