package com.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestcasesForLogin {
	WebDriver driver = null;

	
	@Test
	public void checkTitle() {
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/JBK/Selenium-222/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");

		String title = driver.getTitle();
		Assert.assertEquals(title, "JavaByKiran | Log in");
	}

	@Test(dependsOnMethods = "checkTitle")
	public void CheckValidCredentials() {
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/JBK/Selenium-222/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();

		WebElement dBoard = driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1"));
		String dBoard_name = dBoard.getText();
		System.out.println(dBoard_name);
		driver.close();
		Assert.assertEquals(dBoard_name, "Dashboard Courses Offered");
	}

	@Test
	public void Check_RegisterNewLink() {

		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();

		String newRegistration = driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();

		driver.close();
		Assert.assertEquals(newRegistration, "Register a new membership");
		
	}

	
		
	
}
