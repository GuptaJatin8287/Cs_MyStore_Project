package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.CompleteAddress;
import com.mystore.pageobject.FinalPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.PayementPage;
import com.mystore.pageobject.ProceedAddress;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.ProductSummary;
import com.mystore.pageobject.RegistrationPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.ShippingPage;
import com.mystore.pageobject.indexPage;

public class TC_Product_Page_Test extends BaseClass {
	
	@Test(enabled = false)
	public void testproduct() throws Exception {
	String searchkey ="T-shirts";
	
	logger.info("*************TestCase product search***********************");
		
	indexPage pg = new indexPage(driver);
	pg.clickonSignIn();
	logger.info("Click on sign in");
	RegistrationPage rp = new RegistrationPage(driver);
	logger.info("Entered Email Id");
	rp.registeremail(email);
	logger.info("Entered Password");
	rp.registerpassword("Jatin@123");
	logger.info("Click on Login Button");
	rp.submitloginbutton();
	logger.info("Login Successfull");
	MyAccount ma = new MyAccount(driver);
	ma.searchproductandclick(searchkey);
	
	//Get name of Searched Page
	SearchResultPage srp = new SearchResultPage(driver);
	String result = srp.serachedoutput();
	
	//Verify correct product is displayed or not
	if(result.contains(searchkey)) {
		logger.info("Serach Result Test Case Passed");
		Assert.assertTrue(true);
		ma.clickonlogout();
	}
	else {
		logger.info("Serach Result Test Case Failed");
		captureScreenShot(driver, "testproduct");
		Assert.assertTrue(false);
	}
	
}
	@Test
	public void buyproduct() throws InterruptedException {
		String searchkey ="Blouse";
		
		logger.info("*************TestCase product search***********************");
			
		indexPage pg = new indexPage(driver);
		pg.clickonSignIn();
		logger.info("Click on sign in");
		RegistrationPage rp = new RegistrationPage(driver);
		logger.info("Entered Email Id");
		rp.registeremail(email);
		logger.info("Entered Password");
		rp.registerpassword("Jatin@123");
		logger.info("Click on Login Button");
		rp.submitloginbutton();
		logger.info("Login Successfull");
		MyAccount ma = new MyAccount(driver);
		ma.searchproductandclick(searchkey);
		SearchResultPage srp = new SearchResultPage(driver);
		srp.clickonproduct();
		ProductPage pp = new ProductPage(driver);
		
		pp.selectsize("M");
		pp.clickoncolour();
		Thread.sleep(3000);
		pp.addquantity("2");
		pp.clickonaddtocart();
		pp.clickoncheckout();
		ProductSummary ps = new ProductSummary(driver);
		ps.clickonproceedcheckout();
		CompleteAddress ca = new CompleteAddress(driver);
		ca.enteraddress("E-10/b , India");
		ca.entercity("Delhi");
		ca.enterState("Alaska");
		ca.enterPostalCode("110092");
		ca.enterphonenumber("8287821123");
		ca.entermobilenumber("8287822421");
		ca.saveaddress();
		ProceedAddress pa = new ProceedAddress(driver);
		pa.clickonproceedcheckout();
		ShippingPage sp = new ShippingPage(driver);
		sp.clickonTermandconditions();
		sp.clickonproceed();
		PayementPage ppp = new PayementPage(driver);
		ppp.clickonproceedcheckout();
		FinalPage fp = new FinalPage(driver);
		fp.clickonproceedcheckout();
		
		
	}
}
