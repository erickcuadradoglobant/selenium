package com.cuadrado.starbucks.training;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MyDriver {
	
	private WebDriver driver;
	
	public MyDriver(String browser) {
		switch(browser) {
		/*case "remoteFirefox":
			try {
				driver = new RemoteWebDriver(new URL("http://localhost/driver").);
			}catch(MalformedURLException e) {
				e.printStackTrace();
			}*/
			case "1" :
				System.setProperty("webdriver.gecko.driver","geckodriver.exe");
				FirefoxOptions firefoxOptions = new FirefoxOptions(DesiredCapabilities.firefox());
		        firefoxOptions.addPreference("browser.popups.showPopupBlocker", false);
		        firefoxOptions.addPreference("security.sandbox.content.level", 5);
		        firefoxOptions.setAcceptInsecureCerts(true);
		        firefoxOptions.setProfile(new FirefoxProfile());
				driver = new FirefoxDriver();
				break;
			case "2":
				System.setProperty("webdriver.chrome.driver","C:\\Users\\erick.cuadrado\\Documents\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			default:
				break;
		}
	}
	public WebDriver getDriver() {
		return this.driver;
	}

}
