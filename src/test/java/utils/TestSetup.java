package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSetup {

	public WebDriver driver;

	public WebDriver initializeDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:\\Users\\midhunn\\ChromeProfiles");
		options.addArguments("profile-directory=Profile 2");
		driver = new ChromeDriver(options);
		
		//driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Set timeouts
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		return driver;

	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}
