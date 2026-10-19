package base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ExtentReportManager;
import utils.log;

public class BaseTest {

	protected WebDriver driver;
	protected static ExtentReports extent ;
	protected ExtentTest test;
	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
		
	}
	
	@AfterSuite
	public void teardownReport() {
		extent.flush();
	}
	
	
	

	@BeforeMethod
	public void setUp() {
		
		log.info("Starting WebDriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Navigation to demowebsite");
		driver.get("https://practicetestautomation.com/practice-test-login/");

	}

	@AfterMethod
	public void tearDown(ITestResult result ) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotpath = ExtentReportManager.captureScreenshot(driver, "LoginFailuere");
			test.fail("Test failed..ckeck Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		}
		if (driver != null) {
			log.info("closing Browser");
			 driver.quit();

		}
	}
}
