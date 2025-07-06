package com.mystore.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class RegistrationPage {
	
	//object of webdriver
	WebDriver ldriver;
	
	
	//Constructor
 	public RegistrationPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//Find web elements
	@FindBy(id = "email_create")
	WebElement email_add;
	@FindBy(id = "SubmitCreate")
	WebElement submit;
	@FindBy(id = "email")
	WebElement email1;
	@FindBy(id = "passwd")
	WebElement password;
	@FindBy(id = "SubmitLogin")
	WebElement submitlogin;
	
	public void enteremail(String email) {
		email_add.sendKeys(email);
	}
	public void clickoncreateaccount() {
		submit.click();
	}
	public void registeremail(String email2) {
		email1.sendKeys(email2);
	}
	public void registerpassword(String pass) {
		password.sendKeys(pass);
	}
	public void submitloginbutton() {
		submitlogin.click();
	}
}
