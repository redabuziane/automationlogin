package test;

import org.testng.annotations.Test;



import base.BaseTest;
import pages.LoginPage;
import utils.log;

public class LoginTest  extends BaseTest{
	
	
	@Test  
	
	public void testValidLogin () {
		log.info("Starting login test ");
		LoginPage loginPage = new LoginPage (driver);
		
		log.info("Adding credentials");
		loginPage.enterUsername("student");
		loginPage.enterPassword("Password123");
		loginPage.clickLogin();
		
		System.out.println("title of the page is : " + driver.getTitle());
	}

	
}

