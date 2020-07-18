/**
* SigninPage.java - Specified all the function related to Signin page.   
* @author  Shubham Goyal
* @version 1.0 
*/

package com.automation.application.pages;

import com.automation.TestRunner.AutomationRunner;
import com.automation.web.impl.WebLocators;

public class SigninPage extends AutomationRunner {

	private String locators = "signInLocators.xls";

	/**
	 * To enter the user email address
	 * 
	 * @param emailAddress
	 */
	public void enterEmailAddress(String emailAddress) {
		driver.sendKeys(WebLocators.getExcelLocators(locators, "SignInPage", "emailInp"), emailAddress);
	}

	/**
	 * To enter the user password
	 * 
	 * @param password
	 */
	public void enterPassword(String password) {
		driver.sendKeys(WebLocators.getExcelLocators(locators, "SignInPage", "passwordInp"), password);
	}

	/**
	 * To click on sign in button
	 * 
	 * @return AccountPage
	 */
	public AccountPage clickOnSignInButton() {
		driver.click(WebLocators.getExcelLocators(locators, "SignInPage", "signInBtn"));
		return new AccountPage();
	}
}
