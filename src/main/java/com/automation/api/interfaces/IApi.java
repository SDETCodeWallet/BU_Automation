/**
* IApi.java - Define all the generic function to deal with the http request 
* @author  Shubham Goyal
* @version 1.0 
* @see IApiResponseValidator
*/

package com.automation.api.interfaces;

import org.json.simple.JSONObject;

import com.automation.constants.GlobalConstants.HttpMethodType;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public interface IApi extends IApiResponseValidator {

	/**
	 * To set the API base path of http Request
	 * 
	 * @param basePath
	 */
	public void setBasePath(String basePath);

	/**
	 * To send the http request to the server.
	 * 
	 * @param methodType
	 * @param basePath
	 */
	public void sendRequest(HttpMethodType methodType, String basePath);

	/**
	 * To set the request body of http request
	 * 
	 * @param contentType
	 */
	public void setContentType(ContentType contentType);

	/**
	 * To set the Content Type of http request
	 * 
	 * @param contentType
	 */
	public void setContentType(String contentType);

	/**
	 * To set the Request body of http request
	 * 
	 * @param jsonObject
	 */
	public void setBody(JSONObject jsonObject);

	/**
	 * To set the request body of http request
	 * 
	 * @param key
	 * @param value
	 */
	public void setBody(String key, String value);

	/**
	 * To get the response body of http request Get the response body
	 * 
	 * @return Response;
	 */
	public Response getResponse();

	/**
	 * To reset the http request
	 */
	public void resetApiDriver();

	/**
	 * To get the http response status code.
	 * 
	 * @return int
	 */
	public int getStatusCode();

	/**
	 * To get the json response value for the specified JSON path
	 * 
	 * @param jsonPath
	 * @return String
	 */
	public String getJsonValue(String jsonPath);

	/**
	 * To print the http response body
	 * 
	 * @return
	 */
	public String printResponseDetails();

}
