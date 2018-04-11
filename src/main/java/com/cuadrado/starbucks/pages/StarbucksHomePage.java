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

	List<String> idlists = Arrays
			.asList("nav_coffee", "nav_menudrinkstea", "nav_menu", "nav_coffeehouse", 
					"nav_responsibility", "nav_starbucks_rewards", "nav_blog", "nav_gift_cards");

	public StarbucksHomePage(WebDriver driver) {
		super(driver);
		driver.get("https://www.starbucks.com/");
	}
	

	
	//Primer Ejercicio 
	public String[] menu() {
		String menuoptions[]= {"", "", "", "", "", "", "", ""};
	for (int i=0; i<idlists.size(); i++) {
		System.out.println(idlists.get(i));
		menuoptions[i]= getDriver().findElement(By.id(idlists.get(i))).getText();
		}
	return menuoptions;
	}
	
	
		
	
	
	
	
}