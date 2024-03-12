package com.Nem_Pd;

import java.io.File;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Listeners(ExtentITestListenerClassAdapter.class)
public class Application extends ExtentITestListenerClassAdapter{

	MasterData info = new MasterData(); 

    
	@Test
	public void submitApplication() throws Exception {

		driver.get(info.baseUrl);

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.findElement(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_UtilityId")).click();    
		WebElement utilityName = driver.findElement(By.id("s2id_autogen1_search")); 
		utilityName.click();
		utilityName.clear();
		utilityName.sendKeys(info.utilityName);
		Thread.sleep(1000);
		utilityName.sendKeys(Keys.ENTER);

		WebElement consumerAccountNumber = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ConsumerAccountNumber11")));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", consumerAccountNumber);
		consumerAccountNumber.click();
		consumerAccountNumber.clear();
		consumerAccountNumber.sendKeys(info.consumerAccountNumber);

		WebElement consumerName = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ConsumerName")));
		// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", consumerName);
		consumerName.click();
		consumerName.clear();
		consumerName.sendKeys(info.consumerName);

		WebElement meterNumber = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_MeterNumber")));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", meterNumber);
		meterNumber.click();
		meterNumber.clear();
		meterNumber.sendKeys(info.meterNumber);

		WebElement tariff = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_Tariff")));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tariff);
		tariff.click();
		tariff.clear();
		tariff.sendKeys(info.tariff);

		WebElement contractedLoad = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ContractedLoadKw")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contractedLoad);
		contractedLoad.click();
		contractedLoad.clear();
		contractedLoad.sendKeys(info.contractedLoad);

