package stepDefinitions_Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages_Login.LoginPage;
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

	@Given("Navigated to url")
	public void navigated_to_url() throws IOException {

		// properties file example
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\object.properties");
		p.load(fi);
		String url = p.getProperty("url");

		driver.get(url);
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
	public void user_should_be_redirected_to_the_homepage() throws IOException {
		// POI excel read
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\excelInput\\Homepageurl_excelRead.xlsx";
		FileInputStream file = new FileInputStream(excelPath);
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("Test_Sheet");
		String homepageUrl = sheet.getRow(0).getCell(1).getStringCellValue();
		
		
		System.out.println("Excel value - "+homepageUrl);
		workbook.close();
		
		
		
		
		if (driver.getCurrentUrl().equals(homepageUrl)) {
			System.out.println("User is navigated to the homepage --");
			System.out.println("Current url -- " + driver.getCurrentUrl());

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
