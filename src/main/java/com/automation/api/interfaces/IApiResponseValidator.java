/**
* IApiResponseValidator.java - Define all functions to validate the http responses 
* @author  Shubham Goyal
* @version 1.0 
*/ 

package com.automation.api.interfaces;

import io.restassured.response.Response;

public interface IApiResponseValidator {

	/**
	 * To validate the status code http request
	 * 
	 * @param statusCode
	 */
	public void validateStatusCode(int statusCode);

	/**
	 * To validate the response body of http request
	 * 
	 * @param respBody
	 * @param jsonPath
	 * @param expectedValue
	 */
	public void validateResponseBody(Response respBody, String jsonPath, String expectedValue);

	/**
	 * To validate the response content type
	 * 
	 * @param contentName
	 * @param expectedValue
	 */
	public void validateResponseContentType(String contentName, String expectedValue);

	/**
	 * To Validate the response json value
	 * 
	 * @param jsonPath
	 * @param expectedJsonValue
	 */
	public void validateResponseValue(String jsonPath, String expectedJsonValue);

}
