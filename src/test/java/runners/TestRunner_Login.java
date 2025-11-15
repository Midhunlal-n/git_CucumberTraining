package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/LoginDemo.feature",
		glue = { "stepDefinitions_Login" },
		plugin = { "pretty","html:target/cucumber-reports/LoginDemo-html-report.html","json:target/cucumber-reports/LoginDemo-json.json"},
		monochrome = true
		)

public class TestRunner_Login extends AbstractTestNGCucumberTests {
}
