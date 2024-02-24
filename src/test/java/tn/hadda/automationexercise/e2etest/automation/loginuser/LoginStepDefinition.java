package tn.hadda.automationexercise.e2etest.automation.loginuser;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import tn.hadda.automationexercise.e2etest.automation.utils.Setup;

public class LoginStepDefinition {

	public WebDriver driver;
	public LoginPage loginPage = new LoginPage();

	public LoginStepDefinition() {
		driver = Setup.driver;
		PageFactory.initElements(driver, LoginPage.class);

	}
	
	
	@Given("I Verify meassage of login {string} is visible")
	public void iVerifyMeassageOfLoginIsVisible(String loginToYourAccount) {
		
		if (loginPage.verifyLoginToYourAccountIsVisible()) {
			System.out.println("Login to your account is visible");
		} else {
			System.out.println("Login to your account is not visible");
		}
	}

	@When("I enter correct email address {string}")
	public void iEnterCorrectEmailAddress(String mail) {
		loginPage.enterEmailAddress(mail);
	}

	@When("I enter the valid password {string}")
	public void iEnterTheValidPassword(String pswd) {
		loginPage.enterPassword(pswd);
	}

	@When("I click login button")
	public void iClickLoginButton() {
		loginPage.clickLoginButton();
	}

	@When("I click Delete Account button")
	public void iClickDeleteAccountButton() {
		loginPage.clickDeleteAccountButton();
	}

	@Then("I verify that the message of delete {string} is visible")
	public void iVerifyThatTheMessageOfDeleteIsVisible(String msgDelete) {
		String deleteAccountMsg = loginPage.getDeleteAccountText();
		System.out.println("The message of delete account is : " + deleteAccountMsg);
		Assert.assertTrue(deleteAccountMsg.contains(msgDelete));
	}

	@When("I enter incorrect email address {string}")
	public void iEnterIncorrectEmailAddress(String invMail) {
		loginPage.enterIncorrectEmailAddress(invMail);
	}

	@When("I enter the invalid password {string}")
	public void iEnterTheInvalidPassword(String invPswd) {
		loginPage.enterIncorrectPassword(invPswd);
	}

	@Then("I verify error message {string} is visible")
	public void iVerifyErrorMessageIsVisible(String msgInvLogin) {
		String invalidLoginMsg = loginPage.getErrorMessageOfLoginText();
		System.out.println("The message of invalid login with incorect mail and password is : " +invalidLoginMsg);
		Assert.assertTrue(invalidLoginMsg.contains(msgInvLogin));
	}

}
