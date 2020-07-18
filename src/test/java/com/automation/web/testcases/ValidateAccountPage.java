package com.automation.web.testcases;

import org.testng.annotations.Test;

import com.automation.TestRunner.AutomationRunner;
import com.automation.utils.PropertiesFileUtils;

public class ValidateAccountPage extends AutomationRunner {

	private String email = PropertiesFileUtils.readConfigFile(resourcesPath + "webconfig", "userName");
	private String password = PropertiesFileUtils.readConfigFile(resourcesPath + "webconfig", "password");
	private String userName = "Test Purchase";
	private String webUrl = PropertiesFileUtils.readConfigFile(resourcesPath + "webconfig", "webURL");

	@SuppressWarnings("static-access")
	@Test(enabled = true, priority = 1)
	public void validate_AccountPage() {
		extentReporter.setTestCaseName("Validate the Account page");

		log.info("User select the browser and launch the application : --> " + webUrl);
		extentReporter.reportInfoLog("User open the browser and open the application: " + webUrl);

		driver.setDriver(BrowserType.Chrome);
		UiPages.homepage = driver.launchApplication(webUrl);

		log.info("User Navigate to the login page : --> ");
		extentReporter.reportInfoLog("User navigate to login page");
		UiPages.loginPage = UiPages.homepage.navigateToLoginPage();

		extentReporter.reportInfoLog("User enter " + email + " in the password field");
		log.info("User enter the email addreess  --> " + email);
		UiPages.loginPage.enterEmailAddress(email);

		extentReporter.reportInfoLog("User enter " + password + " in the password field");
		log.info("User enter the password   --> " + password);
		UiPages.loginPage.enterPassword(password);

		extentReporter.reportInfoLog("User click on sign in button");
		log.info("User Click on sign in button");
		UiPages.accountPage = UiPages.loginPage.clickOnSignInButton();

		extentReporter.reportInfoLog("Validate the User is logged in succesfully");
		log.info("Validate user is logged successfully");
		UiPages.accountPage.validateUserIsSignin(userName);

		extentReporter.reportInfoLog("Browser is closed");
		log.info("Browser is closing");
		driver.browserClose();
	}
}
