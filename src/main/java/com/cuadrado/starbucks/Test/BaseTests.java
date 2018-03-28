package com.cuadrado.starbucks.Test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.cuadrado.starbucks.pages.StarbucksHomePage;
import com.cuadrado.training.MyDriver;

public class BaseTests {
	
	MyDriver myDriver;
	
	private StarbucksHomePage starbucksHome;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		starbucksHome = new StarbucksHomePage(myDriver.getDriver());
	}
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		//starbucksHome.dispose();
	}
	
	
	public StarbucksHomePage getStarbucksHomePage() {
		return starbucksHome;
	}
}
