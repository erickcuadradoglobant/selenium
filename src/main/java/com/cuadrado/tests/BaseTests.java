	package com.cuadrado.tests;



import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.cuadrado.pages.WikiHomePage;
import com.cuadrado.starbucks.pages.StarbucksHomePage;
import com.cuadrado.training.MyDriver;

public class BaseTests {
	
	MyDriver myDriver;
	
	private WikiHomePage wikiHome;
	
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		wikiHome = new WikiHomePage(myDriver.getDriver());
	}
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		//wikiHome.dispose();
	}
	
	public WikiHomePage getWikiHomePage() {
		return wikiHome;
	}

}
