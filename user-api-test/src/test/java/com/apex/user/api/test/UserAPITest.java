package com.apex.user.api.test;
import java.io.*;
import  org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;

public class UserAPITest {
	public static void main(String[] args) throws ClientProtocolException,IOException{
		//define URL
		String url="https://reqres.in/api/users/10";
		String posturl="https://reqres.in/api/users/";
		//create HTTPClient
		HttpClient client =HttpClientBuilder.create().build();
		//create the request
		HttpGet requestMsg=new  HttpGet(url);
		HttpPost postRequest=new HttpPost(posturl);
		//send the request and receive the response
		HttpResponse response=client.execute(requestMsg);
		HttpResponse postResponse=client.execute(postRequest);
		//validate the response
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getStatusLine().getReasonPhrase());
		if(response.getStatusLine().getStatusCode()==200) {
			System.out.println("test is success");
		}else {
			System.out.println("test failed");
		}
		System.out.println(postResponse.getStatusLine().getStatusCode());
		System.out.println(postResponse.getStatusLine().getReasonPhrase());
		if(postResponse.getStatusLine().getStatusCode()==201) {
			System.out.println("test is success");
		}else {
			System.out.println("test failed");
		}
	BufferedReader br=new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
	String output;
	System.out.println("Output from Server ..\n");
	while((output=br.readLine())!=null) {
		System.out.println(output);
	}
	
	}
}
