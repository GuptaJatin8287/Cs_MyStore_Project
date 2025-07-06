package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.RegistrationPage;
import com.mystore.pageobject.accountcreationdetails;
import com.mystore.pageobject.indexPage;
import com.mystore.utilities.ReadExcelFile;

public class TC_My_Account_Page_Test_Data_Driven extends BaseClass {

	@Test(priority = 1,enabled = false)
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
			account.clickonlogout();
		}
		else {
			Assert.assertTrue(false);
			captureScreenShot(driver,"verifyandRegistration");

		}
		


	}
	@Test(dataProvider = "LoginDataProvider")
	public void userlogin(String email, String password, String username1) throws IOException {
		indexPage pg = new indexPage(driver);
		
		pg.clickonSignIn();
		logger.info("Click on sign in");
		RegistrationPage rp = new RegistrationPage(driver);
		logger.info("Entered Email Id");
		rp.registeremail(email);
		logger.info("Entered Password");
		rp.registerpassword(password);
		logger.info("Click on Login Button");
		rp.submitloginbutton();
		logger.info("Login Successfull");
		//Logging
		logger.info("Checking the expected username with actual");
		MyAccount account = new MyAccount(driver);
		String username = account.compareName();
		if(username.equals(username1)) {
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
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = "D:\\Java_Automation_Project\\mystorev1\\Test Data\\MyStoreData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginData", i,j);
			}

		}
		return data;
	}

}
