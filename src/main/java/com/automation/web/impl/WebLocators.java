package com.automation.web.impl;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.automation.constants.GlobalConstants;
import com.automation.constants.GlobalConstants.LocatorType;
import com.automation.excel.utils.ExcelOperations;
import com.automation.exceptions.WebExceptions;
import com.automation.utils.PropertiesFileUtils;

public class WebLocators {

	protected static String fileName = "";

	public static WebElement getElement(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType) {
		case "CSS":
			locator = By.cssSelector(locatorValue);
			break;
		case "ID":
			locator = By.id(locatorValue);
			break;
		case "LINKTEXT":
			locator = By.partialLinkText(locatorValue);
			break;
		case "NAME":
			locator = By.name(locatorValue);
			break;
		case "PARTIALLINKTEXT":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TAGNAME":
			locator = By.tagName(locatorValue);
			break;
		case "XPATH":
			locator = By.xpath(locatorValue);
			break;

		}

		WebElement we = null;
		if (UiDriver.driver.findElements(locator).size() == 0) {
			try {
				UiDriverWaitUtils.threadSleep(3000);
				throw new WebExceptions(locatorValue + " Locator Not found");
			} catch (WebExceptions e) {
				e.printStackTrace();
			}
		} else {
			we = UiDriver.driver.findElement(locator);
		}
		return we;

	}

	public static WebElement getElement(LocatorType locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType) {
		case CSS:
			locator = By.cssSelector(locatorValue);
			break;
		case ID:
			locator = By.id(locatorValue);
			break;
		case LINKTEXT:
			locator = By.partialLinkText(locatorValue);
			break;
		case NAME:
			locator = By.name(locatorValue);
			break;
		case PARTIALLINKTEXT:
			locator = By.partialLinkText(locatorValue);
			break;
		case TAGNAME:
			locator = By.tagName(locatorValue);
			break;
		case XPATH:
			locator = By.xpath(locatorValue);
			break;
		}
		WebElement we = null;
		if (UiDriver.driver.findElements(locator).size() == 0) {
			try {
				UiDriverWaitUtils.threadSleep(3000);
				throw new WebExceptions(locatorValue + " Locator Not found");
			} catch (WebExceptions e) {
				e.printStackTrace();
			}
		} else {
			we = UiDriver.driver.findElement(locator);
		}
		return we;
	}

	private static WebElement checkTypeAndGetWebElement(String element) {
		String[] locType = element.split(":");
		return getElement(locType[0].toUpperCase(), locType[1]);
	}

	public static WebElement getPropLocator(String propertiesFileName, String locatorKey) {
		return checkTypeAndGetWebElement(PropertiesFileUtils
				.readConfigFile(GlobalConstants.WebConstants.propertiesWebLocators + propertiesFileName, locatorKey));
	}

	public static void main(String[] args) {
		getPropLocator("", "");
	}

	public static WebElement getXMLLocator(String fileName, String locatorName) {
		File file = new File(GlobalConstants.WebConstants.xmlWebLocators + fileName + ".xml");
		DocumentBuilderFactory Df = DocumentBuilderFactory.newInstance();
		DocumentBuilder Db = null;
		try {
			Db = Df.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document document = null;
		try {
			document = Db.parse(file);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		NodeList list = document.getElementsByTagName("Locators");
		Node node1 = list.item(0);
		Element ele = (Element) node1;
		return checkTypeAndGetWebElement(ele.getElementsByTagName(locatorName).item(0).getTextContent());
	}

	public static WebElement getExcelLocators(String fileName, String sheetName, String locatorName) {
		return checkTypeAndGetWebElement(ExcelOperations.readExcelLocators(fileName, sheetName, locatorName));
	}
}
