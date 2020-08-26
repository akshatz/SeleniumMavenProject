package com.test;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookTestCases {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
		    			   "/home/akshatz/Documents/SeleniumMavenProject/src/main/java/com/factory/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, MILLISECONDS);
	  }
  
	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }
	  @Test
	  public void openFacebookURL() {
		  driver.get("https://www.facebook.com/");
		  Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
	  }
	  @Test(dependsOnMethods = "openFacebookURL", enabled = false)
	  public void changeLanguage() {
		  driver.findElement(By.linkText("English (UK)")).click();
		  Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");
	  }
}
