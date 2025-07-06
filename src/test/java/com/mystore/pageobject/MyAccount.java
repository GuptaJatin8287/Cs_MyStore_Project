package com.mystore.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	//Object of webdriver
		WebDriver ldriver;
		
		//Constructor 
		public MyAccount(WebDriver rdriver) {
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		//find Webelements
		@FindBy(xpath = "//a[@title='View my customer account']")
		WebElement name1;
		@FindBy(xpath = "//a[@title='Log me out']")
		WebElement logout;
		@FindBy(id = "search_query_top")
		WebElement searchproduct;
		@FindBy(xpath = "//img[@title='Blouse']")
		WebElement clickonproduct;
		
		public void searchproductandclick(String search) {
			searchproduct.sendKeys(search+Keys.ENTER);
		}
		
		public void clickonproduct() {
			searchproduct.click();
		}
		
		
		public String compareName() {
		String	text = name1.getText();
		return text;
		}
		public void clickonlogout() {
			logout.click();
		}
}


