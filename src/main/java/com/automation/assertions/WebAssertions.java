package com.automation.assertions;

import junit.framework.Assert;

public class WebAssertions {

	public static void validateMessage(String actualMessage, String expectedMessage) {
		boolean flag;
		if (actualMessage.equalsIgnoreCase(expectedMessage))
			flag = true;
		else
			flag = false;
		Assert.assertTrue(flag);
	}

}
