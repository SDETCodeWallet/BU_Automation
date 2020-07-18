/**
* AutomationRunner.java - Controller file to control the execution of Web and API automation. .   
* @author  Shubham Goyal
* @version 1.0 
*/

package com.automation.TestRunner;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.automation.api.impl.APIDriver;
import com.automation.api.interfaces.IApi;
import com.automation.application.pages.WebPages;
import com.automation.constants.GlobalConstants;
import com.automation.reporter.ExtentReport;
import com.automation.web.impl.UiDriver;
import com.automation.web.interfaces.IWeb;

public abstract class AutomationRunner extends GlobalConstants {

	protected IWeb driver = new UiDriver();

	protected IApi apidriver = new APIDriver();

	protected WebPages UiPages = new WebPages();

	protected ExtentReport extentReporter = new ExtentReport();

	public Logger log = Logger.getLogger(AutomationRunner.class);

	/**
	 * Extent report configuration before starting of the test suite. 
	 */
	@BeforeSuite
	public void runnerInnovation() {
		ExtentReport.startExtentReport();
	}

	/**
	 * Tear down of extent report at the end of test suite execution
	 */
	@AfterSuite
	public void runnerTearDown() {
		ExtentReport.endExtendReport();
	}

	/**
	 * To set the test case name inside the test case name in extent reports
	 * @param method
	 */
	@BeforeMethod
	public void setTestCaseName(Method method) {
		extentReporter.setTestCaseName(method.getName());
	}
}
