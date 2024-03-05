package tn.hadda.automationexercise.e2etest.automation.registeruser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import tn.hadda.automationexercise.e2etest.automation.utils.CommonMethods;
import tn.hadda.automationexercise.e2etest.automation.utils.Setup;
import tn.hadda.automationexercise.e2etest.automation.utils.WaitMethods;

public class RegistrationPage {
	/* Locators */
	final static String SIGNUP_LOGIN_BUTTON = "//a[@href='/login']";
	final static String NEW_USER_SIGNUP = "//h2[contains(text(),'New User Signup!')]";
	final static String NAME = "//input[contains(@data-qa,'signup-name')]";
	final static String MAIL = "//input[contains(@data-qa,'signup-email')]";
	final static String SIGNUP_BUTTON = "//button[contains(@data-qa,'signup-button')]";
	final static String ENTER_ACCOUNT_INFORMATION = "//b[contains(text(),'Enter Account Information')]";
	final static String TITLE = "id_gender2";
	final static String PASSWORD = "password";
	final static String DAY = "days";
	final static String MONTH = "months";
	final static String YEAR = "years";
	final static String FIRST_CHECKBOX = "newsletter";
	final static String SECOND_CHECKBOX = "optin";
	final static String FIRST_NAME = "first_name";
	final static String LAST_NAME = "last_name";
	final static String COMPANY = "company";
	final static String ADDRESS = "address1";
	final static String ADDRESS2 = "address2";
	final static String COUNTRY = "country";
	final static String STATE = "state";
	final static String CITY = "city";
	final static String ZIP_CODE = "zipcode";
	final static String MOBILE_NUMBER = "mobile_number";
	final static String CREATE_ACCOUNT_BUTTON = "//button[contains(@data-qa,'create-account')]";
	final static String MSG_CREATE_ACCOUNT = "//b[contains(text(),'Account Created!')]";
	final static String CONTINUE_BUTTON = "//a[contains(@data-qa,'continue-button')]";
	final static String ANNONCE ="//svg[@fill='#5F6368']";
	final static String MSG_LOGGED = "//b[contains(text(),'Hadda')]";
	final static String ERROR_MSG_EXIST_MAIL = "//p[contains(text(),'Email Address already exist!')]";
	//a[contains(@class,'fa fa-user')]
	
	/* @FindBy */
	@FindBy(how = How.XPATH, using = SIGNUP_LOGIN_BUTTON)
	public static WebElement signupLoginBtn;

	@FindBy(how = How.XPATH, using = NEW_USER_SIGNUP)
	public static WebElement newUserSignup;

	@FindBy(how = How.XPATH, using = NAME)
	public static WebElement nameNUS;

	@FindBy(how = How.XPATH, using = MAIL)
	public static WebElement mailNUS;

	@FindBy(how = How.XPATH, using = SIGNUP_BUTTON)
	public static WebElement signupBtn;

	@FindBy(how = How.XPATH, using = ENTER_ACCOUNT_INFORMATION)
	public static WebElement enterAccountInfo;

	@FindBy(how = How.ID, using = TITLE)
	public static WebElement title;

	@FindBy(how = How.ID, using = PASSWORD)
	public static WebElement password;

	@FindBy(how = How.ID, using = DAY)
	public static WebElement day;

	@FindBy(how = How.ID, using = MONTH)
	public static WebElement month;

	@FindBy(how = How.ID, using = YEAR)
	public static WebElement year;

	@FindBy(how = How.ID, using = FIRST_CHECKBOX)
	public static WebElement firstCheckbox;

	@FindBy(how = How.ID, using = SECOND_CHECKBOX)
	public static WebElement secondCheckbox;

	@FindBy(how = How.ID, using = FIRST_NAME)
	public static WebElement firstName;

	@FindBy(how = How.ID, using = LAST_NAME)
	public static WebElement lastName;

	@FindBy(how = How.ID, using = COMPANY)
	public static WebElement company;

	@FindBy(how = How.ID, using = ADDRESS)
	public static WebElement address;

	@FindBy(how = How.ID, using = ADDRESS2)
	public static WebElement address2;

	@FindBy(how = How.ID, using = COUNTRY)
	public static WebElement country;

	@FindBy(how = How.ID, using = STATE)
	public static WebElement state;

	@FindBy(how = How.ID, using = CITY)
	public static WebElement city;

	@FindBy(how = How.ID, using = ZIP_CODE)
	public static WebElement zipCode;

