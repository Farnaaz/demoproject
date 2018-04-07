package com.GtplBank.TestCases;
	import org.apache.log4j.Logger;
	import org.apache.log4j.PropertyConfigurator;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.GtplBank.PageObjects.POLogintest;

	//After program  runs successfully, logs file are created in project home directory.
	public class TC_LogstoTC_003 {


	//initializing variables and passing the values
		
		String url = "http://demo.guru99.com/V1/index.php";
		String username = "mngr125479";
		String password = "hehaqat";
		public static WebDriver driver;
		
		public static Logger logger; //import logger class and create object 

	//test methods

	@BeforeTest
	public void setup() {
		
		logger = Logger.getLogger("TC_LogstoTC_003"); 
		//initialise logger object with class name; .classextension 
		
		//this is process of configurating logger; 
		PropertyConfigurator.configure ("Log4j.properties");//path of log4j
		System.setProperty("webdriver.chrome.driver", "C://Selenium Driver//chromedriver.exe");
		driver=new ChromeDriver();
		
	}

	@Test
	public void login() {
		
		driver.get(url); //gets url of demo site
		logger.info ("URL is opened"); //logger.info to start giving customised logs 
		POLogintest object= new POLogintest(driver);
		logger.info ("Setting the username");
		object.setusername(username);
		logger.info ("Setting the password");
		object.setpassword(password);
		
		object.loginbutton();
		
		logger.info ("Clicked on submit");
		
		Assert.assertEquals("GTPL Bank Manager HomePage", driver.getTitle());	
		
		logger.info ("Validation is done");
	}

	@AfterTest
	public void closebrowser() {
		driver.quit();
		logger.info ("driver closed");
	}

	}

