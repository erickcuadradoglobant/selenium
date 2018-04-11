package com.cuadrado.starbucks.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cuadrado.starbucks.pages.FindCoffeePage;
import com.cuadrado.starbucks.pages.GiftCardPage;
import com.cuadrado.starbucks.pages.StarbucksHomePage;


public class StarbucksTests extends BaseTests{
	String originalList[]= {"COFFEE", "TEA", "MENU", "COFFEEHOUSE", "SOCIAL IMPACT", "STARBUCKS REWARDS", "BLOG", "GIFT CARDS"};

	@Test
	public void testStarbucks() { 
		String received[] = {};
		StarbucksHomePage home = getStarbucksHomePage();		
		received = home.menu();
		Assert.assertEquals(received, originalList, "Pasó los Strings");
		//home.secondEx();
		FindCoffeePage coffee = getFindCoffeePage();
		//coffee.secondEx();
		//coffee.dispose();
		GiftCardPage card = getGiftCardPAge();
		//card.thirdEx();
		
	}

	
}
