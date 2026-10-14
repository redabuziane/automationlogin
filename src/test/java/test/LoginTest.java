package test;

import org.testng.annotations.Test;



import base.BaseTest;
import pages.LoginPage;

public class LoginTest  extends BaseTest{
	
	
	@Test  
	
	public void testValidLogin () {
		
		LoginPage loginPage = new LoginPage (driver);
		
		
		loginPage.enterUsername("student");
		loginPage.enterPassword("Password123");
		loginPage.clickLogin();
		
		System.out.println("title of the page is : " + driver.getTitle());
	}

	
}

