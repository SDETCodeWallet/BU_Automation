package com.automation.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileUtil {

	@SuppressWarnings("unchecked")
	public static void modifyJsonValue(String jsonFile, String jsonPathToBeModify, String newValue) {
		JSONParser parser = new JSONParser();
		FileWriter writer = null;
		FileReader reader = null;
		Object object = null;
		try {
			reader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
		}
		try {
			try {
				object = parser.parse(reader);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
		}
		try {
			reader.close();
		} catch (IOException e) {
		}
		JSONObject jsonObject = (JSONObject) object;
		jsonObject.replace(jsonPathToBeModify, newValue);
		try {
			writer = new FileWriter(jsonFile);
		} catch (IOException e) {
		}
		try {
			writer.write(jsonObject.toString());
		} catch (IOException e) {
		}
		try {
			writer.flush();
		} catch (IOException e) {
		}
	}

	public static JSONObject readJsonData(final String fileName) {
		if (fileName.isEmpty() || fileName == null) {
			try {
				throw new Exception("Please provide valid file name");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		final JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		Object obj = null;
		try {
			obj = parser.parse((Reader) new FileReader(
					System.getProperty("user.dir") + "/src//test//resources//testdata//" + fileName + ".json"));
			jsonObject = (JSONObject) obj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ParseException e3) {
			e3.printStackTrace();
		}
		return jsonObject;
	}
}