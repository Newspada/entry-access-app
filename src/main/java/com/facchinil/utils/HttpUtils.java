package com.facchinil.utils;

import java.time.Duration;
import java.time.Instant;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpUtils {
	
	private HttpUtils() {
	    throw new IllegalStateException();
	  }
	
	@SneakyThrows
	public static <A> A getObject(String url, Class<A> clazz) {
    	log.info("Start GET request from " + url);
    	Instant atStart = Instant.now();
		HttpGet request = new HttpGet(url);
        try(CloseableHttpClient client = HttpClients.createDefault()) {
	        CloseableHttpResponse response = client.execute(request);
	        Instant atEnd = Instant.now();
	    	log.info("GET request finished after " + Duration.between(atStart, atEnd).toMillis() + " ms");
	        HttpEntity entity = response.getEntity();
	        A obj = new Gson().fromJson(EntityUtils.toString(entity), clazz);
	        response.close();
	        return obj;
        }
	}
}
