package com.automation.web.interfaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.application.pages.HomePage;
import com.automation.constants.GlobalConstants.BrowserType;

public interface IWeb extends IWebDropDownOperations, IWebActions {

	public void setDriver(BrowserType type);

	public WebDriver getDriver();

	public HomePage launchApplication(String URL);

	public void browserQuit();

	public void browserMaximize();

	public void browserClose();

	public void deletAllCookies();

	public boolean isSelected(WebElement we);

	public boolean isEnabled(WebElement we);

	public boolean isDisplayed(WebElement we);

	public void sendKeys(WebElement we, String inputText);

	public void click(WebElement we);

	public void navigateTo(String url);

	public void switchToFrame(String frameName);

	public void switchToFrame(int frameNumber);

	public void switchToFrame(WebElement we);

	public String getText(WebElement we);
}
