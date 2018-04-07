package com.GtplBank.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GtplBank.PageObjects.POLogintest;
import com.GtplBank.Utilities.XLUtils;

//example of datadriven test; reading data from excel using dataprovider 
public class TC_Datadriventest_002 {

	//get username and password from excel
	
	String url = "http://demo.guru99.com/V1/index.php";
	public static WebDriver driver;
		

//test methods

@BeforeMethod //setup to be run before every method..
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C://Selenium Driver//chromedriver.exe");
	driver=new ChromeDriver();
	//system is a pre-defined class and setproperty is a static method
	
}

@Test (dataProvider = "XLdata")
public void loginDDT(String uname, String pwd) { //takes two args as two fields in excel
	
	driver.get(url); //gets url of demo site
	POLogintest object= new POLogintest(driver); //object of POM class
	
	object.setusername(uname); 
	object.setpassword(pwd);
	object.loginbutton();
	
	Assert.assertEquals("GTPL Bank Manager HomePage", driver.getTitle());	
	
}

@DataProvider(name = "XLdata") //DP takes 2dimensional array
public Object [][] getData() throws IOException {//method to read data from excelsheet
	//get path of excel and store
	String filepath =  System.getProperty("user.dir") + "/src/test/java/com/GtplBank/TestData/Testdata.xlsx";

	int rownum = XLUtils.getRowCount(filepath, "Sheet1"); //row from xlutils
	int colcount = XLUtils.getCellCount(filepath, "Sheet1", 1); //col from xlutils
					
	String XLdata [][] = new String[rownum][colcount]; //size of array 	
	//reading data from excel; 	//i (row) starts from 1 as 0 is header, j (col) will start from 0
		for (int i=1; i<rownum; i++) { 
		for (int j=0; j<colcount; j++) {
			
			XLdata [i-1][j] = XLUtils.getCellData(filepath, "Sheet1", i, j);
					//store the values of right hand side in left side and row will be i-1 as we ignored the header
			}
		}
	return XLdata;
}

@AfterTest
public void closebrowser() {
	driver.quit();
	
}

}