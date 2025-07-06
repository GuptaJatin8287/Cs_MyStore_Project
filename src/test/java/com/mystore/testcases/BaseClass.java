package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.mystore.utilities.Readconfig;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	Readconfig config = new Readconfig();
	String url = config.getbaseurl();
	String browser = config.getbrowser();
	String name = config.getusername();
	String last = config.getlastname();
	String email = config.getemail();
	String Fullname = name+" " +last;

	@BeforeMethod
	public void Setup() {
		switch (browser.toLowerCase()) {
		case "chrome": 
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "msedge":
			driver = new EdgeDriver();
			break;
		}

		//Implicit wait of 10 sec
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		//for logging
		logger = LogManager.getLogger("mystorev1");

		//open url
		driver.get(url);

		//Logging
		logger.info("Url Open");




	}
	//user method to capture screen shot
		public void captureScreenShot(WebDriver driver,String testName) throws IOException
		{
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		}
@AfterMethod
	public void quit() {
		driver.close();
		driver.quit();
	}

}
