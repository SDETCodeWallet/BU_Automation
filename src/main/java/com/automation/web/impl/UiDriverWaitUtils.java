package com.automation.web.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UiDriverWaitUtils {

	public static void threadSleep(long timesOut) {
		try {
			Thread.sleep(timesOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitElementToBeVisible(WebElement we, long waitUntil) {
		WebDriverWait driver = new WebDriverWait(UiDriver.driver, waitUntil);
		driver.until(ExpectedConditions.visibilityOf(we));
	}

}
