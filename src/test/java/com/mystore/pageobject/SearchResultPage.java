package com.mystore.pageobject;


import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver ldriver;
	//Actions act = new Actions(ldriver);
	//JavascriptExecutor js =(JavascriptExecutor)ldriver;
	public SearchResultPage(WebDriver rdriver) {
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//img[@title='Blouse']")
	WebElement searchoutput;
	@FindBy(css = "img[title='Blouse']")
	WebElement clickonproduct;
	@FindBy(xpath = "//span[normalize-space()='More']")
	WebElement more;
	
	public String serachedoutput() {
		return searchoutput.getText();
	}
	public void clickonproduct() {
		//act.moveToElement(clickonproduct).doubleClick().perform();
		//js.executeScript("agruments[0].scrollIntoView();",clickonproduct);
		clickonproduct.click();
	}
	
	
	
}
