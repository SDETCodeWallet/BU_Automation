package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {

	public static String readConfigFile(String fileName, String key) {
		String value = "";
		Properties prop = new Properties();
		File f = new File(fileName + ".properties");
		if (f.exists()) {
			try {
				prop.load(new FileInputStream(f));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			value = prop.getProperty(key);
		} else {
			try {
				throw new Exception("File not found");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (value == null)
			try {
				throw new Exception("Key not found in properties file");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return value;
	}

}
