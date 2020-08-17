package com.apex.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApexHttpUtil {
	public static HttpResponse sendAndReceiveGetRequest(String url) throws IOException, ClientProtocolException {
		// create HTTPClient
		HttpClient client = HttpClientBuilder.create().build();
		// create the request
		HttpGet requestMsg = new HttpGet(url);
		// send the request and receive the response
		HttpResponse response = client.execute(requestMsg);
		return response;
	}
	
	public static HttpResponse sendAndReceiveDeleteRequest(String url) throws IOException, ClientProtocolException {
		// create HTTPClient
		HttpClient client = HttpClientBuilder.create().build();
		// create the request
		HttpDelete requestMsg = new HttpDelete(url);
		// send the request and receive the response
		HttpResponse response = client.execute(requestMsg);
		return response;
	}
	
	public static HttpResponse sendAndReceivePostRequest(String url,String reqStr) throws IOException, ClientProtocolException {
		// create HTTPClient
		HttpClient client = HttpClientBuilder.create().build();
		// create the request
		HttpPost requestMsg = new HttpPost(url);
		StringEntity entity=new StringEntity(reqStr);
		requestMsg.setEntity(entity);
		// send the request and receive the response
		HttpResponse response = client.execute(requestMsg);
		return response;
	}
	
	public static HttpResponse sendAndReceivePutRequest(String url,String reqStr) throws IOException, ClientProtocolException {
		// create HTTPClient
		HttpClient client = HttpClientBuilder.create().build();
		// create the request
		HttpPut requestMsg = new HttpPut(url);
		StringEntity entity=new StringEntity(reqStr);
		requestMsg.setEntity(entity);
		// send the request and receive the response
		HttpResponse response = client.execute(requestMsg);
		return response;
	}
	
	

	public static String getResponseString(HttpResponse response) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String line;
		String responseMessage = "";
		System.out.println("Output from Server ..\n");
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			responseMessage += line;
		}
		return responseMessage;

	}

}
