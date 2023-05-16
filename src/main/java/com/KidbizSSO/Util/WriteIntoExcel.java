package com.KidbizSSO.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
	public static Cell cell;

	public static void writeNewUserName(String dataReceive) throws Exception {
		try {
			File src = new File(properties.getProperty("excelFilePathForCanvas"));

			FileInputStream fis = new FileInputStream(src);

			XSSFWorkbook xsf = new XSSFWorkbook(fis);

			XSSFSheet sheet = xsf.getSheetAt(0);

			for (int i = 1; i <= 100; i++) {
				row = sheet.getRow(i);
				if (row == null) {
					System.out.println("Row: " + i + " is blank");
					for (int j = 2; j <= 20; j++) {
						row = sheet.createRow(i);
						cell = row.getCell(j);
						if (cell == null || cell.getCellType() == CellType.BLANK) {
							System.out.println("Cell: " + j + " is blank");
							cell = row.createCell(j);
							cell.setCellValue(dataReceive);
							break;
						} else if (cell != null || cell.getCellType() != CellType.BLANK) {
							System.out.println("Cell is not null");
							continue;
						}
						break;
					}

				} else if (row != null) {
					continue;
				}
				break;
			}

			FileOutputStream fos = new FileOutputStream(src);

			xsf.write(fos);

			xsf.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
