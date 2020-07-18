package com.automation.web.impl;

import com.automation.assertions.WebAssertions;

public class UiValidation {

	/**
	 * To validate the page title
	 * 
	 * @param actualTitle
	 * @param expectedMessage
	 */
	public static void validatePageTitle(String actualTitle, String expectedTitle) {
		WebAssertions.validateMessage(actualTitle, expectedTitle);
	}

	/**
	 * To validate the message
	 * 
	 * @param actualMessage
	 * @param expectedMessage
	 */
	public static void validateMessage(String actualMessage, String expectedMessage) {
		WebAssertions.validateMessage(actualMessage, expectedMessage);
	}

	public static void validateText() {
		
	}

	public static void validateIsSelected() {

	}

	public static void validateIsEnabled() {

	}
}
