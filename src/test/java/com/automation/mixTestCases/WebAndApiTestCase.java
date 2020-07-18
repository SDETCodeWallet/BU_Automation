package com.automation.mixTestCases;

import org.testng.annotations.Test;

import com.automation.TestRunner.AutomationRunner;
import com.automation.application.pages.HomePage;
import com.automation.constants.GlobalConstants;
import com.automation.utils.PropertiesFileUtils;

public class WebAndApiTestCase extends AutomationRunner {

	private String email = PropertiesFileUtils.readConfigFile(resourcesPath + "webconfig", "userName");
	private String password = PropertiesFileUtils.readConfigFile(resourcesPath + "webconfig", "password");
	private String userName = "Test Purchase";

	private String webUrl = PropertiesFileUtils.readConfigFile(resourcesPath + "webconfig", "webURL");
	private String apiBasePath = PropertiesFileUtils.readConfigFile(resourcesPath + "APIconfig", "apiURL");

	@SuppressWarnings("static-access")
	@Test(enabled = true, priority = 1)
	public void validate_AccountPage() {
		extentReporter.reportInfoLog("User open the browser and open the application: " + webUrl);
		driver.setDriver(BrowserType.Chrome);

		HomePage homepage = driver.launchApplication(webUrl);

		extentReporter.reportInfoLog("User navigate to login page");
		UiPages.loginPage = homepage.navigateToLoginPage();

		extentReporter.reportInfoLog("User enter " + email + " in the password field");
		UiPages.loginPage.enterEmailAddress(email);

		extentReporter.reportInfoLog("User enter " + password + " in the password field");
		UiPages.loginPage.enterPassword(password);

		extentReporter.reportInfoLog("User click on sign in button");
		UiPages.accountPage = UiPages.loginPage.clickOnSignInButton();

		extentReporter.reportInfoLog("Validate the User is logged in succesfully");
		UiPages.accountPage.validateUserIsSignin(userName);

		extentReporter.reportInfoLog("Browser is closed");
		driver.browserClose();

	}

	@Test(enabled = true, priority = 1)
	public void validate_ApiTestCase() {
		extentReporter.reportInfoLog("Set the application base path as " + apiBasePath);
		apidriver.setBasePath(apiBasePath);

		extentReporter
				.reportInfoLog("Send the request to " + apiBasePath + GlobalConstants.ApiConstants.GETALLEMPLOYEE);

		apidriver.sendRequest(HttpMethodType.GET, GlobalConstants.ApiConstants.GETALLEMPLOYEE);

		extentReporter.reportInfoLog("Response Body: -->  " + apidriver.printResponseDetails());

		apidriver.printResponseDetails();

		extentReporter.reportInfoLog("Validate the status code is: -->  " + GlobalConstants.ApiConstants.HTTP_OK);

		apidriver.validateStatusCode(GlobalConstants.ApiConstants.HTTP_OK);
	}
}
