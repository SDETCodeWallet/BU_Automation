package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Configuration {

	private String fileName;
	static String path = getFilePath();

	public Configuration(String fileName) {
		this.fileName = fileName;
	}

	public String readApplicationData(String key) throws Exception {
		String value = "";
		try {
			Properties prop = new Properties();
			File f = new File(path + "//src//test//resources//testdata//" + fileName + ".properties");
			if (f.exists()) {
				prop.load(new FileInputStream(f));
				value = prop.getProperty(key);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Failed to read from application.properties file.");
			throw new FileNotFoundException("File not found " + fileName);
		}
		return value;
	}

	public static String getFilePath() {
		String filepath = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		filepath = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return filepath;
	}
}