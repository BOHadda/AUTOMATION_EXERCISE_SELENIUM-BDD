package tn.hadda.automationexercise.e2etest.automation.registeruser;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tn.hadda.automationexercise.e2etest.automation.utils.CommonMethods;
import tn.hadda.automationexercise.e2etest.automation.utils.Setup;

public class RegistrationStepDefinition extends CommonMethods {

	public WebDriver driver;
	public RegistrationPage registrationPage = new RegistrationPage();

	public RegistrationStepDefinition() {
		super();
		driver = Setup.driver;
		PageFactory.initElements(driver, RegistrationPage.class);

	}

	@Given("I navigate to home page for Automation Exercise")
	public void iNavigateToHomePageForAutomationExercise() throws IOException {
		super.openURLWithConfigFile("url");

	}

	@Given("I verify that home page is visible successfully")
	public void iVerifyThatHomePageIsVisibleSuccessfully() {
		boolean currentURL = registrationPage.verifyHomePageIsVisible();
		// String currentURL= registrationPage.verifyHomePageIsVisible();
		System.out.println("Current link is : " + currentURL);
		Assert.assertTrue(currentURL);
	}

	@Given("I click on Signup \\/ Login button")
	public void iClickOnSignupLoginButton() {
		registrationPage.clickSignupLogin();
	}

	@Given("I Verify {string} is visible")
	public void iVerifyIsVisible(String newUserSignup) {

		if (registrationPage.verifyNewUserSignupIsVisible()) {
			System.out.println("New User Signup is visible");
		} else {
			System.out.println("New User Signup is not visible");
		}
	}

	@When("I enter name {string}")
	public void iEnterName(String nameNuS) {
		registrationPage.enterName(nameNuS);
	}

	@When("I enter email address {string}")
	public void iEnterEmailAddress(String mailNus) {
		registrationPage.enterAddressMail(mailNus);
	}

	@When("I click Signup button")
	public void iClickSignupButton() {
		registrationPage.clickSignupButton();
	}

	@When("I verify that {string} is visible")
	public void iVerifyThatIsVisible(String string) {
		if (registrationPage.verifyThatEnterAccountInfoIsVisible()) {
			System.out.println("Enter Account Information is visible");
		} else {
			System.out.println("Enter Account Information is not visible");
		}
	}

	@When("I check the title {string}")
	public void iCheckTheTitle(String Mrs) {
		registrationPage.checkTheTitle(Mrs);
	}

	@When("I fill the password {string}")
	public void iFillThePassword(String pwd) {
		registrationPage.fillPassword(pwd);
	}

	@When("I select Date of birth {string}")
	public void iSelectDateOfBirth(String birthDate) {
		registrationPage.selectDateOfBirth(birthDate);
		super.scrollVertical(driver);

	}

	@When("I select checkbox {string}")
	public void iSelectCheckbox(String newsletter) {
		registrationPage.selectFirstCheckbox(newsletter);

	}

	@When("I select the second checkbox {string}")
	public void iSelectTheSecondCheckbox(String optin) {
		registrationPage.selectSecondCheckbox(optin);

	}

	@When("I enter details with their values")
	public void iEnterDetailsWithTheirValues(DataTable addressInfo) {
		List<List<String>> data = addressInfo.asLists(String.class);
		registrationPage.fillFirstName(data.get(1).get(1));
		registrationPage.fillLastName(data.get(2).get(1));
		registrationPage.fillCompany(data.get(3).get(1));
		registrationPage.fillAddress(data.get(4).get(1));
		registrationPage.fillAddress2(data.get(5).get(1));
		super.scrollVertical(driver);
		registrationPage.fillCountry(data.get(6).get(1));
		registrationPage.fillState(data.get(7).get(1));
		registrationPage.fillCity(data.get(8).get(1));
		super.scrollVertical(driver);
		registrationPage.fillzipCode(data.get(9).get(1));
		registrationPage.fillMobileNumber(data.get(10).get(1));

	}

	@When("I click Create Account button")
	public void iClickCreateAccountButton() {
		registrationPage.clickCreateAccountButton();

	}

	@Then("A message {string} is visible")
	public void aMessageIsVisible(String validMsg) {
		String accountMsg = registrationPage.getAccountText();
		System.out.println("The message of create account is : " + accountMsg);
		Assert.assertTrue(accountMsg.contains(validMsg));

	}

	@When("I click Continue button")
	public void iClickContinueButton() {
		registrationPage.clickContinueButton();
	}

	@Then("{string} is visible")
	public void isVisible(String logMsg) {
		String loggedMsg = registrationPage.getLoggedText();
		System.out.println("The message of create account is : " + loggedMsg);
		Assert.assertTrue(logMsg.contains(loggedMsg));
	}

	@When("I fill the name {string}")
	public void iFillTheName(String nameSignup) {
		registrationPage.fillTheName(nameSignup);

	}

	@When("I fill email address already exist {string}")
	public void iFillEmailAddressAlreadyExist(String existMail) {
		registrationPage.fillTheMailAlreadyExist(existMail);

	}

	/*@When("I click Signup button")
	public void iClickButton() {
		registrationPage.clickButtonSignup();

	}*/

	@Then("An error message {string} is visible")
	public void anErrorMessageIsVisible(String errorSignup) {
		String errorExistmail = registrationPage.getErrorTextSignupWithExistMail();
		System.out.println("The message of signup with exist mail is : " + errorExistmail);
		Assert.assertTrue(errorExistmail.contains(errorSignup));
	}

}
