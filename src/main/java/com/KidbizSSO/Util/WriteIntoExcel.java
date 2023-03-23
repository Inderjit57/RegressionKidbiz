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
	 */

	public static void writeNewUserName(String dataReceive) throws Exception {
		File src = new File(properties.getProperty("excelFilePathForCanvas"));

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook xsf = new XSSFWorkbook(fis);

		XSSFSheet sheet = xsf.getSheetAt(0);

		// Write data in excel
		Row row = sheet.createRow(2);
		Cell cell = row.createCell(2);
		cell.setCellValue(dataReceive);

		FileOutputStream fos = new FileOutputStream(src);

		xsf.write(fos);

		xsf.close();

	}
	
	public static void writeNewCourseName(String dataReceive) throws Exception {
		File src = new File(properties.getProperty("excelFilePathForCanvas"));

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook xsf = new XSSFWorkbook(fis);

		XSSFSheet sheet = xsf.getSheetAt(1);

		// Write data in excel
		Row row = sheet.createRow(2);
		Cell cell = row.createCell(1);
		cell.setCellValue(dataReceive);

		FileOutputStream fos = new FileOutputStream(src);

		xsf.write(fos);

		xsf.close();

	}

}
