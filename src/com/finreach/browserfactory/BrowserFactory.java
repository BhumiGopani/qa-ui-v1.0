package com.finreach.browserfactory;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;

		switch (browserName) {
		case "Firefox":
				driver = new FirefoxDriver();
			break;
		case "Chrome":
				driver = new ChromeDriver();
			break;
		}
		return driver;
	}

}
