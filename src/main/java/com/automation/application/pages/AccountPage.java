/**
* AccountPage.java - Specified all the function related to account page.   
* @author  Shubham Goyal
* @version 1.0 
*/

package com.automation.application.pages;

import com.automation.TestRunner.AutomationRunner;
import com.automation.web.impl.UiValidation;
import com.automation.web.impl.WebLocators;

public class AccountPage extends AutomationRunner {

	private String locatorFileName = "accountPageLocators";

	/**
	 * To validate user is sign in
	 * 
	 * @param expectedText
	 * @throws LocatorExceptions
	 */
	public void validateUserIsSignin(String expectedText) {
		UiValidation.validateMessage(driver.getText(WebLocators.getPropLocator(locatorFileName, "userNameTxt")),
				expectedText);
	}
}
