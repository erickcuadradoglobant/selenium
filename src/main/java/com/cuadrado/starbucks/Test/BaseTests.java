package com.cuadrado.starbucks.Test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.cuadrado.starbucks.pages.FindCoffeePage;
import com.cuadrado.starbucks.pages.GiftCardPage;
import com.cuadrado.starbucks.pages.StarbucksHomePage;
import com.cuadrado.starbucks.training.MyDriver;

public class BaseTests {
	
	MyDriver myDriver;
	
	private StarbucksHomePage starbucksHome;
	private FindCoffeePage findCoffee;
	private GiftCardPage giftCard;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		starbucksHome = new StarbucksHomePage(myDriver.getDriver());
		findCoffee =new FindCoffeePage(myDriver.getDriver());
		giftCard = new GiftCardPage(myDriver.getDriver());
	}
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		//starbucksHome.dispose();
	}
	
	
	public StarbucksHomePage getStarbucksHomePage() {
		return starbucksHome;
	}
	 public FindCoffeePage getFindCoffeePage() {
		 return findCoffee;
	 }
	 public GiftCardPage getGiftCardPAge() {
		 return giftCard;
	 }
}
