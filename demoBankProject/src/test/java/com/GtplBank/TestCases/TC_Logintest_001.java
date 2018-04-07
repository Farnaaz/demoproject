package com.GtplBank.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.GtplBank.PageObjects.POLogintest;


public class TC_Logintest_001 {

	//initializing variables and passing the values
	
	String url = "http://demo.guru99.com/V1/index.php";
	String username = "mngr125479";
	String password = "hehaqat";
	public static WebDriver driver;
		

//test methods

@BeforeTest
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C://Selenium Driver//chromedriver.exe");
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