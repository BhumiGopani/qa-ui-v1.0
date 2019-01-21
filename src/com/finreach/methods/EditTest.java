package com.finreach.methods;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditTest {
	public static WebDriver EditTestcase(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='bAdd']")));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='employee-list']/li[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='bEdit']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sub-nav']/li/a")));
		Random rand = new Random();
		String firstname = "test"+ String.valueOf(rand.nextInt(1000) + 1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-model='selectedEmployee.firstName']")));
		driver.findElement(By.xpath("//*[@ng-model='selectedEmployee.firstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//button[@type='submit' and contains(@class,'main-button')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='bAdd']")));
		System.out.println("User is able to edit data");
		return driver;
	}
}
