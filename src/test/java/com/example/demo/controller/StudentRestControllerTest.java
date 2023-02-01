package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

class StudentRestControllerTest {

	@Test
	void testStatusIsOk() throws URISyntaxException, IOException, InterruptedException {
		HttpGet request = new HttpGet("http://localhost:8080/api/info");
		HttpClientBuilder client = HttpClientBuilder.create();
		CloseableHttpResponse response = client.build().execute(request);

		// test status code is OK
		assertEquals(response.getStatusLine().getStatusCode(), 200);

		String mimeType = ContentType.get(response.getEntity()).getMimeType();
		// test contenttype is json
		assertEquals("application/json", mimeType);

	}

}
