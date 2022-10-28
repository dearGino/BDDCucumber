package main.java.core.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MortagePage extends BasePage {

	// Поисковое поле
	@FindBy(xpath = "//div[contains(@class, 'header-menu-wrapper')]/*/*/input[contains(@type,'search')]")
	private WebElement searchField;

//	public HomePage clickOnMortage() {
//		waitUntilElementToBeClickable(testclick).click();
//		System.out.println("i did it");
//		return pageManager.getMortagePage();
//	}

}