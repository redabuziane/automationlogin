package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.log;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		
		log.info("Starting WebDriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Navigation to demowebsite");
		driver.get("https://practicetestautomation.com/practice-test-login/");

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			log.info("closing Browser");
			 driver.quit();

		}
	}
}
