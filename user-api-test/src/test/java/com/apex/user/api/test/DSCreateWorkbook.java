package com.apex.user.api.test;
import java.io.*;
import org.apache.poi.*;
import org.apache.poi.xssf.binary.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class DSCreateWorkbook {
	public static void main(String[] args) throws Exception{

		// create blank workbook
		XSSFWorkbook workbook =new XSSFWorkbook();
		//create filesystem using specific name
		FileOutputStream out=new FileOutputStream(new File("createworkbook.xlsx"));
		//write operation workbook using file out object
		workbook.write(out);
		out.close();
		System.out.println("createworkbook.xls writtensuccessfully");
 
	}
}
