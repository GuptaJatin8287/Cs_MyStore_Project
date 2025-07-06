package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CompleteAddress {
	//Object of webdriver
		WebDriver ldriver;
		
		//Constructor 
		public CompleteAddress(WebDriver rdriver) {
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		//find Webelements
		@FindBy(id = "address1")
		WebElement address1;
		
		@FindBy(id = "city")
		WebElement city1;
		
		@FindBy(id = "id_state")
		WebElement id_state;
		
		@FindBy(id = "postcode")
		WebElement postcode1;
		
		@FindBy(id = "phone")
		WebElement phone;
		
		@FindBy(id = "phone_mobile")
		WebElement phone_mobile;
		
		@FindBy(id = "submitAddress")
		WebElement submitAddress;
		
	
		
		
		//Actions on webelements
		public void enteraddress(String add) {
			address1.sendKeys(add);
		}
		
		public void entercity(String city) {
			city1.sendKeys(city);
		}
		public void enterState(String State) {
			Select scr = new Select(id_state);
			scr.selectByVisibleText(State);
			
		}
		public void enterPostalCode(String postal) {
			postcode1.sendKeys(postal);
			
		}
		public void enterphonenumber(String phonenum) {
			phone.sendKeys(phonenum);
			
		}
		public void entermobilenumber(String mobilenum) {
		phone_mobile.sendKeys(mobilenum);
			
		}
		
		public void saveaddress() {
			submitAddress.click();;
				
			}
		
		
		

}
