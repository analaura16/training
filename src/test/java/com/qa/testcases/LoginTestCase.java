package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginTestCase extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTestCase() {
		super(); // calls the TestBase constructor
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title,  "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void endTest() {
		
		driver.quit();
		
	}
	
}
