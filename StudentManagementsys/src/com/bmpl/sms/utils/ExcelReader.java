package com.bmpl.sms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bmpl.sms.CommonGenricDTO.CommonGenricDTO;

public class ExcelReader {
	

	public static ArrayList<CommonGenricDTO> readExcel(String str) throws IOException {	
		File f = new File(str);
		
		FileInputStream fs = new FileInputStream(f);
		
		ArrayList<CommonGenricDTO> cDTO= new ArrayList<>();
		
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rows = sheet.rowIterator();  
		boolean firstRow = false;
		while(rows.hasNext())
		{
			
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			CommonGenricDTO cmnDTO = new CommonGenricDTO();
			int columnCount = 1; 
			if(firstRow == true) {
				
			while(cells.hasNext())
			{
				Cell cell = cells.next(); 
				
				if(cell.getCellType() == CellType.NUMERIC && columnCount == 1) {
					if(columnCount == 1) {
						System.out.println(cell.getNumericCellValue());
					}
				}
				else if(cell.getCellType() == CellType.STRING )
				{
					
					if(columnCount == 2) {
						cmnDTO.setDescription(cell.getStringCellValue());
						System.out.println(cell.getStringCellValue());
					}
					if(columnCount == 3) {		
						cmnDTO.setValue(cell.getStringCellValue());
						System.out.println(cell.getStringCellValue());
					}
					if(columnCount == 4) {
						cmnDTO.setStatus(cell.getStringCellValue());
						System.out.println(cell.getStringCellValue());
					}
					if(columnCount == 5) {
						cmnDTO.setKey(cell.getStringCellValue());		
						System.out.println(cell.getStringCellValue());
					}
					
				}
				columnCount++;
				
			}
			cDTO.add(cmnDTO);
			}
			firstRow = true;
		}
		return cDTO;	
	}

//public static void main(String args[]) throws IOException
//{
//	ExcelReader.readExcel("D:\\sms.xlsx");
//}
	
}
