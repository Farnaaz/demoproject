package com.GtplBank.TestCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.GtplBank.PageObjects.POLogintest;
import com.GtplBank.Utilities.ReadConfig;

public class TC_ReadConfig_004 {

	ReadConfig readconfig = new ReadConfig();

	//the object will call method from the Readconfig utilities file 

	String url = readconfig.getApplicationURL();
	String username = readconfig.getUsername();
	String password = readconfig.getPassword();
	public static WebDriver driver;


	//test methods

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver=new ChromeDriver();

	}

	@Test
	public void login() {

		driver.get(url); //gets url of demo site
		POLogintest object= new POLogintest(driver);

		object.setusername(username);
		object.setpassword(password);
		object.loginbutton();

		Assert.assertEquals("GTPL Bank Manager HomePage", driver.getTitle());	

	}

	@AfterTest
	public void closebrowser() {
		driver.quit();

	}

}


