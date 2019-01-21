package com.finreach.methods;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogInTest {
	public static WebDriver logInTestcase(WebDriver driver, WebDriverWait wait, String existingUser,
			String existingUserPassword) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login-form']//input[contains(@class,'ng-pristine ng-invalid ng-invalid-required')]")));
		driver.findElement(By.xpath("//*[@id='login-form']//input[contains(@class,'ng-pristine ng-invalid ng-invalid-required')]")).sendKeys(existingUser);	
		driver.findElement(By.xpath("//*[@id='login-form']//label[2]/input[contains(@type,'password')]")).sendKeys(existingUserPassword);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='greetings']")));
		assertEquals("Hello Luke", heading.getText());
		System.out.println("Login successfull with correct creds");
		return driver;
	}
	public static WebDriver nologInTestcase(WebDriver driver, WebDriverWait wait) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login-form']//input[contains(@class,'ng-pristine ng-invalid ng-invalid-required')]")));
			driver.findElement(By.xpath("//*[@id='login-form']//input[contains(@class,'ng-pristine ng-invalid ng-invalid-required')]")).sendKeys("Bhumi");	
			driver.findElement(By.xpath("//*[@id='login-form']//label[2]/input[contains(@type,'password')]")).sendKeys("abcd@1234");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login-form']/fieldset/p[1]")));
			assertEquals("Invalid username or password!", message.getText());
			System.out.println("Login unsuccessfull with incorrect creds");
			return driver;
	}

}
