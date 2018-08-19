package com.cricinfo.templateutility;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtility {

	public static String triggerService(String jsonReqObj, String URL, HttpMethod post, MediaType type) {
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(type);
		HttpEntity<String> entity = new HttpEntity<String>(jsonReqObj, headers);
		String body = "";
		try{
			ResponseEntity<String> response = template.exchange(URL, post, entity, String.class);
			body = response.getBody();
			System.out.println("Response : " + body);
			return body;
		}catch(HttpStatusCodeException httpException){
			System.out.println("HttpStatusCode  : " + httpException.getRawStatusCode());
			body = httpException.getResponseBodyAsString();
			System.out.println("Failed Response Body : " + body);
			return body;
		}
	}
}
