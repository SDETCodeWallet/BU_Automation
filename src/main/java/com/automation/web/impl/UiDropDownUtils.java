package com.automation.web.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.automation.web.interfaces.IWebDropDownOperations;

public class UiDropDownUtils implements IWebDropDownOperations {


	/**
	 * To select the drop down value
	 * 
	 * @param we
	 * @param value
	 */
	public void selectByValue(WebElement we, String value) {
		Select dropDownObj = new Select(we);
		dropDownObj.selectByValue(value);
	}

	/**
	 * To select the dropdown object by using visible text
	 * 
	 * @param we
	 * @param VisibleText
	 */
	public void selectByVisibleText(WebElement we, String VisibleText) {
		Select dropDownObj = new Select(we);
		dropDownObj.selectByVisibleText(VisibleText);
	}

	/**
	 * To select the drop down object by index
	 * 
	 * @param we
	 * @param indexValue
	 */
	public void selectByIndex(WebElement we, int indexValue) {
		Select dropDownObj = new Select(we);
		dropDownObj.deselectByIndex(indexValue);
	}

	@Override
	public void deSelectAll(WebElement we) {
		Select dropDownObj = new Select(we);
		dropDownObj.deselectAll();

	}

	@Override
	public void selectAll(WebElement we) {

	}

}
