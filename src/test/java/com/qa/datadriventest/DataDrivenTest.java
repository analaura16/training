package com.qa.datadriventest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excel.utility.XlsReader;
import com.qa.base.TestBase;

public class DataDrivenTest extends TestBase {

	public DataDrivenTest() {
		super(); // calls the TestBase constructor
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialize();
		
	}
	
	
	@Test(priority=1, enabled=false)
	public void createAccountTest() {
		
		XlsReader reader = new XlsReader(projectPath + "\\src\\main\\java\\com\\qa\\data\\testData.xlsx");
		String sheetName = "data";
		int rowCount = reader.getRowCount(sheetName);
	
		for (int i = 2; i <= rowCount; i++) {
			
			String firstName = reader.getCellData(sheetName, "firstname", i);
			System.out.println(firstName);
			
			driver.findElement(By.name("firstName")).clear();
			driver.findElement(By.name("firstName")).sendKeys(firstName);
			
			String lastName = reader.getCellData(sheetName, "lastname", i);
			System.out.println(lastName);

			driver.findElement(By.name("lastName")).clear();
			driver.findElement(By.name("lastName")).sendKeys(lastName);;
						
			String userName = reader.getCellData(sheetName, "username", i);
			System.out.println(userName);

			driver.findElement(By.name("Username")).clear();
			driver.findElement(By.name("Username")).sendKeys(userName);
			
			String password = reader.getCellData(sheetName, "password", i);
			System.out.println(password);
			
			driver.findElement(By.name("Passwd")).clear();
			driver.findElement(By.name("Passwd")).sendKeys(password);
			
			driver.findElement(By.name("ConfirmPasswd")).clear();
			driver.findElement(By.name("ConfirmPasswd")).sendKeys(password);
			
		}
		
	}
	

	@Test(priority=2, enabled=true)
	public void printLine() {
		
		System.out.println("Nothing to test");
		
	}
	
	
	@AfterMethod
	public void endTest() {
		
	}
	
	@AfterClass
	public void deleteAllCookies() {
		System.out.println("After Class - Delete All Cookies");
		driver.manage().deleteAllCookies();
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("After Test -- Close Browser");
		driver.close();
	}
	
	@AfterSuite
	public void quitDriver() {
		System.out.println("After Suite -- Quit Driver");
		driver.quit();
	}
	

}
