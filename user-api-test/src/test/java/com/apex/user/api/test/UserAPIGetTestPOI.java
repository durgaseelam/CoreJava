package com.apex.user.api.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.apex.core.ApexBaseTest;
import com.apex.core.ApexHttpUtil;
import com.apex.core.ApexResponseValidator;
import com.apex.core.JXLUtil;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.util.Iterator;
import java.util.List;

import com.apex.core.ApachePOIUtil;

public class UserAPIGetTestPOI extends ApexBaseTest implements UserConstant {
	@DataProvider(name = "getUserIds_dp")
	public XSSFCell[][] getUserIds() throws Exception {
		//String[][] userIds = { { "10", "Byron"}, { "11", "George"}, { "12", "Rachel" } };
		
		XSSFCell[][] userIds=ApachePOIUtil.getData("C:\\Users\\anand\\Desktop\\Data_testing\\Writesheet.xlsx");
		String newuserId=userIds.toString();
		System.out.println("from get UserIds "+newuserId);
		return userIds;
	}
	@Test(dataProvider = "getUserIds_dp")
	public void testGetwithSuccessData(String userId, String firstName) throws ClientProtocolException, IOException {
		String url = BASE_URL + "/" + userId;
		System.out.println("url is "+url);
		System.out.println("first name is "+firstName);
		// send and receive response
		HttpResponse response = ApexHttpUtil.sendAndReceiveGetRequest(url);
		// validate the response
		ApexResponseValidator.performBasicResponseValidations(response, STATUS_CODE_200, STATUS_MSG_OK);
		String responseString = ApexHttpUtil.getResponseString(response);
		Assert.assertTrue(responseString.contains(firstName));

		// Assert.assertTrue(responseString.contains("Byron"));

	}

	@Test
	public void testGetwithBlank() throws ClientProtocolException, IOException {
		// step 1: define URL and prepare request msg
		String url = BASE_URL + "/";
		// step 2 : send and receive
		HttpResponse response = ApexHttpUtil.sendAndReceiveGetRequest(url);
		// validate the response and decide whether pass or fail
		ApexResponseValidator.performBasicResponseValidations(response, STATUS_CODE_200, STATUS_MSG_OK);
		// specific Validations
		String responseString = ApexHttpUtil.getResponseString(response);
		Assert.assertTrue(responseString.contains("first_name"));
	}

	@Test
	public void testGetwithAlphabet() throws ClientProtocolException, IOException {
		String url = "https://reqres.in/api/users/w";
		// send and receive response
		HttpResponse response = ApexHttpUtil.sendAndReceiveGetRequest(url);
		// validate the response
		Assert.assertEquals(response.getStatusLine().getStatusCode(), STATUS_CODE_404);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), STATUS_MSG_NOT_FOUND);

	}

	@Test
	public void testGetwithNonExistingId() throws ClientProtocolException, IOException {
		String url = "https://reqres.in/api/users/100";
		// send and receive response
		HttpResponse response = ApexHttpUtil.sendAndReceiveGetRequest(url);
		// validate the response
		Assert.assertEquals(response.getStatusLine().getStatusCode(), STATUS_CODE_404);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), STATUS_MSG_NOT_FOUND);
	}
}