		WebElement voltageLevel = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_VoltageLevel")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", voltageLevel);
		voltageLevel.click();
		voltageLevel.clear();
		voltageLevel.sendKeys(info.voltageLevel);

		WebElement applicantMobile = wait.until(ExpectedConditions.elementToBeClickable(By.name("ApplicantMobile")));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applicantMobile);
		applicantMobile.click();
		applicantMobile.clear();
		applicantMobile.sendKeys(info.applicantMobile);    

		WebElement applicantEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantEmail")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applicantEmail);
		applicantEmail.click();
		applicantEmail.clear();
		applicantEmail.sendKeys(info.applicantEmail);


		WebElement applicantNationalId = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantNid")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applicantNationalId);
		applicantNationalId.click();
		applicantNationalId.clear();
		applicantNationalId.sendKeys(info.applicantNationalId);


		driver.findElement(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantDistrictId")).click();
		WebElement districtName = driver.findElement(By.id("s2id_autogen4_search")); 
		districtName.click();
		districtName.clear();
		districtName.sendKeys(info.districtName);
		Thread.sleep(1000);
		districtName.sendKeys(Keys.ENTER);

		WebElement postCode = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantPostCode")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", postCode);
		postCode.click();
		postCode.clear();
		postCode.sendKeys(info.postCode);

		WebElement applicantAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantAddress")));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applicantAddress);
		applicantAddress.click();
		applicantAddress.clear();
		applicantAddress.sendKeys(info.applicantAddress);

		WebElement alternatePersonName = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonName")));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alternatePersonName);
		alternatePersonName.click();
		alternatePersonName.clear();
		alternatePersonName.sendKeys(info.alternatePersonName);

		WebElement alternatePersonRelationship = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonRelationship")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alternatePersonRelationship);
		alternatePersonRelationship.click();
		alternatePersonRelationship.clear();
		alternatePersonRelationship.sendKeys(info.alternatePersonRelationship);

		WebElement alternatePersonNid = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonNid")));
		// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alternatePersonNid);    
		alternatePersonNid.click();
		alternatePersonNid.clear();
		alternatePersonNid.sendKeys(info.alternatePersonNid);

		WebElement alternatePersonContactNumber = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonContactNumber")));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alternatePersonContactNumber);
		alternatePersonContactNumber.click();
		alternatePersonContactNumber.clear();
		alternatePersonContactNumber.sendKeys(info.alternatePersonContactNumber);

		WebElement alternatePersonEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonEmail")));
		// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alternatePersonEmail);  
		alternatePersonEmail.click();
		alternatePersonEmail.clear();
		alternatePersonEmail.sendKeys(info.alternatePersonEmail);

		WebElement alternatePersonAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonAddress")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alternatePersonAddress);  
		alternatePersonAddress.click();
		alternatePersonAddress.clear();
		alternatePersonAddress.sendKeys(info.alternatePersonAddress);


		WebElement siteAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_SiteAddress")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", siteAddress);
		siteAddress.click();
		siteAddress.clear();
		siteAddress.sendKeys(info.siteAddress);

		driver.findElement(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_SiteDistrictId")).click();
		WebElement siteDistrictName = driver.findElement(By.id("s2id_autogen8_search")); 
		siteDistrictName.click();
		siteDistrictName.clear();
		siteDistrictName.sendKeys(info.siteDistrictName);
		Thread.sleep(1000);
		siteDistrictName.sendKeys(Keys.ENTER);

		WebElement sitePostalCode = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_SitePostCode")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sitePostalCode);
		sitePostalCode.click();
		sitePostalCode.clear();
		sitePostalCode.sendKeys(info.sitePostalCode);

		driver.findElement(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_SiteOwnership")).click();
		WebElement siteOwnership = driver.findElement(By.id("s2id_autogen9_search")); 
		siteOwnership.click();
		siteOwnership.clear();
		siteOwnership.sendKeys(info.siteOwnership);
		Thread.sleep(1000);
		siteOwnership.sendKeys(Keys.ENTER);

		WebElement ProposedReCapacityKw = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ProposedReSystemCapacityKw")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ProposedReCapacityKw);
		ProposedReCapacityKw.click();
		ProposedReCapacityKw.clear();
		ProposedReCapacityKw.sendKeys(info.ProposedReCapacityKw);

		WebElement connectionPointVoltageLevelParent = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_ConnectionPointVoltageLevel")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", connectionPointVoltageLevelParent);
		connectionPointVoltageLevelParent.click();
		WebElement connectionPointVoltageLevel = driver.findElement(By.id("s2id_autogen10_search")); 
		connectionPointVoltageLevel.click();
		connectionPointVoltageLevel.clear();
		connectionPointVoltageLevel.sendKeys(info.connectionPointVoltageLevel);
		Thread.sleep(1000);
		connectionPointVoltageLevel.sendKeys(Keys.ENTER); 

		WebElement projectStatusParent = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_ProjectStatus")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", projectStatusParent);
		projectStatusParent.click();
		WebElement projectStatus = driver.findElement(By.id("s2id_autogen12_search")); 
		projectStatus.click();
		projectStatus.clear();
		projectStatus.sendKeys(info.projectStatus);
		Thread.sleep(1000);
		projectStatus.sendKeys(Keys.ENTER);

		WebElement buildingType = driver.findElement(By.id("s2id_autogen13")); 
		wait.until(ExpectedConditions.visibilityOf(buildingType));
		buildingType.click();
		buildingType.clear();
		buildingType.sendKeys(info.buildingType);
		Thread.sleep(1000);
		buildingType.sendKeys(Keys.ENTER);


		WebElement installationTypeParent = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_InstallationType")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", installationTypeParent);
		installationTypeParent.click();
		WebElement installationType = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_autogen14_search")));
		installationType.click();
		installationType.clear();
		installationType.sendKeys(info.installationType);
		Thread.sleep(1000);
		installationType.sendKeys(Keys.ENTER);

		driver.findElement(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_StorageBatteryUsed")).click();
		WebElement storageBatteryUsed = driver.findElement(By.id("s2id_autogen15_search")); 
		storageBatteryUsed.click();
		storageBatteryUsed.clear();
		storageBatteryUsed.sendKeys(info.storageBatteryUsed);
		Thread.sleep(1000);
		storageBatteryUsed.sendKeys(Keys.ENTER);

		/*try {

   	 	WebElement declarationTick = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_TnCAgreed")));
   	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", declarationTick);
   	    declarationTick.click();

   	} catch(Exception e){

   	  System.out.println("An error occurred: " + e.getMessage());
      e.printStackTrace();
   	}
		 */

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000)");

		//Signature and Image attachment.
		WebElement Signature = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Serenity_ImageUploadEditor81[]")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Signature);

		File file = new File("src/test/resources/images/Signature.png");
		Signature.sendKeys(file.getAbsolutePath());


	}

	

}
