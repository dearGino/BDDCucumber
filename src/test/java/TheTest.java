package test.java;
import org.junit.Test;

public class TheTest extends BaseTest {


	@Test
	 public void firstTest() throws InterruptedException {
	
		startTest.getHomePage()
		.closeCookie()
		.menuMortage()
		.menuSecondHouseMortage()
		.switchToMortageFrame()
		.fillFieldByName("Стоимость недвижимости","5180000")
		.fillFieldByName("Первоначальный взнос","3058000")
		.fillFieldByName("Срок кредита","30")
		.checkboxChangeStatus("Скидка на Домклик", false)
		.checkboxChangeStatus("Страхование жизни и здоровья", false)
		.checkboxChangeStatus("Электронная регистрация сделки", false);
	}

}

