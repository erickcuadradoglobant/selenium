package com.cuadrado.starbucks.Test;

import org.testng.annotations.Test;

import com.cuadrado.starbucks.pages.FindCoffeePage;
import com.cuadrado.starbucks.pages.GiftCardPage;
import com.cuadrado.starbucks.pages.StarbucksHomePage;


public class StarbucksTests extends BaseTests{

	@Test
	public void testStarbucks() {
		StarbucksHomePage home = getStarbucksHomePage();
		
		
		//home.menu();
		//home.secondEx();
		home.menu();
		//home.dispose();
		FindCoffeePage coffee = getFindCoffeePage();
		coffee.secondEx();
		GiftCardPage card = getGiftCardPAge();
		card.thirdEx();
		
	}

	
}