	@FindBy(how = How.ID, using = MOBILE_NUMBER)
	public static WebElement mobileNumber;

	@FindBy(how = How.XPATH, using = CREATE_ACCOUNT_BUTTON)
	public static WebElement createAccountBtn;

	@FindBy(how = How.XPATH, using = MSG_CREATE_ACCOUNT)
	public static WebElement msgCreateAccount;

	@FindBy(how = How.XPATH, using = CONTINUE_BUTTON)
	public static WebElement continueBtn;
	
	@FindBy(how = How.XPATH, using = ANNONCE)
	public static WebElement annonce;

	@FindBy(how = How.XPATH, using = MSG_LOGGED)
	public static WebElement msgLogged;
	
	@FindBy(how = How.XPATH, using = ERROR_MSG_EXIST_MAIL)
	public static WebElement errorMsg;
	

	/* Initialisation */
	WaitMethods waitMethod = new WaitMethods();
	WebDriver driver = Setup.driver;

	/* Methods */
	public boolean verifyHomePageIsVisible() {
		waitMethod.implicitWait(driver, 5);
		return driver.getCurrentUrl().equals("url");
		// return driver.getCurrentUrl();
	}

	public void clickSignupLogin() {
		signupLoginBtn.click();
	}

	public boolean verifyNewUserSignupIsVisible() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, NEW_USER_SIGNUP, 5);
		return newUserSignup.isDisplayed();
	}

	public void enterName(String nameNuS) {
		nameNUS.sendKeys(nameNuS);
	}

	public void enterAddressMail(String mailNuS) {
		mailNUS.sendKeys(mailNuS);
	}

	public void clickSignupButton() {
		signupBtn.click();

	}

	public boolean verifyThatEnterAccountInfoIsVisible() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, ENTER_ACCOUNT_INFORMATION, 5);
		return enterAccountInfo.isDisplayed();
	}

	public void checkTheTitle(String Mrs) {
		title.click();
	}

	public void fillPassword(String pwd) {
		CommonMethods.scrollVisibilityElement(driver, password);
		waitMethod.explicitWaitUntilVisibilityOfWEId(driver, PASSWORD, 5);
		password.sendKeys(pwd);
	}

	public void selectDateOfBirth(String birthDate) {
		Select dayList = new Select(day);
		dayList.selectByValue("17");
		Select monthList = new Select(month);
		monthList.selectByValue("9");
		Select yearList = new Select(year);
		yearList.selectByValue("1995");
	}

	public void selectFirstCheckbox(String newsletter) {
		firstCheckbox.click();

	}

	public void selectSecondCheckbox(String optin) {
		secondCheckbox.click();

	}

	public void fillFirstName(String fName) {
		firstName.sendKeys(fName);
	}

	public void fillLastName(String lName) {
		lastName.sendKeys(lName);
	}

	public void fillCompany(String cmpy) {
		company.sendKeys(cmpy);
	}

	public void fillAddress(String adrs) {
		address.sendKeys(adrs);
	}

	public void fillAddress2(String adrs2) {
		address2.sendKeys(adrs2);
	}

	public void fillCountry(String cntry) {
		Select countryList = new Select(country);
		countryList.selectByValue("Canada");
	}

	public void fillState(String strgState) {
		state.sendKeys(strgState);
	}

	public void fillCity(String strgCity) {
		city.sendKeys(strgCity);
	}

	public void fillzipCode(String code) {
		zipCode.sendKeys(code);
	}

	public void fillMobileNumber(String mobileNmbr) {
		mobileNumber.sendKeys(mobileNmbr);
	}

	public void clickCreateAccountButton() {
		createAccountBtn.click();

	}

	public String getAccountText() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, MSG_CREATE_ACCOUNT, 15);
		return msgCreateAccount.getText();
	}

	public void clickContinueButton() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, CONTINUE_BUTTON, 5);
		continueBtn.click();
		//annonce.click();

	}

	public String getLoggedText() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, MSG_LOGGED, 10);
		return msgLogged.getText();
	}
	
	public void fillTheName(String nameSigup) {
		nameNUS.sendKeys(nameSigup);

	}
	
	public void fillTheMailAlreadyExist(String existMail) {
		mailNUS.sendKeys(existMail);

	}
	
	public void clickButtonSignup() {
		signupBtn.click();;

	}
	
	public String getErrorTextSignupWithExistMail() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, ERROR_MSG_EXIST_MAIL, 5);
		return errorMsg.getText();
	}
	
	

}
