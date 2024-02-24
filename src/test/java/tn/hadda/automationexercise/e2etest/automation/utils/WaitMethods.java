package tn.hadda.automationexercise.e2etest.automation.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WaitMethods {

	WebDriverWait waitExplicit;
	FluentWait<WebDriver> fluentWait;

	public void implicitWait(WebDriver driver, long second) {
		driver.manage().timeouts().implicitlyWait(second, TimeUnit.MILLISECONDS);
	}

	public WebElement explicitWaitUntilVisibilityOfWECss(WebDriver driver, String locator, long second) {
		WebElement button;
		waitExplicit = new WebDriverWait(driver, second);
		button = waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
		return button;
	}

	public WebElement explicitWaitUntilVisibilityOfWEXpath(WebDriver driver, String locator, long second) {
		WebElement button;
		waitExplicit = new WebDriverWait(driver, second);
		button = waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return button;
	}
	
	public WebElement explicitWaitUntilVisibilityOfWEId(WebDriver driver, String locator, long second) {
		WebElement button;
		waitExplicit = new WebDriverWait(driver, second);
		button = waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		return button;
	}

	public WebElement explicitWaitUntilButtonIsClickableCss(WebDriver driver, String locator, long second) {
		WebElement button;
		waitExplicit = new WebDriverWait(driver, second);
		button = waitExplicit.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
		return button;
	}

	public WebElement explicitWaitUntilButtonIsClickableXpath(WebDriver driver, String locator, long second) {
		WebElement button;
		waitExplicit = new WebDriverWait(driver, second);
		button = waitExplicit.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		return button;
	}

	public WebElement explicitWaitUntilPresenceOfElementLocatedXpath(WebDriver driver, String locator, long second) {
		WebElement wElement;
		waitExplicit = new WebDriverWait(driver, second);
		wElement = waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		return wElement;
	}
	
	public WebElement explicitWaitUntilPresenceOfElementLocatedCss(WebDriver driver, String locator, long second) {
		WebElement wElement;
		waitExplicit = new WebDriverWait(driver, second);
		wElement = waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
		return wElement;
	}
	
	public WebElement fluentWaitUntilVisibilityOfWEId(WebDriver driver,String locator, long second , long second2) {
		WebElement wElement;
		FluentWait<WebDriver> fluentWait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(second))
                .pollingEvery(Duration.ofSeconds(second2))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
		wElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		return wElement;
	}
	
}

