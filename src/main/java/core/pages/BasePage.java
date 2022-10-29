package main.java.core.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import main.java.common.DriverManager;
import main.java.common.PageManager;

public class BasePage {
	
	protected final DriverManager driverManager = DriverManager.getDriverManager();
	
	protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofMillis(4000));
    
    protected JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
    
    protected PageManager pageManager = PageManager.getPageManager();
    
    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }
        
    
    protected WebElement sendValueToElement(WebElement element, String value) {
    	scrollToElementJs(element);
    	waitUntilElementToBeClickable(element).click();
    	clearWebField(element);
    	element.sendKeys(value);
    	return element;
        
    }
    
    protected void clearWebField(WebElement element){
        while(!element.getAttribute("value").equals("")){
            element.sendKeys(Keys.BACK_SPACE);
        }
    }
    
	protected void checkboxStatusChange(WebElement element, String attributeName, Boolean status) {
		scrollToElementJs(element);
		waitUntilElementToBeVisible(element);
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", 
                element, attributeName, status);
	}
    
    //тупая проверка тайтла
    protected Boolean checkPageTitle(WebElement element, String value) {
    	return element.getAttribute("value").contains(value);   
    }

    protected WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitUntilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    protected WebElement scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }
    
    protected WebElement scrollUpThePageJs(WebElement element) {
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        return element;
    }
    
    protected WebElement clickOnElementJs(WebElement element) {
    	js.executeScript("arguments[0].click();", element);
        return element;
    }
	
	
	
}