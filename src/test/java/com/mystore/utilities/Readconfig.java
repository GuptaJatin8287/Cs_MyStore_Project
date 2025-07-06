package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class Readconfig {
	Properties property;
	String path="D:\\Java_Automation_Project\\mystorev1\\Configuration\\config.properties";
	
	//Constructor
	public Readconfig(){
		property = new Properties();
		try {
			FileInputStream fis = new FileInputStream(path);
			property.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//methods to read data from .properties file
	public String getbaseurl() {
		String value1= property.getProperty("baseurl");
		if(value1!=null) {
			return value1;
		}
		else {
			throw new RuntimeException("Value is null");
		}
	}
	public String getbrowser() {
		String value2= property.getProperty("browser");
		if(value2!=null) {
			return value2;
		}
		else {
			throw new RuntimeException("Browser Value is null");
		}
		
	}
	public String getemail() {
		String value3= property.getProperty("email");
		if(value3!=null) {
			return value3;
		}
		else {
			throw new RuntimeException("Email Address is null");
		}
		
	}
	public String getusername() {
		String value4= property.getProperty("firstname");
		if(value4!=null) {
			return value4;
		}
		else {
			throw new RuntimeException("First name is null");
		}
		
	}
	public String getlastname() {
		String value5= property.getProperty("lastname");
		if(value5!=null) {
			return value5;
		}
		else {
			throw new RuntimeException("Last name is null");
		}
		
	}

}
