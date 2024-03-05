package com.Nem_Pd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup {
	
	WebDriver driver;
	public String ChromeDriverPath=".\\src\\test\\resources\\drivers\\chromedriver.exe";
	
	public static void main(String[] args) {


	}
	
	public WebDriver getChromeBrowser(){


		System.setProperty("webdriver.chrome.driver",ChromeDriverPath);
		driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

}

