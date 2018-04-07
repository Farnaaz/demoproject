package com.GtplBank.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro; //import properties class from java.utils, and create a reference object


	//create a constructor (samename as class, no return type) to load config.prop file
	public ReadConfig() {

		//to read config.properties file create file class

		File src = new File ("./Configurations/config.properties"); // "./" represents project home directory, an alternate to getProperty
		// file is a class; create object; file class has parameterised constructor so give path of file
		 

		try {
			FileInputStream fis = new FileInputStream(src);
			//fileReader obj = new FileReader(src); then load reader

			//checked and unchecked exceptions: checked exception is compile time exception, example include input/output and file not found exception

			pro = new Properties();//object 

			pro.load(fis); //load method takes reader as args 
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}

	//for every value in config/prop we need to provide a method
	public String getApplicationURL()
	{
		String url=pro.getProperty("url"); //supply the key from config.prop file 
		return url; //every method will return a value
	}

	public String getUsername() //return type string 
	{
		String uname=pro.getProperty("username");
		return uname;
	}

	public String getPassword()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("Chromepath");
		return chromepath;
	}

	public String getIEPath() {
		String iepath = pro.getProperty("IEpath");
		return iepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("Firefoxpath");
		return firefoxpath;
	}


}


