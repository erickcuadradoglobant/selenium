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

public class GiftCardPage extends BasePage {
	public GiftCardPage(WebDriver driver) {
		super(driver);
		driver.get("https://www.starbucks.com/");
	}
	@FindBy(xpath="//*[@id=\"nav_gift_cards\"]/a/strong")
	private WebElement cards;
	//Tercer Ejercicio
		public void thirdEx() {
			cards.click();
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_gift_cards\"]/div[1]/ol/li[1]/ol/li[1]/a")));
			WebElement giftcardoptions = getDriver().findElement(By.xpath("//*[@id=\"menu_gift_cards\"]/div[1]/ol/li[1]/ol/li[1]/a"));
			giftcardoptions.click();
			WebElement giftcardselected = getDriver().findElement(By.xpath("//*[@id=\"egift-categories\"]/li[1]/a"));
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
