package main.java.core.pages;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

	//Кнопка "Ипотека"
	@FindBy(xpath = "//a[@aria-label='Ипотека']")
	private WebElement buttonMortage;
	
	//Кнопка "Ипотека"
	@FindBy(xpath = "//a[contains(@data-cga_click_top_menu,\"Ипотека на вторичное жильё\")]")
	private WebElement buttonSecondHouseMortage;

	@FindBy(xpath = "//div [@class='kitt-cookie-warning']")
	private WebElement buttonCloseCookie;

	public HomePage menuMortage() {
		waitUntilElementToBeClickable(buttonMortage).click();
		return this;
	}
	
	public MortagePage menuSecondHouseMortage() {
		waitUntilElementToBeClickable(buttonSecondHouseMortage).click();
		return pageManager.getMortagePage();
	}

	public HomePage closeCookie() {
		try {
			waitUntilElementToBeVisible(buttonCloseCookie).click();
		}
		catch(NoSuchElementException exc) {
			System.out.println("Нет окна с куки");
		}
		return this;
	}
	
	
}
