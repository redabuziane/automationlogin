package test;

import org.testng.Assert;
import org.testng.annotations.Test;



import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.log;

public class LoginTest  extends BaseTest{
	
	
	@Test  
	
	public void testValidLogin () {
		log.info("Starting login test ");
		test = ExtentReportManager.createTest("LoginTest");
		test.info("navigation to url");
		LoginPage loginPage = new LoginPage (driver);
		
		log.info("Adding credentials");
		test.info("Adding credentials");
		loginPage.enterUsername("student");
		loginPage.enterPassword("Password123");
		test.info("Cliking on login button");
		
		loginPage.clickLogin();
		
		
		System.out.println("title of the page is : " + driver.getTitle());
		log.info("Verfying page title");
		test.info("Verfyig page title");
		Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
		test.pass("Login Successful");
		
	}
@Test

	public void testLoginwithInvalidCredentials () {
		log.info("Starting login test ");
		test = ExtentReportManager.createTest("Login Test with Invalid Credentials ");
		test.info("navigation to url");
		LoginPage loginPage = new LoginPage (driver);
		
		log.info("Adding credentials");
		test.info("Adding credentials");
		loginPage.enterUsername("student123");
		loginPage.enterPassword("Password1234");
		test.info("Cliking on login button");
		
		loginPage.clickLogin();
		
		
		System.out.println("title of the page is : " + driver.getTitle());
		log.info("Verfying page title");
		test.info("Verfyig page title");
		Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
		test.pass("Login Successful");
		
	}
}

