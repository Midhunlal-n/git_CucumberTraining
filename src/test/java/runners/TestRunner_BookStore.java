package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/BookStore.feature",
		glue = { "stepDefinitions_BookStore" },
		plugin = { "pretty","html:target/cucumber-reports/Book-Store-Demo-report.html"},
		monochrome = true
		)

public class TestRunner_BookStore extends AbstractTestNGCucumberTests {
}
