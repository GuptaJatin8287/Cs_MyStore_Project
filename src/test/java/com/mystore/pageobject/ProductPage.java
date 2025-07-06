package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	WebDriver ldriver;
	public ProductPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id = "quantity_wanted")
	WebElement quantity1;
	@FindBy(id = "group_1")
	WebElement size1;
	@FindBy(name = "Submit")
	WebElement checkout;
	@FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
	WebElement checkout1;
	@FindBy(id = "color_8")
	WebElement colour;
	
	
	
	
	public void addquantity(String quantity) {
		quantity1.clear();
		quantity1.sendKeys(quantity);
	}
	public void selectsize(String size) {
		Select slt = new Select(size1);
		slt.selectByVisibleText(size);
	}
	public void clickonaddtocart() {
		checkout.click();
	}
	public void clickoncheckout() {
		checkout1.click();
	}
	public void clickoncolour() {
		colour.click();
	}
	

}
