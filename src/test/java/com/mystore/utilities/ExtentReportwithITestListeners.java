package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportwithITestListeners implements ITestListener {
	ExtentSparkReporter htmlreport;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport() {
		String timestamp = new SimpleDateFormat("yyyy.mm.dd hh.mm.ss").format(new Date());
		String reportname = "MystoreTestReport"+timestamp+".html";
		htmlreport = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\"+reportname);
		reports = new ExtentReports();
		reports.attachReporter(htmlreport);
		
		Readconfig readconfig = new Readconfig();
		//Add System Info
		reports.setSystemInfo("Window", "11");
		reports.setSystemInfo("Os", "Window");
		reports.setSystemInfo("Ram", "8");
		reports.setSystemInfo("Storage", "500");
		reports.setSystemInfo("Browser", readconfig.getbrowser());
		
		//Configuration to change look
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setDocumentTitle("Extent demo report");
		htmlreport.config().setReportName("Extent Report");
		
	}
	
	
	//OnStart method call when execution of any test case start
	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println("Test Case Start");
	}
	//onFinished method call after all test cases executed
	public void onFinish(ITestContext Result) {
		System.out.println("Test Case Finish");
		reports.flush();    //mandatory to call flush method to ensure the information is written to the started report
	}
	public void onTestFailure(ITestResult Result) {
		System.out.println("On Test Case Failure :"+ Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case :"+ Result.getName(), ExtentColor.RED));
		
		
		/*String screenshot = System.getProperty("user.dir")+"\\Screenshot\\"+Result.getName()+".png";
		File screenshot1 = new File(screenshot);
		if(screenshot1.exists()) {
			test.fail("Captured Screenshot is below :"+ test.addScreenCaptureFromPath(screenshot));
		*/}
		
		
		//test.addScreenCaptureFromPath("");
	//}
	public void onTestSkipped(ITestResult Result) {
		System.out.println("On Test Skipped" +Result.getName());
		test = reports.createTest(Result.getName()); //create entry on report by using createTest
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped test case :"+ Result.getName(), ExtentColor.YELLOW));
		
	}
	public void onTestStart(ITestResult Result) {
		System.out.println("On Test Start" +Result.getName());
	}
	public void onTestSuccess(ITestResult Result) {
		System.out.println("On Test Success" +Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed test case :"+ Result.getName(), ExtentColor.GREEN));
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		
	}

}
