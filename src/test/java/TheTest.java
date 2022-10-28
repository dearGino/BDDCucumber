package test.java;
import org.junit.Test;

public class TheTest extends BaseTest {


	@Test
	 public void firstTest() throws InterruptedException {
	
		startTest.getHomePage()
		.menuMortage()
		.menuSecondHouseMortage();
	}

}

