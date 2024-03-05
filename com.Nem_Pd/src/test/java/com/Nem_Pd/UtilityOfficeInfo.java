package com.Nem_Pd;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class UtilityOfficeInfo {
	
	  
	 public WebDriver driver;
	 MasterData info = new MasterData(); 
	 
	

	 
	@BeforeMethod
	public void beforeMethod() {
	BrowserSetup browser = new BrowserSetup();
    driver = browser.getChromeBrowser();
		  
	}	
	
	  
	  
  @SuppressWarnings("resource")
  
@Test(description="Inserting Utility Office Information")
  public void InsertUtilityOfficeInfo( ) throws InterruptedException, IOException {
	  driver.get(info.loginUrl);
	  
	    WebElement userName = driver.findElement(By.name("Username"));  
	    userName.click();
	    userName.clear();
	    userName.sendKeys(info.adminUserName);
	    
	    WebElement password = driver.findElement(By.name("Password"));  
	    password.click();
	    password.clear();
	    password.sendKeys(info.adminPassword);
	    
	    WebElement loginBtn = driver.findElement(By.xpath("//button[@ type='submit']"));  
	    loginBtn.click();
	  
	    Thread.sleep(1000);
	    
	    
	    
	    
	 // Load the Excel file
        FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data\\NEMPD.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        
     // Get the first sheet of the workbook
        Sheet sheet = workbook.getSheetAt(0);
        
        // Iterate through the rows of the sheet
        for (Row row : sheet) {
        	
        	
        	if (row.getCell(0) == null || row.getCell(0).getStringCellValue().isEmpty()) {
                continue; // Skip this row
            }
        	        	
            // Get the data from the cells
            String nameOfUtility = row.getCell(0).getStringCellValue();
            String nameOfUtilityOffice = row.getCell(1).getStringCellValue();
            String codeOfUtilityOffice = row.getCell(2).getStringCellValue(); 
            String emailOfUtilityOffice = row.getCell(3).getStringCellValue();
            String phoneOfUtilityOffice = row.getCell(4).getStringCellValue();
            String addressOfUtilityOffice = row.getCell(5).getStringCellValue();
            String sortOrderAsString = row.getCell(6).getStringCellValue();


            // Add more lines if you have more data to extract from the row

            
            // Find the input elements on the web page and enter the data
            driver.get("http://103.69.149.44/NEM_PD/Setup/UtilityOffice");
    	    
    	    Thread.sleep(1000);      
            WebElement newUtilityOfficeBtn = driver.findElement(By.xpath("//*[@id=\"GridDiv\"]/div[2]/div[2]/div/div/div[1]/div/span"));  
    	    newUtilityOfficeBtn.click();
    	    
    	    @SuppressWarnings("deprecation")
    		WebDriverWait wait = new WebDriverWait(driver, 10);
    	    
    	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s2id_NEM_PD_Setup_UtilityOfficeDialog5_UtilityId"))).click();
    	    
    	    WebElement utilityName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s2id_autogen1_search")));
    	    utilityName.click();
    	    utilityName.sendKeys(nameOfUtility);
    	    Thread.sleep(1000);
    	    utilityName.sendKeys(Keys.ENTER);

                 
    	    WebElement utilityOfficeName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("NEM_PD_Setup_UtilityOfficeDialog5_Name")));
    	    utilityOfficeName.click();
    	    utilityOfficeName.sendKeys(nameOfUtilityOffice);
    	    
    	    
    	    WebElement utilityOfficeCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("NEM_PD_Setup_UtilityOfficeDialog5_Code")));
    	    utilityOfficeCode.click();
    	    utilityOfficeCode.sendKeys(codeOfUtilityOffice);
    	    
    	    
    	    WebElement utilityOfficeEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("NEM_PD_Setup_UtilityOfficeDialog5_Email")));
    	    utilityOfficeEmail.click();
    	    utilityOfficeEmail.sendKeys(emailOfUtilityOffice);
    	    
    	    WebElement utilityOfficePhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("NEM_PD_Setup_UtilityOfficeDialog5_Phone")));
    	    utilityOfficePhone.click();
    	    utilityOfficePhone.sendKeys(phoneOfUtilityOffice);
            
    	    
    	    WebElement utilityOfficeAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("NEM_PD_Setup_UtilityOfficeDialog5_Address")));
    	    utilityOfficeAddress.click();
    	    utilityOfficeAddress.sendKeys(addressOfUtilityOffice);
    	    
    	    WebElement sortOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("NEM_PD_Setup_UtilityOfficeDialog5_SortOrder")));
    	    sortOrder.click();
    	    sortOrder.sendKeys(sortOrderAsString);
    	    
    	    WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"NEM_PD_Setup_UtilityOfficeDialog5_Toolbar\"]/div/div/div/div[1]/div/span"));  
    	    saveBtn.click();
            
        }

	        
	  
	    
	    
  }
  
  


  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
