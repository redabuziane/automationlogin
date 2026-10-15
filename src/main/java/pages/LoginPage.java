package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.log;

public class LoginPage {

	private WebDriver driver;
	private By usernameTextBox = By.id("username");
	private By passwordTextBox = By.id("password");
	private By loginButton = By.id("submit");
	
	public LoginPage (WebDriver driver) {
		this.driver = driver ;
		
	}
	public void enterUsername(String username) {
		driver.findElement(usernameTextBox).sendKeys(username);
		
	}
	public void enterPassword(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
		
	}
	public void clickLogin() {
		log.info("Clicking login button");
		driver.findElement(loginButton).click();
	}
}
