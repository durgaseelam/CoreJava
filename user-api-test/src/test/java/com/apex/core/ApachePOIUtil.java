package com.apex.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;
import java.io.File.*;
import java.io.FileInputStream;
import java.io.PushbackInputStream;

public class ApachePOIUtil {
	public static XSSFCell[][] getData(String filePath) throws Exception {
		XSSFRow row = null;		
		int rowCount = 0;
		ArrayList arrayList = new ArrayList();		
		int size = arrayList.size();		
		XSSFCell[][] tabArray = new XSSFCell[4][2];		
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(filePath);
		XSSFSheet spreadsheet = workbook.getSheetAt(0);
		for (Row rows : spreadsheet) {
			for (Cell cell : rows) {
				arrayList.add(cell);
			}			
		}
		fis.close();
		for(int x = 1; x >= 0; x--)
		{
		    arrayList.remove(x);
		}		
		int k=0;
	    for(int i = 0; i < 3; i++){
	        for(int j = 0; j < 2; j++){
	            tabArray[i][j] =(XSSFCell)arrayList.get(k);
	            k++;	            
	        }
	    }     
	    System.out.println("tabarrray "+tabArray);
		return tabArray;
	}
}
