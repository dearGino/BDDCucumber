package main.java.common;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static main.java.utils.PropConsts.*;

public class DriverManager {

	private WebDriver driver = null;
	private static DriverManager INSTANCE = null;
	private final TestPropManager props = TestPropManager.getTestPropManager();

	public static DriverManager getDriverManager() {
		if (INSTANCE == null) {
			INSTANCE = new DriverManager();
		}
		return INSTANCE;
	}

	public WebDriver getDriver() {
		if (driver == null) {
			initDriver(PATH_GECKO_DRIVER_WINDOWS, PATH_CHROME_DRIVER_WINDOWS);
		}
		return driver;
	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	private void initDriver(String gecko, String chrome) {
		switch (props.getProperty(TYPE_BROWSER)) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", props.getProperty(gecko));
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", props.getProperty(chrome));
			driver = new ChromeDriver();
			break;
		default:
			Assert.fail("Типа браузера '" + props.getProperty(TYPE_BROWSER) + "' не существует во фреймворке");
		}
	}

}
