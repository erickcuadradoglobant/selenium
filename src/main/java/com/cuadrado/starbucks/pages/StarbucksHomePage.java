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
	
	
	public void menu() {
	receivedlists = null;	
	WebElement menuoptions[] = {coffee, tea, menu, coffehouse, socialImpact, rewards, blog, cards};
	//System.out.println();
	expectedList2 = Arrays.asList(coffee.getText().toString(), tea.getText().toString(),menu.getText().toString(), coffehouse.getText().toString(), socialImpact.getText().toString(), rewards.getText().toString(), blog.getText().toString(), cards.getText().toString());
	for(int i=0; i<menuoptions.length; i++) {
		//String aux = null;
		//aux = menuoptions[i].getText();
		//receivedlists[i]=menuoptions[i].getText();
		System.out.print(menuoptions[i].getText()+ " ");
		assertEquals(receivedList[i], menuoptions[i].getText(), "Paso los Strings");
		assertEquals(receivedList2.get(i), expectedList2.get(i), "Paso con Lista");
	}
	//assertEquals(receivedlists, expectedlist);
	}
	

	public void secondEx() {
		String second = null;
		coffee.click();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_coffee\"]/div[1]/ol/li[2]/p/a")));
		WebElement findcoffee = getDriver().findElement(By.xpath("//*[@id=\"menu_coffee\"]/div[1]/ol/li[2]/p/a"));
		findcoffee.click();
		ejercicio2parte1();
		ejercicio2parte2(1, 1, 2, 2);
		second = "prueba  terminada";
		System.out.println(second);
	}

	public void ejercicio2parte1() {
		//Encuentra y da click en en la opci�n 1
		WebElement option1 = getDriver().findElement(By.id("question1"));
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-event=\"Lighthearted and sunny\"]")));
		WebElement option1chossen = option1.findElement(By.cssSelector("button[data-event=\"Lighthearted and sunny\"]"));
		option1chossen.click(); 
		//Encuentra y da click en en la opci�n 2
		WebElement option2 = getDriver().findElement(By.id("question2"));
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-event=\"Lighthearted and sunny\"]")));
		WebElement option2chossen = option2.findElement(By.cssSelector("button[data-event=\"A group of friends\"]"));
		option2chossen.click();
		//Encuentra y da click en en la opci�n 3
		WebElement option3 = getDriver().findElement(By.id("question3"));
		//WebElement option3lightquestions = option3.findElement(By.className("light-questions"));
		WebElement option3chossen = option3.findElement(By.cssSelector("button[data-event=\"Toasted nuts\"]"));
		option3chossen.click();
		//Encuentra y da click en en la opci�n 4
		WebElement option4 = getDriver().findElement(By.id("question4"));
		WebElement option4chossen = option4.findElement(By.cssSelector("button[data-event=\"I like things simple\"]"));
		option4chossen.click();
		//Da click en el bot�n find my coffee
		getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#find-my-coffee"))).click();
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.id("find-my-coffee"))).click();
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-event=\"find-my-coffee\"]"))).click();
		
		WebElement botonfindcoffee = getDriver().findElement(By.cssSelector("button[data-event=\"find-my-coffee\"]"));
		botonfindcoffee.click();
		
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
		//new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.id("button#find-my-coffee"))).click();
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.id("find-my-coffee"))).click();
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-event=\"find-my-coffee\"]"))).click();
		
		WebElement botonfindcoffee = getDriver().findElement(By.cssSelector("button[data-event=\"find-my-coffee\"]"));
		botonfindcoffee.click();
		
		//Valida que la pagina desplegada sea correcta
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("all-results-headings")));
		boolean checkresult = getDriver().findElement(By.id("all-results-headings")).isDisplayed();
		Assert.assertEquals(true, checkresult);
		//WebElement option2 = option1.findElement(By.)

	}
	
	public void thirdEx() {
		cards.click();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_gift_cards\"]/div[1]/ol/li[1]/ol/li[1]/a")));
		WebElement giftcardoptions = getDriver().findElement(By.xpath("//*[@id=\"menu_gift_cards\"]/div[1]/ol/li[1]/ol/li[1]/a"));
		giftcardoptions.click();
		WebElement giftcardselected = getDriver().findElement(By.xpath("//*[@id=\"egift-categories\"]/li[1]/a/img"));
		giftcardselected.click();
		
		String rec= "destinatario";
		String mes= "mensaje";
		String nam= "fulanito";
		String mail = nam + "@"+rec+".com";
		String mail2 = rec + "@"+nam+".com";
		String fecha = "4/28/2018";
		

		
		getDriver().findElement(By.id("recipient_name")).sendKeys(rec);
		getDriver().findElement(By.id("message")).sendKeys(mes);
		getDriver().findElement(By.id("sender_name")).sendKeys(nam);
		getDriver().findElement(By.id("recipient_email")).sendKeys(mail); 
		getDriver().findElement(By.id("sender_email")).sendKeys(mail2);
		getDriver().findElement(By.id("delivery_date")).clear();
		getDriver().findElement(By.id("delivery_date")).sendKeys(fecha);
		getDriver().findElement(By.className("action")).click();
		
		List<WebElement> result = getDriver().findElement(By.className("odd")).findElements(By.tagName("td"));
		WebElement recipientreceived = result.get(1);
		WebElement amountreceived = result.get(2);
		WebElement daterecieved = result.get(3);
		WebElement namereceived = result.get(6);
		String strnamereceived = namereceived.getText().toString();
		String strrecipientreceived = recipientreceived.getText().toString();
		String strdaterecieved =daterecieved.getText().toString();
		String stramountreceived = amountreceived.getText().toString();
		String lines[] = strnamereceived.split("\\n");
		
		
		System.out.println(recipientreceived.getText() + " resultado1 " + mail);
		System.out.println(amountreceived.getText()  + " resultado2 " + lines[0]);
		System.out.println(daterecieved.getText()  + " resultado3 " + fecha);
		System.out.println(namereceived.getText()  + " resultado4 " + lines[1]);
		
		Assert.assertEquals(strrecipientreceived, mail);
		Assert.assertEquals(strdaterecieved, fecha);
		Assert.assertEquals(lines[0], rec);
		Assert.assertEquals(lines[1], mes);
	}
	
	
}