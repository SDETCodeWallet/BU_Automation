package com.automation.web.interfaces;

import org.openqa.selenium.WebElement;

public interface IWebActions {

	public void actionClick(WebElement we);

	/**
	 * To move the web element
	 * 
	 * @param we
	 */
	public void moveToElement(WebElement we);

	/**
	 * To double click on the object
	 * 
	 * @param we
	 */
	public void doubleClick(WebElement we);

	/**
	 * To right click on the object
	 * 
	 * @param we
	 */
	public void contextClick(WebElement we);
}
