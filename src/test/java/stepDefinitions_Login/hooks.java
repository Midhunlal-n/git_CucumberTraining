package stepDefinitions_Login;

import io.cucumber.java.After;
import utils.TestSetup;

public class hooks {

	public static TestSetup setup;


	@After
	public void teardown() {
		setup.quitDriver();
		System.out.println("Browser closed after scenario -- ");

	}

}
