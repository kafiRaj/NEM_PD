package com.Nem_Pd;

import java.io.File;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CleanApplication extends ExtentITestListenerClassAdapter {

    MasterData info = new MasterData();

    @Test
    public void submitApplication() throws Exception {
        driver.get(info.liveApplicationUrl);
        Actions actions = new Actions(driver);
        @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);

        // Navigate to the application form
        driver.findElement(By.xpath("//a[@href='/Apply']")).click();


        selectOptionBySearch("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_UtilityId", "s2id_autogen1_search", info.utilityName);
        
	

		WebElement consumerAccountNumber = wait.until(ExpectedConditions.elementToBeClickable(By.name("ConsumerAccountNumber")));
		consumerAccountNumber.click();
		consumerAccountNumber.clear();
		consumerAccountNumber.sendKeys(info.consumerAccountNumber);
		consumerAccountNumber.sendKeys(Keys.ENTER);

		Boolean validationPassed = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("select2-chosen-3"), "Executive Engineer, NOCS, Ramna"));

		// Proceed to enter the ApplicantMobile only if validation is successful
			
		if (validationPassed) {
			enterText(wait, By.name("ApplicantMobile"), info.applicantMobile);
		    }
            enterText(wait, By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantEmail"), info.applicantEmail);
            selectOptionBySearch("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantNationality", "s2id_autogen6_search", "Bangladeshi");
            enterText(wait, By.name("ApplicantNid"), info.applicantNationalId);
            selectOptionBySearch("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantDistrictId", "s2id_autogen7_search", info.districtName);
            enterText(wait, By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantPostCode"), info.postCode);
            enterText(wait, By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ApplicantAddress"), info.applicantAddress);

            // Enter Alternate Contact Person Details
            enterText(wait, By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonName"), info.alternatePersonName);
            enterText(wait, By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonRelationship"), info.alternatePersonRelationship);
            selectOptionBySearch("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonNationality", "s2id_autogen8_search", "Bangladeshi");
            enterText(wait, By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonNid"), info.alternatePersonNid);
            enterText(wait, By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonContactNumber"), info.alternatePersonContactNumber);
            enterText(wait, By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonEmail"), info.alternatePersonEmail);
            enterText(wait, By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_AltContactPersonAddress"), info.alternatePersonAddress);

            // Enter Site Details
            selectOptionBySearch("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_SiteDistrictId", "s2id_autogen11_search", info.siteDistrictName);
            enterText(wait, By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_SitePostCode"), info.sitePostalCode);
            selectOptionBySearch("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_SiteOwnership", "s2id_autogen12_search", info.siteOwnership);

            // Enter System Details
            enterText(wait, By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_ProposedReSystemCapacityKw"), info.ProposedReCapacityKw);
            selectOptionBySearch("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_ConnectionPointVoltageLevel", "s2id_autogen13_search", info.connectionPointVoltageLevel);
            selectOptionBySearch("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_ProjectStatus", "s2id_autogen15_search", info.projectStatus);
            selectOptionBySearch("s2id_autogen16", null, info.buildingType);
            selectOptionBySearch("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_InstallationType", "s2id_autogen17_search", info.installationType);
            selectOptionBySearch("s2id_NEM_PD_NetMetering_NemApplicationPublicDialog0_StorageBatteryUsed", "s2id_autogen18_search", info.storageBatteryUsed);

            // Agree to Terms and Conditions
            actions.moveToElement(driver.findElement(By.id("NEM_PD_NetMetering_NemApplicationPublicDialog0_TnCAgreed"))).click().perform();

            // Upload Signature
            WebElement signature = driver.findElement(By.name("Serenity_ImageUploadEditor83[]"));
            signature.sendKeys(new File("src/test/resources/images/Signature.png").getAbsolutePath());

            // Handle Captcha (Assume manual entry or further automation here)
            WebElement captchaEntry = driver.findElement(By.xpath("//div[@id='NEM_PD_NetMetering_NemApplicationPublicDialog0_Captcha']/div/input"));
            actions.moveToElement(captchaEntry).click().perform();
        }
    

    private void enterText(WebDriverWait wait, By locator, String text) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        element.clear();
        element.sendKeys(text);
        Thread.sleep(500);
    }

    private void selectOptionBySearch(String parentLocatorId, String searchBoxId, String optionText) throws InterruptedException {
        WebElement parentElement = driver.findElement(By.id(parentLocatorId));
        Actions actions = new Actions(driver);
        actions.moveToElement(parentElement).click().perform();

        if (searchBoxId != null) {
            WebElement searchBox = driver.findElement(By.id(searchBoxId));
            searchBox.click();
            searchBox.clear();
            searchBox.sendKeys(optionText);
            Thread.sleep(1000);
            searchBox.sendKeys(Keys.ENTER);
        } else {
            parentElement.sendKeys(optionText);
            Thread.sleep(1000);
            parentElement.sendKeys(Keys.ENTER);
        }
    }
}
