package main.java.core.pages;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

	//Кнопка "Ипотека"
	@FindBy(xpath = "//a[@aria-label='Ипотека']")
	private WebElement buttonMortage;
	
	//Кнопка "Ипотека"
	@FindBy(xpath = "//a[contains(@data-cga_click_top_menu,\"Ипотека на вторичное жильё\")]")
	private WebElement buttonSecondHouseMortage;

	

	public HomePage menuMortage() {
		waitUntilElementToBeClickable(buttonMortage).click();
		return this;
	}
	
	public MortagePage menuSecondHouseMortage() {
		waitUntilElementToBeClickable(buttonSecondHouseMortage).click();
		return pageManager.getMortagePage();
	}
	
	
}
