package main.java.core.pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import main.java.common.DriverManager;

public class MortagePage extends BasePage {


	@FindBy(xpath = "//iframe [@title=\"Основной контент\"]")
	private WebElement frameMortage;

	@FindBy(xpath = "//label[contains(.,'Стоимость недвижимости')]/../input")
	private WebElement inputEstatePrice;

	@FindBy(xpath = "//label[contains(.,'Первоначальный взнос')]/../input")
	private WebElement inputInitialPayment;

	@FindBy(xpath = "//label[contains(.,'Срок')]/../input")
	private WebElement inputPeriod;

	@FindBy(xpath = "//span[contains(.,'на Домклик')] /../following-sibling::*//input")
	private WebElement buttonDomclickDiscount;

	@FindBy(xpath = "//span[contains(.,'Страхование жизни')] /../following-sibling::*//input[contains(@class,'switch-input-4-0-1')]")
	private WebElement buttonInsurance;
	
	@FindBy(xpath = "//span[contains(.,'регистрация')] /../following-sibling::*//input[contains(@class,'switch-input-4-0-1')]")
	private WebElement buttonOnlineRegistration;

	
	
	public MortagePage switchToMortageFrame() {
		scrollToElementJs(frameMortage);
		waitUntilElementToBeVisible(frameMortage);
		driverManager.getDriver().switchTo().frame(frameMortage);
		return this;
	}

	public MortagePage fillFieldByName(String field, String value) {
		switch (field) {
		case "Стоимость недвижимости":
			sendValueToElement(inputEstatePrice, value);
			break;
		case "Первоначальный взнос":
			sendValueToElement(inputInitialPayment, value);
			break;
		case "Срок кредита":
			sendValueToElement(inputPeriod, value);
			break;
		default:
			Assert.fail("Не найдено поле с названием" + field);
		}
		return this;
	}

	
	public MortagePage checkboxChangeStatus(String fieldName, Boolean status) {
		String attributeName = "aria-checked";
		switch (fieldName) {
		case "Скидка на Домклик":
			checkboxStatusChange(buttonDomclickDiscount, attributeName, status);
			break;
		case "Страхование жизни и здоровья":
			checkboxStatusChange(buttonInsurance, attributeName, status);
			break;
		case "Электронная регистрация сделки":
			checkboxStatusChange(buttonOnlineRegistration, attributeName, status);
			break;
		default:
			Assert.fail("Не найден чекбокс с названием" + fieldName);
		}
		return this;
	}
	


}