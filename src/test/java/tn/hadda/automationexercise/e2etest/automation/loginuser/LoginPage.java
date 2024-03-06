package tn.hadda.automationexercise.e2etest.automation.loginuser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import tn.hadda.automationexercise.e2etest.automation.utils.Setup;
import tn.hadda.automationexercise.e2etest.automation.utils.WaitMethods;

public class LoginPage {
	/* Locators */
	final static String LOGIN_TO_YOUR_ACCOUNT = "//h2[contains(text(),'Login to your account')]";
	final static String EMAIL_ADDRESS = "[data-qa='login-email']";
	final static String PASSWORD_LOGIN = "[data-qa='login-password']";
	final static String LOGIN_BUTTON = "[data-qa='login-button']";
	final static String DELETE_ACCOUNT = "//a[@href='/delete_account']";
	final static String MSG_DELETE_ACCOUNT = "//b[contains(text(),'Account Deleted!')]";
	final static String MSG_INVALID_LOGIN = "//p[contains(text(),'Your email or password is incorrect!')]";

	/* @FindBy */

	@FindBy(how = How.XPATH, using = LOGIN_TO_YOUR_ACCOUNT)
	public static WebElement loginToYourAccount;
	@FindBy(how = How.CSS, using = EMAIL_ADDRESS)
	public static WebElement emailAddress;
	@FindBy(how = How.CSS, using = PASSWORD_LOGIN)
	public static WebElement passwordLogin;
	@FindBy(how = How.CSS, using = LOGIN_BUTTON)
	public static WebElement loginBtn;
	@FindBy(how = How.XPATH, using = DELETE_ACCOUNT)
	public static WebElement deleteAccount;
	@FindBy(how = How.XPATH, using = MSG_DELETE_ACCOUNT)
	public static WebElement msgDeleteAccount;
	@FindBy(how = How.XPATH, using = MSG_INVALID_LOGIN)
	public static WebElement msgInvalidLogin;

	/* Initialisation */
	WaitMethods waitMethod = new WaitMethods();
	WebDriver driver = Setup.driver;

	/* Methods */

	public boolean verifyLoginToYourAccountIsVisible() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, LOGIN_TO_YOUR_ACCOUNT, 5);
		return loginToYourAccount.isDisplayed();
	}

	public void enterEmailAddress(String email) {
		emailAddress.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordLogin.sendKeys(password);
	}

	public void clickLoginButton() {
		loginBtn.click();

	}

	public void clickDeleteAccountButton() {
		deleteAccount.click();

	}

	public String getDeleteAccountText() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, MSG_DELETE_ACCOUNT, 5);
		return msgDeleteAccount.getText();
	}

	public void enterIncorrectEmailAddress(String invEmail) {
		emailAddress.sendKeys(invEmail);
	}

	public void enterIncorrectPassword(String invpassword) {
		passwordLogin.sendKeys(invpassword);
	}

	public String getErrorMessageOfLoginText() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, MSG_INVALID_LOGIN, 5);
		return msgInvalidLogin.getText();
	}

}
