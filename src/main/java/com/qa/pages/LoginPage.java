package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - Object Repository (OR) 
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']") //(xpath="//input[@type='submit']")  // /form[@id='loginForm']/div/div
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text()='Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	// Initialize elements in constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String user, String pwd) {
		
		username.clear();
		username.sendKeys(user);
		password.clear();
		password.sendKeys(pwd);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.submit();
		
		return new HomePage();
	}
	
}
