package stepDefinitions_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages_BookStore.LoginPage;
import utils.TestSetup;

public class myStepDefs_Login {
	public WebDriver driver;// Declare WebDriver at class level
	LoginPage loginpage;


	public myStepDefs_Login() {
		TestSetup setup = new TestSetup();
		hooks.setup = setup; // Share Instance with hooks
		this.driver = setup.initializeDriver(); // Initialize WebDriver from testSetup
		loginpage = new LoginPage(driver); // send driver to page object


	}



// Background steps

	@Given("Browser is launched")
	public void browser_is_launched() {		
		System.out.println("Webdriver setup completed --");
	}

	@Given("Navigated to url {string}")
	public void navigated_to_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		System.out.println("Navigated to " + url + "  --");
	}

// Actual Scenario steps

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		System.out.println("User enters username " + username + " and password " + password + " --");

	}

	@Then("User should be redirected to the homepage")
	public void user_should_be_redirected_to_the_homepage() {
		if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
			System.out.println("User is navigated to the homepage --");
			System.out.println("Current url -- "+driver.getCurrentUrl());


		} else {
			assert false;
		}
	}

	@Then("User should be able to Logout")
	public void user_should_be_able_to_logout() {
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println("User is Logged out -- ");

	}

	@Then("Error button should be displayed")
	public void error_button_should_be_displayed() {
		if (driver.findElement(By.xpath("//button[@class='error-button']")).isDisplayed() == true) {

			// Get Error Message
			String getText = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
			System.out.println("Error Message - " + getText);
			System.out.println("Login Failed - Username and Password does not match -- ");
			

		} else {
			assert false;
		}

	}
}
