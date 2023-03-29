package com.KidbizSSO.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.KidbizSSO.BasePackage.BaseClass;

public class WriteIntoExcel extends BaseClass {

	/*
	 * This method is writing new users in an excel file located in the local repo.
	 * 
	 * This method is implemented in the following class: 1. CanvasCreateUserPage
	 * 
	 */

	public static Row row;

	public static void writeNewUserName(String dataReceive) throws Exception {
		File src = new File("C:\\Everything\\Demo.xlsx");

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook xsf = new XSSFWorkbook(fis);

		XSSFSheet sheet = xsf.getSheetAt(0);

		// Write data in excel
		row = sheet.createRow(2);
		Cell cell = row.createCell(2);
		cell.setCellValue(dataReceive);

		FileOutputStream fos = new FileOutputStream(src);

		xsf.write(fos);

		xsf.close();

	}

	public static void switchInvocationCount(int invoCount, String dataReceive) throws Exception {
		switch (invoCount) {
		case 1: {
			File src = new File("C:\\Everything\\Demo.xlsx");

			FileInputStream fis = new FileInputStream(src);

			XSSFWorkbook xsf = new XSSFWorkbook(fis);

			XSSFSheet sheet = xsf.getSheetAt(0);

			// Write data in excel
			row = sheet.createRow(1);
			Cell cell = row.createCell(1);
			cell.setCellValue(dataReceive);

			FileOutputStream fos = new FileOutputStream(src);

			xsf.write(fos);

			xsf.close();
			break;

		}
		case 2: {
			File src = new File(properties.getProperty("excelFilePathForCanvas"));

			FileInputStream fis = new FileInputStream(src);

			XSSFWorkbook xsf = new XSSFWorkbook(fis);

			XSSFSheet sheet = xsf.getSheetAt(0);

			// Write data in excel
			row = sheet.createRow(2);
			Cell cell = row.createCell(2);
			cell.setCellValue(dataReceive);

			FileOutputStream fos = new FileOutputStream(src);

			xsf.write(fos);

			xsf.close();
			break;
		}
		}

	}

	public static void writeNewCourseName(String dataReceive) throws Exception {
		File src = new File(properties.getProperty("excelFilePathForCanvas"));

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook xsf = new XSSFWorkbook(fis);

		XSSFSheet sheet = xsf.getSheet("Sheet2");

		// get all rows in the sheet
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 1; i >= rowCount; i++) {
			row = sheet.getRow(i);
			Cell cell = row.getCell(i);
//			String data = cell.getStringCellValue();

			if (cell != null) {
				System.out.println("Cell is not null");

			} else {
				System.out.println("Cell is null");
				Row row = sheet.createRow(i);
				cell = row.createCell(i);
				cell.setCellValue(dataReceive);
				break;
			}

		}

		FileOutputStream fos = new FileOutputStream(src);

		xsf.write(fos);

		xsf.close();

	}

}
