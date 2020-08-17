package com.apex.user.api.test;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GsonExample2 {

	public static void main(String[] args) {
		Gson gson=new Gson();
		try {
			Reader reader=new FileReader("C:\\Users\\anand\\Desktop\\Data_testing\\staff.json");
			//convert JSON File to Java Object
			GsonStaff staff=gson.fromJson(reader, GsonStaff.class);
			//print staff object 
			System.out.println(staff);			
		}catch(IOException e) {e.printStackTrace();}

	}

}
