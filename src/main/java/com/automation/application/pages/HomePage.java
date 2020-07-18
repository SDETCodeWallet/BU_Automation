/**
* HomePage.java - Specified all the function related to Home page.   
* @author  Shubham Goyal
* @version 1.0 
*/

package com.automation.application.pages;

import com.automation.TestRunner.AutomationRunner;
import com.automation.web.impl.WebLocators;

public class HomePage extends AutomationRunner {

	private String locators = "homePageLocators";

	/**
	 * To Navigate to the login page
	 * 
	 * @return SigninPage
	 */
	public SigninPage navigateToLoginPage() {
		driver.click(WebLocators.getXMLLocator(locators, "signInLink"));
		return new SigninPage();
	}

	/**
	 * To click on T- Shirt link option from application header
	 * 
	 * @return TshirtPage;
	 */
	public TshirtPage clickOnTShirtPage() {
		driver.click(WebLocators.getXMLLocator(locators, "TshirtLink"));
		return new TshirtPage();
	}

}
