package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String projectPath;
	
	public TestBase() {
		
		File currentDirectory = new File(".");
		projectPath = currentDirectory.getAbsolutePath();
				
		try {
			
			prop = new Properties();
			FileInputStream fileProp = new FileInputStream(projectPath + "\\src\\main\\java\\com\\qa\\config\\config.properties");
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
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("disable-infobars");  // With chromedriver 2.28, there's an info bar that we don't want to have when browser is launched
			options.addArguments("lang=en");  			
			
			System.setProperty("webdriver.chrome.driver", projectPath + "\\chromedriver.exe");
			driver = new ChromeDriver(options);
			
		} else if (browserName.equals("FF")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\apace\\Documents\\FirefoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("urlGmail"));
		
	}
	
}
