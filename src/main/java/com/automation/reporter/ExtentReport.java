package com.automation.reporter;

import com.automation.constants.GlobalConstants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	static ExtentTest test;
	static ExtentReports report;

	/**
	 * To set up the extent reports
	 */

	public static void startExtentReport() {
		report = new ExtentReports(GlobalConstants.EXTENTREPORT_PATH, true);
	}

	/**
	 * To set the test case name
	 * 
	 * @param testCaseName
	 */
	public void setTestCaseName(String testCaseName) {
		test = report.startTest(testCaseName);
	}

	/**
	 * To tear down the extent reports
	 */

	public static void endExtendReport() {
		report.endTest(test);
		report.flush();
	}

	/**
	 * To enter the message log inb extent reports
	 * 
	 * @param infoMessage
	 */
	public void reportInfoLog(String infoMessage) {
		test.log(LogStatus.INFO, infoMessage);
	}

	/**
	 * To enter the fail log in the extent reports
	 * 
	 * @param errorLog
	 */
	public static void failLog(String errorLog) {
		test.log(LogStatus.FAIL, errorLog);
	}
}
