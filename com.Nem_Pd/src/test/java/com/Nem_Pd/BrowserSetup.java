package com.Nem_Pd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup {
	
	private static WebDriver driver;
	public static String ChromeDriverPath=".\\src\\test\\resources\\drivers\\chromedriver.exe";
	
	   // Private constructor to prevent instantiation
    private BrowserSetup() {}
	
	
	public static WebDriver getChromeBrowser(){


		System.setProperty("webdriver.chrome.driver",ChromeDriverPath);
		driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

}

