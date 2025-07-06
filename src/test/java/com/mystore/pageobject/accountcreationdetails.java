package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountcreationdetails {
	//Object of webdriver
		WebDriver ldriver;
		
		//Constructor 
		public accountcreationdetails(WebDriver rdriver) {
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		//find Webelements
		@FindBy(id ="id_gender1") 
		WebElement gender;
		@FindBy(id = "customer_firstname")
		WebElement firstname1;
		@FindBy(id = "customer_lastname")
		WebElement lastname1;
		@FindBy(id = "passwd")
		WebElement password1;
		@FindBy(id = "submitAccount")
		WebElement register;
		
		
		
		public void clickgender() {
			gender.click();
			}
		
		public void FirstName(String firstname) {
			firstname1.sendKeys(firstname);
		}
		public void LastName(String lastname) {
			lastname1.sendKeys(lastname);
		}
		public void EnterPassword(String password) {
			password1.sendKeys(password);
		}
		public void clickonregister() {
			register.click();
		}
		
		
}
