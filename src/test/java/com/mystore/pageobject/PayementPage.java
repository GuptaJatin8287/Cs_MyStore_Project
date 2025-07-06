package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayementPage {
	WebDriver ldriver;
	public PayementPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//a[@class='cheque']")
	WebElement click1;
	
	public void clickonproceedcheckout() {
		click1.click();
	
}
}
