package com.automation.api.testcases;

import org.testng.annotations.Test;
import com.automation.TestRunner.AutomationRunner;
import com.automation.constants.GlobalConstants;
import com.automation.utils.PropertiesFileUtils;

public class ValidateGetRequest extends AutomationRunner {

	String basePath = PropertiesFileUtils.readConfigFile(GlobalConstants.resourcesPath + "APIconfig", "apiURL");

	@Test
	public void validateGetRequest() {
		apidriver.setBasePath(basePath);
		apidriver.sendRequest(HttpMethodType.GET, GlobalConstants.ApiConstants.GETALLEMPLOYEE);
		apidriver.printResponseDetails();
		apidriver.validateStatusCode(GlobalConstants.ApiConstants.HTTP_OK);
	}
}
