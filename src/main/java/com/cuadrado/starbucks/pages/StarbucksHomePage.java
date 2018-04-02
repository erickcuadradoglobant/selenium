package com.cuadrado.starbucks.pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;


import com.cuadrado.starbucks.pages.BasePage;

import net.bytebuddy.utility.RandomString;



public class StarbucksHomePage extends BasePage{
	private String receivedlists[];
	String receivedList[]= {"COFFEE", "TEA", "MENU", "COFFEEHOUSE", "SOCIAL IMPACT", "STARBUCKS REWARDS", "BLOG", "GIFT CARDS"};
	List<String> receivedList2 = Arrays.asList("COFFEE", "TEA", "MENU", "COFFEEHOUSE", "SOCIAL IMPACT", "STARBUCKS REWARDS", "BLOG", "GIFT CARDS");
	List<String> expectedList2;
	
	public StarbucksHomePage(WebDriver driver) {
		super(driver);
		driver.get("https://www.starbucks.com/");
	}
	@FindBy(xpath="//*[@id=\"nav_coffee\"]/a/strong")
	private WebElement coffee;
	
	@FindBy(xpath="//*[@id=\"nav_menudrinkstea\"]/a/strong")
	private WebElement tea;
	
	@FindBy(xpath="//*[@id=\"nav_menu\"]/a/strong")
	private WebElement menu;
	
	@FindBy(xpath="//*[@id=\"nav_coffeehouse\"]/a/strong")
	private WebElement coffehouse;
	
	@FindBy(xpath="//*[@id=\"nav_responsibility\"]/a/strong")
	private WebElement socialImpact;
	
	@FindBy(xpath="//*[@id=\"nav_starbucks_rewards\"]/a/strong")
	private WebElement rewards;
	
	@FindBy(xpath="//*[@id=\"nav_blog\"]/a/strong")
	private WebElement blog;
	
	@FindBy(xpath="//*[@id=\"nav_gift_cards\"]/a/strong")
	private WebElement cards;
	
	//Primer Ejercicio 
	public void menu() {
	receivedlists = null;	
	WebElement menuoptions[] = {coffee, tea, menu, coffehouse, socialImpact, rewards, blog, cards};
	//System.out.println();
	//System.out.println(coffee.getText());
	expectedList2 = Arrays.asList(coffee.getText().toString(), tea.getText().toString(),menu.getText().toString(), coffehouse.getText().toString(), socialImpact.getText().toString(), rewards.getText().toString(), blog.getText().toString(), cards.getText().toString());
	for(int i=0; i<menuoptions.length; i++) {
		//String aux = null;
		//aux = menuoptions[i].getText();
		//receivedlists[i]=menuoptions[i].getText();
		//System.out.print(menuoptions[i].getText()+ " ");
		assertEquals(receivedList[i], menuoptions[i].getText(), "Paso los Strings");
		assertEquals(receivedList2.get(i), expectedList2.get(i), "Paso con Lista");
	}
	//assertEquals(receivedlists, expectedlist);
	}
	
	
		
	
	
	
	
}