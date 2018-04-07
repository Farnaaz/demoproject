package com.GtplBank.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POLogintest {
	
	// pageobjects including constructor, elements and methods
	
	public WebDriver localdriver;
	
	//constructor(same as class name, no Returntype) taking webdriver as args
	
	public POLogintest(WebDriver remotedriver) {
				
		localdriver= remotedriver;
		
		PageFactory.initElements (remotedriver, this);  
		
		/* PF supports POM pattern, initElements instantiate all instances of PageObject or its elements.
		If you don't use the PageFactory, then NullPointerExceptions will be thrown.
		*/
		 
		}

	//find elements on webpage
	
	@FindBy(name="uid") WebElement Userid; 

	//@CacheLookup store webelement in temporary cache memory, if cache not used the driver will go and find it on the current page again.
	
	
	@FindBy(name="password")
	@CacheLookup
	WebElement Pwd;
	
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement Loginbtn;
	

	// methods should match the number of elements
	
	public void setusername (String uname) {
		Userid.sendKeys(uname); //webelement.action
	}
	public void setpassword (String pass) {
		Pwd.sendKeys(pass);
	}
	
	public void loginbutton () {
		Loginbtn.click();
	}
	
}
