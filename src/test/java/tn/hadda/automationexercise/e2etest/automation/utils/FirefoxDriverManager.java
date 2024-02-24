package tn.hadda.automationexercise.e2etest.automation.utils;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
	@Override
	protected void startService() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");

	}

	@Override
	protected void stopService() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createDriver() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}
}
