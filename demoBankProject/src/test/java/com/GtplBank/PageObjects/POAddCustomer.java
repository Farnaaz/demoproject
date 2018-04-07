package com.GtplBank.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class POAddCustomer {

	// pageobjects including constructor, elements and methods
	
	//constructor with driver as args
	public WebDriver localdriver;
	
	public POAddCustomer(WebDriver rdriver){
		localdriver=rdriver;
		PageFactory.initElements (rdriver, this);  //initElements instantiate all instances of PageObject
						
	}
	
	//find elements on webpage
	
	
	// a method for each element
	
}
