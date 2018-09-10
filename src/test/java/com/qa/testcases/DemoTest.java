package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest {

	// trying git from command line
	
	@BeforeSuite
	public void setUpProperties() {
		System.out.println("Before Suite -- Set up properties.");
	}
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Before Test -- Launch Browser");
	}
	
	@BeforeClass
	public void enterURL() {
		System.out.println("Before Class -- Enter URL");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("Before Method -- Login");
	}

	
	@Test
	public void sum() {
		System.out.println("sum test");
		int a = 10;
		int b = 20;
		Assert.assertEquals(30, a+b);
	}
	
	@Test
	public void substract() {
		System.out.println("substract test");
		int a = 10;
		int b = 20;
		Assert.assertEquals(10, b-a);
	}
	
	@Test
	public void division() {
		System.out.println("division test");
		int a = 10;
		int b = 20;
		Assert.assertEquals(2, b/a);
	}
	
	@Test
	public void multiplication() {
		System.out.println("multiplication test");
		int a = 10;
		int b = 20;
		Assert.assertEquals(200, a*b);
	}


	@AfterMethod
	public void logout() {
		System.out.println("After Method -- Logout");
	}
	
	@AfterClass
	public void deleteAllCookies() {
		System.out.println("After Class - Delete All Cookies");
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("After Test -- Close Browser");
	}
	
	@AfterSuite
	public void quitDriver() {
		System.out.println("After Suite -- Quit Driver");
	}
	
}

