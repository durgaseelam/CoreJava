package com.apex.user.api.test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DSWritesheet {	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//create blank workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet spreadsheet=workbook.createSheet("Employee Info");
		XSSFRow row;
		Map <String,Object[]> empinfo=new TreeMap <String,Object[]>();
		empinfo.put("1",new Object[] {"EMP ID","EMP NAME","DESIGNATION"});
		empinfo.put("2",new Object[] {"ep01","GP","TM"});
		//iterate and write to sheet 
		Set <String> keyid =empinfo.keySet();
		int rowid=0;
		for(String key:keyid) {
		row=spreadsheet.createRow(rowid++);
		Object[] ObjectArr=empinfo.get(key);
		int cellid=0;
		for(Object obj:ObjectArr) {
			Cell cell=row.createCell(cellid++);
			cell.setCellValue((String)obj);
		}
		}
		//write the workbook in file system 
		FileOutputStream out=new FileOutputStream(new File("Writesheet.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println(" writesheet.xlsx writtensuccesfully ");
	}

}
