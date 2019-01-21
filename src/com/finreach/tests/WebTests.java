package com.finreach.tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.finreach.browserfactory.BrowserFactory;
import com.finreach.methods.CreateTest;
import com.finreach.methods.EditTest;
import com.finreach.methods.LogInTest;
import com.finreach.utils.ProcessPropertiesFile;

@Listeners(WebTestTimeReport.class)
// @Listeners(value=WebTestReporter.class)
public class WebTests {

	WebDriver driver;
	WebDriverWait wait;
	String existingUser = "Luke";
	String existingUserPassword = "Skywalker";
	Logger log = Logger.getLogger("devpinoyLogger");
	ProcessPropertiesFile processPropertiesFile;

	@BeforeMethod
	public void setUp() {
		driver = BrowserFactory.getBrowser(ProcessPropertiesFile.getConfigdetails("driver"));
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 50, 60);
		driver.get(ProcessPropertiesFile.getConfigdetails("url"));
	}

	// First Test Case - positive login with all the creds
	@Test(priority = 0, description = "positive login scenario with valid the creds")
	public void loginInTest() {
		log.info("Test Case 1 started");
		driver = LogInTest.logInTestcase(driver, wait, existingUser, existingUserPassword);
	}

	@Test(priority = 1, description = "negative login scenario with invalid the creds")
	public void nologinInTest() {
		log.info("Test Case 2 started");
		driver = LogInTest.nologInTestcase(driver, wait);
	}

	@Test(priority = 2, description = "create employee data scenario")
	public void createTest() {
		log.info("Test Case 3 started");
		driver = LogInTest.logInTestcase(driver, wait, existingUser, existingUserPassword);
		driver = CreateTest.CreateTestcase(driver, wait);
	}

	@Test(priority = 3, description = "After create - cancel button scenario")
	public void createandcancelTest() {
		log.info("Test Case 4 started");
		driver = LogInTest.logInTestcase(driver, wait, existingUser, existingUserPassword);
		driver = CreateTest.CreateTestcase(driver, wait);
	}

	@Test(priority = 4, description = "edit employee data scenario")
	public void editTest() {
		log.info("Test Case 5 started");
		driver = LogInTest.logInTestcase(driver, wait, existingUser, existingUserPassword);
		driver = EditTest.EditTestcase(driver, wait);
	}

	@AfterMethod
	public void closeDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File(ProcessPropertiesFile.getConfigdetails("screenshotPath")
						+ result.getName() + System.currentTimeMillis() + ".png"));
				log.equals("Test case execution has been Failed. Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
				log.fatal("Exception in taking screenshot.");
			}
		}
		driver.close();
		log.info("Closing the test");
	}

}
