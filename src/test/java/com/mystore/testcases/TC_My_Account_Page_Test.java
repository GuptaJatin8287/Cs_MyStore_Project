package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.RegistrationPage;
import com.mystore.pageobject.accountcreationdetails;
import com.mystore.pageobject.indexPage;

public class TC_My_Account_Page_Test extends BaseClass {

	@Test(priority = 1)
	public void verifyandRegistration() throws IOException {

		indexPage pg = new indexPage(driver);
		pg.clickonSignIn();
		logger.info("Click on sign in");

		RegistrationPage rp = new RegistrationPage(driver);
		rp.enteremail(email);
		rp.clickoncreateaccount();
		logger.info("Enter enter and click on create account");

		accountcreationdetails acd = new accountcreationdetails(driver);
		logger.info("Enter user details for registration");
		acd.clickgender();
		acd.FirstName(name);
		acd.LastName(last);
		acd.EnterPassword("Jatin@123");
		acd.clickonregister();
		//Logging
		logger.info("Checking the expected username with actual");
		MyAccount account = new MyAccount(driver);
		String username = account.compareName();
		if(username.equals(Fullname)) {
			logger.info("Register Account successfully");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
			captureScreenShot(driver,"verifyandRegistration");

		}



	}
	@Test(priority = 2, enabled = false)
	public void userlogin() throws IOException {
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
		//Logging
		logger.info("Checking the expected username with actual");
		MyAccount account = new MyAccount(driver);
		String username = account.compareName();
		if(username.equals(Fullname)) {
			logger.info("Verify login : Passed");
			Assert.assertTrue(true);
			logger.info("Expected and actual username are match");
		}
		else {
			Assert.assertTrue(false);
			captureScreenShot(driver,"userlogin");
			logger.info("Expected and actual username are not match");
			


		}

		
		//Assert.assertEquals(Fullname, username,"Actual username is not matched with expected");

	}

}
