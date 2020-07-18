package com.automation.web.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.web.interfaces.IWebActions;

public class ActionUtils extends UiDropDownUtils implements IWebActions {

	Actions action;

	void ActionUtils() {
		action = new Actions(UiDriver.driver);
	}

	public void actionClick(WebElement we) {
		action.click().build().perform();
	}

	public void actionClick() {
		// Actions action = new Actions(UiDriver.driver);
		action.click();
	}

	/**
	 * To move the web element
	 * 
	 * @param we
	 */
	public void moveToElement(WebElement we) {
		// Actions action = new Actions(UiDriver.driver);
		action.moveToElement(we);
	}

	/**
	 * To double click on the object
	 * 
	 * @param we
	 */
	public void doubleClick(WebElement we) {
		// Actions action = new Actions(UiDriver.driver);
		action.doubleClick(we);
	}

	/**
	 * To right click on the object
	 * 
	 * @param we
	 */
	public void contextClick(WebElement we) {
		// Actions action = new Actions(UiDriver.driver);
		action.contextClick(we);
	}

	/**
	 * To right click on the object
	 * 
	 * @param we
	 */
	public void contextClick() {
		// Actions action = new Actions(UiDriver.driver);
		action.contextClick();
	}

	public void clickAndHold(WebElement we) {
		// Actions action = new Actions(UiDriver.driver);
		action.clickAndHold(we);
	}

	public void clickAndHold() {
		// Actions action = new Actions(UiDriver.driver);
		action.clickAndHold();

	}

}
