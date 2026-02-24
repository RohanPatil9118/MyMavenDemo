package com.OrangeHRM.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.OrangeHRM.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	
	String url = readconfig.getbaseUrl();
	String browser =readconfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	@BeforeClass
	public void setup()
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();;
			driver =new FirefoxDriver();
			break;

		default:
			driver=null;
			break;
		}
		
		// implicit wait of 20 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// for logger
		
		logger = LogManager.getLogger("OrangeHRM");
		
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		// step : convert webdriver  object to TakesScreenshot interface
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		// step :call getscreenshotAS method to creat img file
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir")+"//ScreenShots//"+testName +".png");
		
		// step 3:copy image file to destination 
		FileUtils.copyFile(src,dest);
	}
}
