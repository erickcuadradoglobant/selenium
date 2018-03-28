package com.cuadrado.training;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AnnotationTests {
//	@org.testng.annotations.BeforeClass
//	public void beforeClass() {
//		System.out.println("Before class");
//
//	}
//	@AfterClass
//	public void afterClass() {
//		System.out.println("After class");
//
//	}
//	
//	
//	@BeforeTest
//	public void beforeTest() {
//		System.out.println("Before Test");
//	}
//	@AfterTest
//	public void afterTest() {
//		System.out.println("After Test");
//	}
//	
//	
//	
//	@BeforeMethod
//	public void login() {
//		System.out.println("Login to the app");
//	}
//	@AfterMethod
//	public void logout() {
//		System.out.println("Logout from the app");
//	}
	@Parameters({"stringA", "stringB"})
	@Test
	public void testConcat(String a, String b) {
		String resultado = a + b ;
		Assert.assertEquals(resultado, "I love test automation");
	
	}
//	@Test(groups = {"grupo1"})
//	public void testContact() {
//		System.out.println("TEst 1");
//	}
//	@Test(groups = {"grupo2"})
//	public void testCount() {
//		System.out.println("Test 2");
//	}
//	@Test(groups = {"grupo3"})
//	public void testContact2() {
//		System.out.println("TEst 3");
//	}
//	@Test(groups = {"grupo1"})
//	public void testCount2() {
//		System.out.println("Test 4");
//	}
	

}
