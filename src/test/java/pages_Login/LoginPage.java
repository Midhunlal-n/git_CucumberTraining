package pages_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver; // Initialize WebDriver
		PageFactory.initElements(driver, this); // Initialize PageFactory elements
		
	}

	//PageFactory Locators
	
	@FindBy(id="user-name")
	WebElement usernameInput;
	
	@FindBy(id="password")
	WebElement passwordInput;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	//PageFactory Methods
	
	public void enterUsername(String username) {
		usernameInput.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
}
