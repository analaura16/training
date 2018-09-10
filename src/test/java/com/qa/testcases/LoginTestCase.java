package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
	
	@DataProvider(name="credentials")
	public Object[][] credentialsLogin() {
		
		Object[][] credentials = {{"user1", "pwd1"}, {"user2", "pwd2"}};
		return credentials;
		
	}
	
	
	@Test(dataProvider = "credentials", priority=3)
	public void loginTest(String user, String pwd) {
		homePage = loginPage.login(user, pwd);
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void endTest() {
		
		driver.quit();
		
	}
	
}
