/**
* TshirtPage.java - Specified all the function related to Tshirt page.   
* @author  Shubham Goyal
* @version 1.0 
*/

package com.automation.application.pages;

import com.automation.TestRunner.AutomationRunner;
import com.automation.web.impl.UiValidation;
import com.automation.web.impl.WebLocators;

public class TshirtPage extends AutomationRunner {

	private String locators = "signInLocators.xls";

	/**
	 * Select sort by filter to sort the t shirt page
	 * 
	 * @param sortByOptionToSelect
	 */
	public void sortPageBy(String sortByOptionToSelect) {
		driver.selectByVisibleText(WebLocators.getExcelLocators(locators, "TshirtPage", "sortBy"),
				sortByOptionToSelect);
	}

	public void validateSelectedSortByOption(String expectedOption) {
		UiValidation.validateMessage(
				driver.getText(WebLocators.getExcelLocators(locators, "TshirtPage", "sortBy")),
				expectedOption);
	}

}
