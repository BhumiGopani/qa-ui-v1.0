package com.finreach.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProcessPropertiesFile {

	  public static String getConfigdetails (String datafor) {

		Properties prop = new Properties();
		InputStream input = null;
		String result = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			if(datafor.equalsIgnoreCase("driver"))
				result =  prop.getProperty("driver");
			else if(datafor.equalsIgnoreCase("url"))
				result =  prop.getProperty("url");
			else if(datafor.equalsIgnoreCase("screenshotPath"))
				result =  prop.getProperty("screenshotPath");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;

	  }	
}
