package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {

	WebDriver ldriver;
	public ShippingPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id = "cgv")
	WebElement click1;
	@FindBy(name = "processCarrier")
	WebElement click;
	
	public void clickonTermandconditions() {
		click1.click();
	
}
	public void clickonproceed() {
		click.click();
	
}
}
