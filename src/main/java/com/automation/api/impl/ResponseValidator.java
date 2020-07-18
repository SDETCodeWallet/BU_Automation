package com.automation.api.impl;

import org.apache.log4j.Logger;

import com.automation.api.interfaces.IApiResponseValidator;

import io.restassured.response.Response;

public class ResponseValidator implements IApiResponseValidator {

	public Logger log = Logger.getLogger(APIDriver.class);

	/**
	 * To validate the status code http request
	 * 
	 * @param statusCode
	 */
	public void validateStatusCode(int statusCode) {
	}

	/**
	 * To validate the response body of http request
	 * 
	 * @param respBody
	 * @param jsonPath
	 * @param expectedValue
	 */
	public void validateResponseBody(Response respBody, String jsonPath, String expectedValue) {
	}

	/**
	 * To validate the response content type
	 * 
	 * @param contentName
	 * @param expectedValue
	 */
	public void validateResponseContentType(String contentName, String expectedValue) {
	}

	/**
	 * To Validate the response json value
	 * 
	 * @param jsonPath
	 * @param expectedJsonValue
	 */
	public void validateResponseValue(String jsonPath, String expectedJsonValue) {
	}

}
