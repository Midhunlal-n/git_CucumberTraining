package stepDefinitions_BookStore;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class myStepDefs_BookStore {

	public WebDriver driver;

// Actual Scenario steps
	@Given("Open the browser")
	public void open_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		System.out.println("Webdriver setup completed --");

	}

	@When("Navigate to expected url")
	public void Navigate_to_expected_url() {
		// Data driven - from property file
		String url = ConfigReader.getProperty("url");

		driver.get(url);
		System.out.println("Navigated to " + url + "  --");
	}

	@When("Click on Shop Menu")
	public void click_on_shop_menu() {
		driver.findElement(By.linkText("Shop")).click();
		System.out.println("Clicked on Shop --");

	}

	@When("click on Home menu button")
	public void click_on_home_menu_button() {
		driver.findElement(By.linkText("Home")).click();
		System.out.println("Clicked on Home --");

	}

	@When("Check whether the Home page has Three Arrivals only")
	public void Check_whether_the_home_page_has_three_arrivals_only() {
		List<WebElement> arrivals = driver
				.findElements(By.xpath("//a[contains(@href,'https://practice.automationtesting.in/product/')]"));
		System.out.println("Arrivals in the homepage [Count] - " + arrivals.size());

		if (arrivals.size() == 3) {
			System.out.println("Homepage has exact three arrivals only");
			for (WebElement newarrivals : arrivals) {
				System.out.println("Arrival Item - " + newarrivals.getAttribute("href"));
			}
		} else {
			assert false;
		}

	}

	@When("Now click the image in the Arrivals")
	public void now_click_the_image_in_the_arrivals() throws IOException {
		// Data driven - from excel file
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\excelInput\\Bookstore_Excel.xlsx";
		String bookname = ExcelReader.getCellData(excelPath, "Test_Sheet", 0, 1);

		driver.findElement(By.xpath("//img[@alt='" + bookname + "']")).click();
		System.out.println("Clicked on arrival/ " + bookname + " -- ");
	}

	@Then("Test whether it is navigating to next page where the user can add that book into his basket.")
	public void test_whether_it_is_navigating_to_next_page_where_the_user_can_add_that_book_into_his_basket()
			throws InterruptedException {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String getText = driver.findElement(By.xpath("//*[contains(text(),'added to your basket')]")).getText();
		String[] getTextarr = getText.split("\n");
		System.out.println(getTextarr[1]);

		System.out.println("Test Completed -- ");
		Thread.sleep(2000);
		driver.quit();
	}

}
