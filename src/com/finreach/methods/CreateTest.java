package com.finreach.methods;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTest {
	public static WebDriver CreateTestcase(WebDriver driver, WebDriverWait wait) {
		Random rand = new Random();
		String firstname = "test"+ String.valueOf(rand.nextInt(1000) + 1);
		String lastname = "test"+ String.valueOf(rand.nextInt(1000) + 1);
		String email = "test" + String.valueOf(rand.nextInt(1000) + 1) + "@gmail" + ".com";
		String date = "2018-01-05";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='bAdd']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-model='selectedEmployee.firstName']")));
		driver.findElement(By.xpath("//*[@ng-model='selectedEmployee.firstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@ng-model='selectedEmployee.lastName']")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@ng-model='selectedEmployee.startDate']")).sendKeys(date);
		driver.findElement(By.xpath("//*[@ng-model='selectedEmployee.email']")).sendKeys(email);
		driver.findElement(By.xpath("//button[@type='submit' and @class='main-button']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='bAdd']")));
		System.out.println("User is able to create data sucessfully");
		return driver;
	}
	
	public static WebDriver CreateCancelButtonTestcase(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='bAdd']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-model='selectedEmployee.firstName']")));
		driver.findElement(By.xpath("//*[@id='sub-nav']//a[contains(@class,'subButton bCancel')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='bAdd']")));
		System.out.println("user is returing outside on clicking cancel button");
		return driver;
	}

}
