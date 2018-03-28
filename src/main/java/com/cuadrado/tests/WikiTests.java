package com.cuadrado.tests;

import org.testng.annotations.Test;

import com.cuadrado.pages.ArticlePage;
import com.cuadrado.pages.WikiHomePage;

import junit.framework.Assert;

public class WikiTests extends BaseTests {
	
	@Test
	public void testWikiSearch() {
		WikiHomePage home= getWikiHomePage();
		ArticlePage articlePage = home.buscar("Java");
		Assert.assertEquals(articlePage.getPageTitle(), "Java");
	}
}
