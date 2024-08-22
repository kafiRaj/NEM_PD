package com.Nem_Pd;

import java.io.File;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//@Listeners(ExtentITestListenerClassAdapter.class)
public class Application extends ExtentITestListenerClassAdapter{

	MasterData info = new MasterData(); 


	@Test
	public void submitApplication() throws Exception {



		driver.get(info.liveApplicationUrl);
		Actions actions = new Actions(driver);


		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);



		driver.findElement(By.xpath("//a[@href='/Apply']")).click();  




		driver.findElement(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_UtilityId")).click();    
		WebElement utilityName = driver.findElement(By.id("s2id_autogen1_search")); 
		utilityName.click();
		utilityName.clear();
		utilityName.sendKeys(info.utilityName);
		Thread.sleep(1000);
		utilityName.sendKeys(Keys.ENTER);

		WebElement consumerAccountNumber = wait.until(ExpectedConditions.elementToBeClickable(By.name("ConsumerAccountNumber")));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", consumerAccountNumber);
		consumerAccountNumber.click();
		consumerAccountNumber.clear();
		consumerAccountNumber.sendKeys(info.consumerAccountNumber);
		consumerAccountNumber.sendKeys(Keys.ENTER);

		Boolean validationPassed = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("select2-chosen-3"), "Executive Engineer, NOCS, Ramna"));

		// Proceed to enter the ApplicantMobile only if validation is successful
			
		if (validationPassed) {
		    WebElement applicantMobile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ApplicantMobile")));
		    actions.moveToElement(applicantMobile).click().perform();
		    applicantMobile.clear();
		    Thread.sleep(1000);
		    applicantMobile.sendKeys(info.applicantMobile);
		}

		WebElement applicantEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantEmail")));
		actions.moveToElement(applicantEmail).click().perform();
		applicantEmail.clear();
		applicantEmail.sendKeys(info.applicantEmail);


		WebElement applicantNationalityParent = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantNationality"))); 
		actions.moveToElement(applicantNationalityParent).click().perform();


		WebElement applicantNationality = driver.findElement(By.id("s2id_autogen6_search")); 
		actions.moveToElement(applicantNationality).click().perform();		
		applicantNationality.clear();
		applicantNationality.sendKeys("Bangladeshi");
		Thread.sleep(1000);
		applicantNationality.sendKeys(Keys.ENTER);

		WebElement applicantNationalId = wait.until(ExpectedConditions.elementToBeClickable(By.name("ApplicantNid")));
		actions.moveToElement(applicantNationalId).click().perform();	

		applicantNationalId.clear();
		applicantNationalId.sendKeys(info.applicantNationalId);


		WebElement districtParent = driver.findElement(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantDistrictId"));
		actions.moveToElement(districtParent).click().perform();	

		WebElement districtName = driver.findElement(By.id("s2id_autogen7_search")); 
		districtName.click();
		districtName.clear();
		districtName.sendKeys(info.districtName);
		Thread.sleep(1000);
		districtName.sendKeys(Keys.ENTER);

		WebElement postCode = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantPostCode")));
		actions.moveToElement(postCode).click().perform();
		postCode.clear();
		postCode.sendKeys(info.postCode);

		WebElement applicantAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantAddress")));
		actions.moveToElement(applicantAddress).click().perform();
		applicantAddress.clear();
		applicantAddress.sendKeys(info.applicantAddress);


		WebElement alternatePersonName = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonName")));
		actions.moveToElement(alternatePersonName).click().perform();
		alternatePersonName.clear();
		alternatePersonName.sendKeys(info.alternatePersonName);

		WebElement alternatePersonRelationship = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonRelationship")));
		actions.moveToElement(alternatePersonRelationship).click().perform();
		alternatePersonRelationship.clear();
		alternatePersonRelationship.sendKeys(info.alternatePersonRelationship);


		WebElement alternateNationalityParent = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonNationality"))); 
		actions.moveToElement(alternateNationalityParent).click().perform();

		WebElement alternateNationality = driver.findElement(By.id("s2id_autogen8_search")); 
		alternateNationality.click();
		alternateNationality.clear();
		alternateNationality.sendKeys("Bangladeshi");
		Thread.sleep(1000);
		alternateNationality.sendKeys(Keys.ENTER);

		WebElement alternatePersonNid = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonNid")));
		actions.moveToElement(alternatePersonNid).click().perform();
		alternatePersonNid.clear();
		alternatePersonNid.sendKeys(info.alternatePersonNid);

		WebElement alternatePersonContactNumber = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonContactNumber")));
		actions.moveToElement(alternatePersonContactNumber).click().perform();
		alternatePersonContactNumber.clear();
		alternatePersonContactNumber.sendKeys(info.alternatePersonContactNumber);

		WebElement alternatePersonEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonEmail")));
		actions.moveToElement(alternatePersonEmail).click().perform();
		alternatePersonEmail.clear();
		alternatePersonEmail.sendKeys(info.alternatePersonEmail);


		WebElement alternatePersonAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonAddress")));
		actions.moveToElement(alternatePersonAddress).click().perform();
		alternatePersonAddress.clear();
		alternatePersonAddress.sendKeys(info.alternatePersonAddress);



		WebElement siteDistrictParent = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_SiteDistrictId")));
		actions.moveToElement(siteDistrictParent).click().perform();


		WebElement siteDistrictName = driver.findElement(By.id("s2id_autogen11_search")); 
		siteDistrictName.click();
		siteDistrictName.clear();
		siteDistrictName.sendKeys(info.siteDistrictName);
		Thread.sleep(1000);
		siteDistrictName.sendKeys(Keys.ENTER);

		WebElement sitePostalCode = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_SitePostCode")));
		actions.moveToElement(sitePostalCode).click().perform();
		sitePostalCode.clear();
		sitePostalCode.sendKeys(info.sitePostalCode);

		WebElement siteOwnershipParent = driver.findElement(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_SiteOwnership"));
		actions.moveToElement(siteOwnershipParent).click().perform();
		WebElement siteOwnership = driver.findElement(By.id("s2id_autogen12_search")); 
		siteOwnership.click();
		siteOwnership.clear();
		siteOwnership.sendKeys(info.siteOwnership);
		Thread.sleep(1000);
		siteOwnership.sendKeys(Keys.ENTER);

		WebElement ProposedReCapacityKw = wait.until(ExpectedConditions.elementToBeClickable(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ProposedReSystemCapacityKw")));
		actions.moveToElement(ProposedReCapacityKw).click().perform();
		ProposedReCapacityKw.clear();
		ProposedReCapacityKw.sendKeys(info.ProposedReCapacityKw);


		WebElement connectionPointVoltageLevelParent = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_ConnectionPointVoltageLevel")));
		actions.moveToElement(connectionPointVoltageLevelParent).click().perform();

		WebElement connectionPointVoltageLevel = driver.findElement(By.id("s2id_autogen13_search")); 
		connectionPointVoltageLevel.click();
		connectionPointVoltageLevel.clear();
		connectionPointVoltageLevel.sendKeys(info.connectionPointVoltageLevel);
		Thread.sleep(1000);
		connectionPointVoltageLevel.sendKeys(Keys.ENTER); 

		WebElement projectStatusParent = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_ProjectStatus")));
		actions.moveToElement(projectStatusParent).click().perform();
		WebElement projectStatus = driver.findElement(By.id("s2id_autogen15_search")); 
		projectStatus.click();
		projectStatus.clear();
		projectStatus.sendKeys(info.projectStatus);
		Thread.sleep(1000);
		projectStatus.sendKeys(Keys.ENTER);

		WebElement buildingType = driver.findElement(By.id("s2id_autogen16")); 
		wait.until(ExpectedConditions.visibilityOf(buildingType));
		buildingType.click();
		buildingType.clear();
		buildingType.sendKeys(info.buildingType);
		Thread.sleep(1000);
		buildingType.sendKeys(Keys.ENTER);


		WebElement installationTypeParent = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_InstallationType")));
		actions.moveToElement(installationTypeParent).click().perform();
		WebElement installationType = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_autogen17_search")));
		installationType.click();
		installationType.clear();
		installationType.sendKeys(info.installationType);
		Thread.sleep(1000);
		installationType.sendKeys(Keys.ENTER);

		WebElement storageBatteryParent = driver.findElement(By.id("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_StorageBatteryUsed"));
		actions.moveToElement(storageBatteryParent).click().perform();
		WebElement storageBatteryUsed = wait.until(ExpectedConditions.elementToBeClickable(By.id("s2id_autogen18_search")));
		storageBatteryUsed.clear();
		storageBatteryUsed.sendKeys(info.storageBatteryUsed);
		Thread.sleep(1000);
		storageBatteryUsed.sendKeys(Keys.ENTER);

		
		WebElement tickMark = driver.findElement(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_TnCAgreed"));
		actions.moveToElement(tickMark).click().perform();
		

		//Signature and Image attachment.
	 	WebElement signature = driver.findElement(By.name("Serenity_ImageUploadEditor83[]"));


		File file = new File("src/test/resources/images/Signature.png");
		signature.sendKeys(file.getAbsolutePath());
		
				
		WebElement captchaEntry = driver.findElement(By.xpath("//div[@id='NEM_PD_NetMetering_NemApplicationPublicDialog0_Captcha']/div/input"));
		actions.moveToElement(captchaEntry).click().perform();

	}



}
