package com.apex.user.api.test;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.GsonBuilder;

public class GsonExample1 {
	public static void main(String[] args) {
		//object for regular printing 
		//Gson gson=new Gson();
		//to enable pretty print mode 
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		GsonStaff staff=createStaffObject();		
		//Java Objects to String 
		//String json=gson.toJson(staff);
		
		//java Objects to File
		try {
			FileWriter writer=new FileWriter("C:\\Users\\anand\\Desktop\\Data_testing\\staff.json");
			//gson.toJson(staff,writer);
			String json=gson.toJson(staff);
			System.out.println(json);
		}catch(IOException e) {e.printStackTrace();}
	}
private static GsonStaff createStaffObject() {
	GsonStaff staff=new GsonStaff();
	staff.setName("DS");
	staff.setAge(20);
	staff.setPosition(new String[] {"Founder","CTO","Writer"});
	Map<String,BigDecimal> salary=new HashMap(){{
		put("2010",new BigDecimal(10000));
		put("2012",new BigDecimal(12000));
		put("2018",new BigDecimal(14000));
	}};
	staff.setSalary(salary);
	staff.setSkills(Arrays.asList("java","python","node","kotlin"));
	return staff;
	}
}

