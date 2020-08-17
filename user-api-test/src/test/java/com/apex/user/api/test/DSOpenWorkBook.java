package com.apex.user.api.test;
import java.io.*;
import org.apache.poi.xssf.usermodel.*;
public class DSOpenWorkBook {
public static void main(String[] args) throws Exception{
	File file=new File("C:\\Users\\anand\\Desktop\\Data_testing\\createworkbook.xlsx");
	FileInputStream fip=new FileInputStream(file);
	//get workbook instance for xlsx file 
	XSSFWorkbook workbook=new XSSFWorkbook(fip);
	if(file.isFile()&&file.exists()) {
		System.out.println("workbook opened succesfully");
	}else {
		System.out.println("error to open workbook");
	}
}
}
