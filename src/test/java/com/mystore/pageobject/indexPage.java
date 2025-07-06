package com.mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	//Object of webdriver
	WebDriver ldriver;
	
	//Constructor 
	public indexPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//find Webelements
	@FindBy(linkText ="Sign in")
	WebElement signin;
	
	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	WebElement tshirt;
	
	
	//Actions on webelements
	public void clickonSignIn() {
		signin.click();
	}
	public void clickonTshirt() {
		tshirt.click();
	}

}
