package com.automation.web.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.ITestResult;
import com.automation.TestRunner.AutomationRunner;
import com.automation.constants.GlobalConstants;
import com.automation.utils.PropertiesFileUtils;

public class ValidateTshirtTestCases extends AutomationRunner {

	@SuppressWarnings("static-access")
	@BeforeMethod
	public void launchApplication() throws Exception {
		driver.setDriver(BrowserType.Chrome);
		UiPages.homepage = driver.launchApplication(
				PropertiesFileUtils.readConfigFile(GlobalConstants.resourcesPath + "webconfig", "webURL"));
	}

	@SuppressWarnings("static-access")
	@Test(enabled = true, priority = 1)
	public void validate_TshirtPage() throws Exception {
		UiPages.tshirtPage = UiPages.homepage.clickOnTShirtPage();
		UiPages.tshirtPage.sortPageBy("Price: Highest first");
		UiPages.tshirtPage.validateSelectedSortByOption("Price: Lowest first");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.browserClose();
	}
}
