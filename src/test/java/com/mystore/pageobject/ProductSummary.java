package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSummary {
		WebDriver ldriver;
		public ProductSummary(WebDriver rdriver){
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
		WebElement click1;
		
		public void clickonproceedcheckout() {
			click1.click();
		}
}
