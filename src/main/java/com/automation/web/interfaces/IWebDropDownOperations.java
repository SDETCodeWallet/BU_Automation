package com.automation.web.interfaces;

import org.openqa.selenium.WebElement;

public interface IWebDropDownOperations {
	
	public void selectByValue(WebElement we, String value);

	public void selectByIndex(WebElement we, int indexValue);

	public void selectByVisibleText(WebElement we, String VisibleText);

	public void deSelectAll(WebElement we);

	public void selectAll(WebElement we);

}
