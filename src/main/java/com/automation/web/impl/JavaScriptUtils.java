package com.automation.web.impl;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

	JavascriptExecutor js = (JavascriptExecutor) UiDriver.driver;

	/**
	 * Click on web object by using javascript
	 * 
	 * @param we
	 */
	public void js_click(WebElement we) {
		js.executeScript("arguments[0].click();", we);
	}

}
