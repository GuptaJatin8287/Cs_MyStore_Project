package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedAddress {
	WebDriver ldriver;
	public ProceedAddress(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name = "processAddress")
	WebElement click1;
	
	public void clickonproceedcheckout() {
		click1.click();
	}
}
