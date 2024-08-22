package com.Nem_Pd;

import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class DotheSum {
  
	MasterData info = new MasterData(); 
	private WebDriver driver;
	
	
	public static String ChromeDriverPath=".\\src\\test\\resources\\drivers\\chromedriver.exe";


	
  @BeforeMethod
  public void beforeMethod() {
	  
		System.setProperty("webdriver.chrome.driver",ChromeDriverPath);
		//driver=new ChromeDriver();

		
		
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Kafi\\Others\\Kafi_Tools\\Chrome\\chrome-win64\\chrome.exe");
		
		// Initialize the ChromeDriver with the specified options
        driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void test() throws InterruptedException {
	  
	  @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
	  
		driver.get(info.liveApplicationUrl);
		
		driver.findElement(By.xpath("//a[@href='/Apply']")).click();  

	 
		WebElement siteDistrictParent = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_SiteDistrictId")));
		Actions actions = new Actions(driver);
		actions.moveToElement(siteDistrictParent).click().perform();
		
		
	  
	// ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000)");

		//Signature and Image attachment.
	 	WebElement signature = driver.findElement(By.name("Serenity_ImageUploadEditor83[]"));


		//Signature.click();
		
		File file = new File("src/test/resources/images/Signature.png");
		signature.sendKeys(file.getAbsolutePath());

  }

}
