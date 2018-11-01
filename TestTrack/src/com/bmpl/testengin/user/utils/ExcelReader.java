package com.bmpl.testengin.user.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {
		
		String path = "D:\\Employee.xlsx";
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		
		
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		
		
		while(rows.hasNext())
		{
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext()) //boolean
			{
				Cell cell = cells.next(); //value
				if(cell.getCellType() == CellType.NUMERIC)
				{
					System.out.println(cell.getNumericCellValue());
				}
				
				else if(cell.getCellType() == CellType.STRING)
				{
					System.out.println(cell.getStringCellValue());
				}
			}
		}
		

	}

}
