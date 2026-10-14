package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By usernameTextBox = By.name("username");
	private By passwordTextBox = By.name("password");
	private By loginButton = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	
	public LoginPage (WebDriver driver) {
		this.driver = driver ;
		
	}
	public void entreUsername(String username) {
		driver.findElement(usernameTextBox).sendKeys(username);
		
	}
	public void entrePassword(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
		
	}
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
}
