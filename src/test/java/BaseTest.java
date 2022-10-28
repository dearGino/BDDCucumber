package test.java;

import main.java.common.DriverManager;
import main.java.common.InitManager;
import main.java.common.PageManager;
import main.java.common.TestPropManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static main.java.utils.PropConsts.*;

public class BaseTest {
	
	protected PageManager startTest = PageManager.getPageManager();
	private final DriverManager driverManager = DriverManager.getDriverManager();

	
    @BeforeClass
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @Before
    public void beforeEach() {
        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty(BASE_URL));
    }

    @AfterClass
    public static void afterAll() {
        InitManager.quitFramework();
    }
}
