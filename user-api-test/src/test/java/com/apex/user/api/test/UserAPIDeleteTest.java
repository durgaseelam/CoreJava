package com.apex.user.api.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.core.ApexBaseTest;
import com.apex.core.ApexHttpUtil;

public class UserAPIDeleteTest extends ApexBaseTest implements UserConstant {

	@Test
	public void testDeletetwithExistingData() throws ClientProtocolException, IOException {
		String url = BASE_URL+"/2";
		// send and receive response
		HttpResponse response = ApexHttpUtil.sendAndReceiveDeleteRequest(url);
		// validate the response
		Assert.assertEquals(response.getStatusLine().getStatusCode(), STATUS_CODE_204);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), STATUS_MSG_NO_Content);

	}

}
