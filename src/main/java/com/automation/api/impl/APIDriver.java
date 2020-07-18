/**
* APIDriver.java - Represents all the functions to validate the HTTP response body.   
* @author  Shubham Goyal
* @version 1.0 
*/

package com.automation.api.impl;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import com.automation.api.interfaces.IApi;
import com.automation.constants.GlobalConstants.HttpMethodType;
import com.automation.exceptions.APIExceptions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIDriver extends ResponseValidator implements IApi {

	private String basePath = "";

	public Logger log = Logger.getLogger(APIDriver.class);

	/**
	 * this http request vak
	 */
	private RequestSpecification httpRequest;

	/**
	 * resp variable declaration for httpResponse
	 */

	protected static Response resp;

	public void setBasePath(String hostName) {
		this.basePath = hostName;
		if (basePath.length() > 0 && hostName.contains("http")) {
			log.info("Enter the application base path: " + basePath);
			RestAssured.basePath = basePath;
			httpRequest = RestAssured.given().baseUri(basePath);
		} else {
			try {
				log.error("Please provide the correct application base path");
				throw new APIExceptions("Please provide application basepath");
			} catch (APIExceptions e) {
				e.printStackTrace();
				return;
			}
		}
	}

	/**
	 * Reset the api Driver to null
	 */
	public void resetApiDriver() {
		log.info("Reset http request");
		httpRequest = null;
	}

	public void sendRequest(HttpMethodType method, String resourcePath) {
		if (resourcePath.length() <= 0) {
			try {
				log.error("Please provide the resource path");
				throw new APIExceptions("Please provide the resource path");
			} catch (APIExceptions e) {
				e.printStackTrace();
				return;
			}
		}

		log.info("User send the " + method + " to " + basePath + resourcePath);
		switch (method) {

		case GET:
			resp = httpRequest.given().basePath(resourcePath).get();
			break;
		case POST:
			resp = httpRequest.given().basePath(resourcePath).post();
			break;
		case DELETE:
			resp = httpRequest.given().basePath(resourcePath).delete();
			break;
		case PATCH:
			resp = httpRequest.given().basePath(resourcePath).patch();
			break;
		default:
			try {
				log.error(method + " invalid method type");
				throw new APIExceptions(method + " invalid method type");
			} catch (APIExceptions e) {
				e.printStackTrace();
			}
			break;
		}
	}

	/**
	 * To set the content type
	 */
	public void setContentType(ContentType contentType) {
		log.info("User set the content type as " + contentType);
		httpRequest.given().contentType(contentType);
	}

	/**
	 * To set the content type
	 */
	public void setContentType(String contentType) {
		log.info("User set the content type as " + contentType);
		httpRequest.given().contentType(contentType);
	}

	JSONObject requestParams = new JSONObject();

	/**
	 * To set the request body
	 */
	@SuppressWarnings("unchecked")
	public void setBody(String key, String value) {
		log.info("user set the json body");
		requestParams.put(key, value);
		httpRequest.body(requestParams.toJSONString());
	}

	/**
	 * To set the json body
	 */
	public void setJsonBody(JSONObject FilePath) {
		log.info("Set the json body");
		httpRequest.given().body(FilePath);
	}

	/**
	 * To set the json body
	 */
	public void setBody(JSONObject jsonObject) {
		log.info("Set the json body");
		httpRequest.body(jsonObject);

	}

	/**
	 * To get the response
	 */
	public Response getResponse() {
		return resp;
	}

	/**
	 * To get the status code
	 */
	public int getStatusCode() {
		log.info("Get the status code" + resp.getStatusCode());
		return resp.getStatusCode();

	}

	/**
	 * To get the response value
	 */
	public String getJsonValue(String jsonPath) {
		log.info(resp.jsonPath().getString(jsonPath));
		return resp.jsonPath().getString(jsonPath);

	}

	/**
	 * To get the response details
	 */
	public String printResponseDetails() {
		log.info("Response body is " + resp.prettyPrint());
		return resp.prettyPrint();
	}

}