package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalPage {
	WebDriver ldriver;
	public FinalPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement click1;
	
	public void clickonproceedcheckout() {
		click1.click();
	}

}

