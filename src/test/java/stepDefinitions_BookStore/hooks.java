package stepDefinitions_BookStore;

import java.io.IOException;
import io.cucumber.java.Before;


public class hooks {



	@Before
	public void setup() throws IOException {
		ConfigReader.loadProperties();
	}

	/*
	 * @After public void teardown() { setup.quitDriver();
	 * System.out.println("Browser closed after scenario -- ");
	 * 
	 * }
	 */

}
