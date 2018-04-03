package com.cuadrado.starbucks.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindCoffeePage extends BasePage {
	
	public FindCoffeePage(WebDriver driver) {
		super(driver);
		driver.get("https://www.starbucks.com/");
	}
	@FindBy(xpath="//*[@id=\"nav_coffee\"]/a/strong")
	private WebElement coffee;
	
	
	//Segundo ejercicio 
	public void secondEx() {
		System.out.println("Empieza segundo ejercicio");
		String second = null;
		coffee.click();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_coffee\"]/div[1]/ol/li[2]/p/a")));
		WebElement findcoffee = getDriver().findElement(By.xpath("//*[@id=\"menu_coffee\"]/div[1]/ol/li[2]/p/a"));
		findcoffee.click();
		//ejercicio2parte1();
		ejercicio2parte2(1, 1, 2, 2);
		second = "prueba  terminada";
		System.out.println(second);
	}
	
	public void ejercicio2parte1() {
		//Encuentra y da click en en la opción 1
		WebElement option1 = getDriver().findElement(By.id("question1"));
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-event=\"Lighthearted and sunny\"]")));
		WebElement option1chossen = option1.findElement(By.cssSelector("button[data-event=\"Lighthearted and sunny\"]"));
		option1chossen.click(); 
		//Encuentra y da click en en la opción 2
		WebElement option2 = getDriver().findElement(By.id("question2"));
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-event=\"Lighthearted and sunny\"]")));
		WebElement option2chossen = option2.findElement(By.cssSelector("button[data-event=\"A group of friends\"]"));
		option2chossen.click();
		//Encuentra y da click en en la opción 3
		WebElement option3 = getDriver().findElement(By.id("question3"));
		//WebElement option3lightquestions = option3.findElement(By.className("light-questions"));
		WebElement option3chossen = option3.findElement(By.cssSelector("button[data-event=\"Toasted nuts\"]"));
		option3chossen.click();
		//Encuentra y da click en en la opción 4
		WebElement option4 = getDriver().findElement(By.id("question4"));
		WebElement option4chossen = option4.findElement(By.cssSelector("button[data-event=\"I like things simple\"]"));
		option4chossen.click();
		//Da click en el botón find my coffee
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		getWait();

		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#find-my-coffee"))).click();
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.id("find-my-coffee"))).click();
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-event=\"find-my-coffee\"]"))).click();
		
		//WebElement botonfindcoffee = getDriver().findElement(By.cssSelector("button[data-event=\"find-my-coffee\"]"));
		//botonfindcoffee.click();
		
		//Valida que la pagina desplegada sea correcta
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("all-results-headings")));
		boolean checkresult = getDriver().findElement(By.id("all-results-headings")).isDisplayed();
		Assert.assertEquals(true, checkresult);
	}
	public void ejercicio2parte2(int opt1, int opt2, int opt3, int opt4) {
		List<WebElement> option1 = getDriver().findElement(By.id("question1")).findElements(By.tagName("button"));
		option1.get(opt1).click();
		List<WebElement> option2 = getDriver().findElement(By.id("question2")).findElements(By.tagName("button"));
		option2.get(opt2).click();
		WebElement auxoption3;
		if(opt3==1) {
			new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("question3")));
			auxoption3 =getDriver().findElement(By.id("question3"));
			auxoption3 = auxoption3.findElement(By.id("light-questions"));
			List<WebElement> option3 = auxoption3.findElements(By.tagName("button"));
			option3.get(opt3).click();
		}
		if(opt3==2) {
			List<WebElement> option3 = getDriver().findElement(By.id("question3")).findElement(By.id("medium-questions")).findElements(By.tagName("button"));
			option3.get(opt3).click();
		}
		if(opt3==3) {
			List<WebElement> option3 = getDriver().findElement(By.id("question3")).findElement(By.id("dark-questions")).findElements(By.tagName("button"));
			option3.get(opt3).click();
		}
		List<WebElement> option4 = getDriver().findElement(By.id("question4")).findElements(By.tagName("button"));
		option4.get(opt4).click();
		getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		getWait();
		WebElement botonfindcoffee = new WebDriverWait(getDriver(), 100000).until(ExpectedConditions.elementToBeClickable(By.id("find-my-coffee")));
		//new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("find-my-coffee")));
		//new WebDriverWait(getDriver(), 50).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-event=\"find-my-coffee\"]"))).click();
		
		// botonfindcoffee = getDriver().findElement(By.id("find-my-coffee"));
		botonfindcoffee.click();
		
		//Valida que la pagina desplegada sea correcta
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("all-results-headings")));
		boolean checkresult = getDriver().findElement(By.id("all-results-headings")).isDisplayed();
		Assert.assertEquals(true, checkresult);
		//WebElement option2 = option1.findElement(By.)
		System.out.println(getDriver().getCurrentUrl());
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//getWait();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu-item-287\"]/a"))).click();
		//WebElement index = getDriver().findElement(By.xpath("//*[@id=\\\"menu-item-287\\\"]/a"));
		//index.click();

	}

}
