package com.apex.user.api.test;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
public class GsonExample3 {

	public static void main(String[] args) {
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		try {
			Reader reader=new FileReader("C:\\Users\\anand\\Desktop\\Data_testing\\staff.json");
			//convert JSON to JSON element and later to String 
			JsonElement json=gson.fromJson(reader,JsonElement.class);
			String jsonInString=gson.toJson(json);
			System.out.println(jsonInString);
		}catch(IOException e) {e.printStackTrace();}

	}

}
