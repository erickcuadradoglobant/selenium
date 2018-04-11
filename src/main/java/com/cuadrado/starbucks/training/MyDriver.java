package com.cuadrado.starbucks.training;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {
	
	private WebDriver driver;
	
	public MyDriver(int browser) {
		switch(browser) {
		/*case "remoteFirefox":
			try {
				driver = new RemoteWebDriver(new URL("http://localhost/driver").);
			}catch(MalformedURLException e) {
				e.printStackTrace();
			}*/
			case 1 :
				System.setProperty("webdriver.gecko.driver","geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case 2:
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
