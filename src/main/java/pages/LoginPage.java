package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.log;

public class LoginPage {

	private WebDriver driver;
	@FindBy (id="username")
	WebElement usernameTextbox;
	@FindBy (id ="password")
	WebElement passwordTextbox;
	@FindBy (id="submit")
	WebElement loginButton;
	
	/*private By usernameTextBox = By.id("username");
	private By passwordTextBox = By.id("password");
	private By loginButton = By.id("submit");*/
	
	public LoginPage (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver,this);
	}
	public void enterUsername(String username) {
		
		usernameTextbox.clear();
		usernameTextbox.sendKeys(username);
		
	}
	public void enterPassword(String password) {
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
		
		
	}
	public void clickLogin() {
		log.info("Clicking login button");
		loginButton.click();
	}
}
