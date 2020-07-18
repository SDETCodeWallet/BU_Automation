package com.automation.api.testcases;

import org.testng.annotations.Test;
import com.automation.TestRunner.AutomationRunner;
import com.automation.constants.GlobalConstants;
import com.automation.utils.JsonFileUtil;
import com.automation.utils.PropertiesFileUtils;

import io.restassured.http.ContentType;

public class ValidateCreateUser extends AutomationRunner {
	private String applicationBasePath = PropertiesFileUtils.readConfigFile(GlobalConstants.resourcesPath + "APIconfig",
			"apiURL");

	@Test
	public void validateGetRequest() {
		extentReporter.reportInfoLog("Set the application base path " + applicationBasePath);
		apidriver.setBasePath(applicationBasePath);

		extentReporter.reportInfoLog("Set request content type as" + ContentType.JSON);
		apidriver.setContentType(ContentType.JSON);

		JsonFileUtil.modifyJsonValue(GlobalConstants.ApiConstants.CREATEUSERJSONBODY, "name", "Testingpurpse");

		extentReporter.reportInfoLog("Set request json body as  " + JsonFileUtil.readJsonData("createUser"));
		apidriver.setBody(JsonFileUtil.readJsonData("createUser"));

		extentReporter
				.reportInfoLog("POST request to " + applicationBasePath + GlobalConstants.ApiConstants.CREATEUSER);
		apidriver.sendRequest(HttpMethodType.POST, GlobalConstants.ApiConstants.CREATEUSER);

		extentReporter.reportInfoLog("Validate status code is" + GlobalConstants.ApiConstants.HTTP_OK);
		apidriver.validateStatusCode(GlobalConstants.ApiConstants.HTTP_OK);

		extentReporter.reportInfoLog("Validate " + apidriver.getJsonValue("data.name") + " is equal to userName");
		apidriver.validateResponseValue("data.name", "Testingpurpse");

		extentReporter.reportInfoLog("Printing Response body " + apidriver.printResponseDetails());
		apidriver.printResponseDetails();
	}

}
