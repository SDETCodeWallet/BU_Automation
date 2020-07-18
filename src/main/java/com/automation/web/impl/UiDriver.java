package com.automation.web.impl;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.automation.application.pages.HomePage;
import com.automation.constants.GlobalConstants.BrowserType;
import com.automation.exceptions.WebExceptions;
import com.automation.web.interfaces.IWeb;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UiDriver extends ActionUtils implements IWeb {

	public Logger log = Logger.getLogger(UiDriver.class);

	protected static WebDriver driver;

	/**
	 * To configure the browser and launch the web application
	 */
	public void setDriver(BrowserType browserType) {
		switch (browserType) {
		case Chrome:
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("disable-infobars");
			this.driver = new ChromeDriver(options);
			break;
		case Firefox:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("marionette", true);
			this.driver = new FirefoxDriver(firefoxOptions);
			break;
		case IE:
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ieOptions.setCapability("nativeEvents", false);
			this.driver = new InternetExplorerDriver(ieOptions);
			break;
		default:
			try {
				log.error(browserType + " invalid browser type");
				throw new WebDriverException("Please proivide the correct BrowserType");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		log.info("User launch the application on:" + browserType.toString());
		browserMaximize();
		deletAllCookies();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public HomePage launchApplication(final String url) {
		if (!(url.length() == 0 || url == null)) {
			driver.get(url);
			log.info("User launch the apoplication: " + url);
			return new HomePage();
		} else {
			log.error(" Please provide the correct url");
		}
		return new HomePage();
	}

	/**
	 * To quit the browser
	 */
	public void browserQuit() {
		log.info("Browser is closing");
		driver.quit();
	}

	/**
	 * To maximize the browser
	 */
	public void browserMaximize() {
		log.info("User maximize the browser");
		driver.manage().window().maximize();
	}

	/**
	 * To delete the cookies
	 */
	public void deletAllCookies() {
		log.info("Delete all the cookies");
		driver.manage().deleteAllCookies();
	}

	/**
	 * To close all the browser
	 */
	public void browserClose() {
		log.info("Browser is closing");
		driver.close();
	}

	/**
	 * To click on webelement
	 * 
	 * @param we
	 */
	public void click(WebElement we) {
		we.click();
	}

	/**
	 * To enter the input
	 * 
	 * @param we
	 * @param inputText
	 */
	public void sendKeys(WebElement we, String inputText) {
		log.info("User enter " + inputText + " in the input field");
		we.sendKeys(inputText);
	}

	/**
	 * To get the text
	 * 
	 * @param by
	 * @return
	 */
	public String getText(WebElement we) {
		return we.getText();
	}

	@Override
	public boolean isSelected(WebElement we) {
		return we.isSelected();
	}

	@Override
	public boolean isEnabled(WebElement we) {
		return we.isEnabled();

	}

	@Override
	public boolean isDisplayed(WebElement we) {
		return we.isDisplayed();
	}

	@Override
	public void navigateTo(String url) {
		driver.get(url);

	}

	@Override
	public void switchToFrame(int frameNumber) {
		if (driver.findElements(By.xpath("//iframe")).size() >= 1) {
			driver.switchTo().frame(frameNumber);
		} else {
			try {
				throw new WebExceptions("No frame found");
			} catch (WebExceptions e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void switchToFrame(WebElement we) {
		driver.switchTo().frame(we);

	}

	@Override
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);

	}

	public String getPageSource() {
		return driver.getPageSource();
	}

}
