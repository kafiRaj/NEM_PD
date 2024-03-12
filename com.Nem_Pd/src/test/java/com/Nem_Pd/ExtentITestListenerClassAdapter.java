package com.Nem_Pd;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentITestListenerClassAdapter implements ITestListener{

	private static ExtentReports extent = new ExtentReports();
	private static ExtentTest test;

	protected static WebDriver driver;



	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void setUp(String browser) {

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();              
			driver = new ChromeDriver();

		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();              
			driver = new FirefoxDriver();       
		}
		else {
			throw new IllegalArgumentException("Invalid browser value provided");
		}
	}



	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}




	@Override
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report-" + timeStamp + ".html";
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/testReport/" + reportName);
		extent.attachReporter(htmlReporter);


		htmlReporter.config().setDocumentTitle("Functional Testing Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setReportName("Functional Test Report ofUnified Net Metering Application");


		extent.setSystemInfo("Tester's Name", "Abdullah Al Kafi");
		extent.setSystemInfo("OS", "Windows-10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Date", timeStamp);

	}


	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName() +"has passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());

		// Capture screenshot on test failure
		captureScreenshot(driver, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Do nothing
	}



	//Method for taking screenshot

	void captureScreenshot(WebDriver driver, String methodName) {


		// Cast WebDriver to TakesScreenshot
		TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

		// Capture screenshot as a file
		File screenshot = null;

		// Specify the directory to save the screenshot
		String screenshotDirectory = System.getProperty("user.dir") + "/screenshots/";
		String screenshotFilePath = screenshotDirectory + methodName + ".png";


		try {
			screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);


			// Create the directory if it doesn't exist
			File directory = new File(screenshotDirectory);
			if (!directory.exists()) {
				directory.mkdirs();
			}

			// Save the screenshot with a unique filename
			File screenshotFile = new File(screenshotFilePath);
			Files.copy(screenshot.toPath(), screenshotFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

		} 

		catch (Exception e) {
			// Print the exception stack trace
			e.printStackTrace();
			// Log a message indicating the failure to capture screenshot
			System.out.println("Failed to capture screenshot: " + e.getMessage());
		}

		if (screenshot != null) {
			try {
				// Attach screenshot to the report
				test.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotFilePath).build());
			} catch (Exception e) {
				// Print the exception stack trace
				e.printStackTrace();
				// Log a message indicating the failure to attach screenshot to the report
				System.out.println("Failed to attach screenshot to report: " + e.getMessage());
			}
		}
	}

}
