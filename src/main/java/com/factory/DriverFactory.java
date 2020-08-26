package com.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public static WebDriver getDriver(String browser) {
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		}
		
		return driver;
	}
	
}
