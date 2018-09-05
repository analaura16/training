package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	static WebDriver driver;
	static Properties prop;
	
	public TestBase() {
		
		try {
			
			prop = new Properties();
			FileInputStream fileProp = new FileInputStream("D:\\Eclipse-projects\\Test\\TestProjectMaven" 
					+ "\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fileProp);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialize() {
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\apace\\Documents\\Chrome driver versions\\chrome driver 2.37");
			driver = new ChromeDriver();
			
		} else if (browserName.equals("FF")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\apace\\Documents\\FirefoxDriver");
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
}