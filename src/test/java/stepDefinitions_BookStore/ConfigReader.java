package stepDefinitions_BookStore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static Properties prop;

	public static void loadProperties() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		prop = new Properties();
		prop.load(fis);
	}

	public static String getProperty(String Key) {
		return prop.getProperty(Key);
	}

}
