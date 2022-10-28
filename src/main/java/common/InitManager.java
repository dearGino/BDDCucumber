package main.java.common;

import java.time.Duration;
import static main.java.utils.PropConsts.*;

public class InitManager {

	private static final DriverManager driverManager = DriverManager.getDriverManager();
	private static final TestPropManager props = TestPropManager.getTestPropManager();

	public static void initFramework() {
		driverManager.getDriver().manage().window().maximize();
		driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT))));
		driverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT))));   
	}


	public static void quitFramework() {
		driverManager.quitDriver();
	}
}
