package tn.hadda.automationexercise.e2etest.automation.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

	private ChromeDriverService chService;

	@Override
	public void startService() {
		
	}

	@Override
	public void stopService() {
		if (null != chService && chService.isRunning())
			chService.stop();
	}
	@Override
	public void createDriver() {
		 System.setProperty("webdriver.chrome.driver","D:\\TEST_AUTO_SELENIUM_GIT\\ProjectWithFrameworkSeleniumBDD\\src\\test\\ressources\\drivers\\chromedriver.exe");
         ChromeOptions optionsChrome = new ChromeOptions();
         optionsChrome.addArguments("--start-maximized");
         optionsChrome.addArguments("--disable-infobars");
         optionsChrome.addArguments("--disable-popup-blocking");
         optionsChrome.setAcceptInsecureCerts(true);
         driver = new ChromeDriver(optionsChrome);
       
	}
}
