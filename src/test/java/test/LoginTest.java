package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.log;

public class LoginTest  extends BaseTest{
	
	@DataProvider (name = "LoginData")
	
	public Object [][] getLoginData () throws IOException {
		String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
		ExcelUtils.loeadExcel(filePath, "sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object [][] data = new Object [rowCount-1][2];
		for(int i = 1 ; i <rowCount ; i++) {
			data [i-1][0] = ExcelUtils.getCellData(i, 0);
			data[i-1] [1] = ExcelUtils.getCellData(i, 1);
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
	@DataProvider (name = "LoginData2")
	
	public Object[][] getData(){
		return new Object [][] {
			{"user1","pass1"},
			{"user2","pass2"},
			{"user3","pass3"}
		};
	}
	
	
	
	//@Test  (dataProvider = "LoginData2")
	
	//@Parameters({"username","password"})
	@Test
	public void testValidLogin () {
		log.info("Starting login test ");
		test = ExtentReportManager.createTest("LoginTest -" );
		test.info("navigation to url");
		LoginPage loginPage = new LoginPage (driver);
		
		log.info("Adding credentials");
		test.info("Adding credentials");
		//loginPage.enterUsername(username);
	//	loginPage.enterPassword(password);
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
/*@Test

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
		*/
	}


