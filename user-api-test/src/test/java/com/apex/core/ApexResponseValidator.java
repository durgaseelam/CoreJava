package com.apex.core;

import org.apache.http.HttpResponse;
import org.testng.Assert;

public class ApexResponseValidator {
	public static void performBasicResponseValidations(HttpResponse response, int statusCode, String statusMessage) {
		Assert.assertEquals(response.getStatusLine().getStatusCode(), statusCode);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), statusMessage);
	}

}
