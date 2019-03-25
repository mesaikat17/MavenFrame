package TestCases;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import Pages.LoginPage;
import Utility.BrowserFactory;
import Utility.Configuration;
import Utility.Helper;
import Utility.TestDataExcel;

public class BaseClass {

	public Configuration con;
	public WebDriver driver;
	public TestDataExcel exceldata;
	LoginPage page;
	public Helper help;
	public ExtentReports report;
	public ExtentTest log;
	
	@BeforeSuite
	public void setup() {
		try {
			con = new Configuration();
			exceldata = new TestDataExcel();
			help = new Helper();
			ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Report/Report_"+help.getCurrentDateTime()+".html"));
			report = new ExtentReports();
			report.attachReporter(extent);
			
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@BeforeMethod
	public void startApp() {
		
		driver = BrowserFactory.browser(driver, con.getBrowser(), con.getUrl());
	}
	
	
	@AfterMethod
	public void stop(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			//help.capturescreenshot(driver);
			log.fail("Test FAILED", MediaEntityBuilder.createScreenCaptureFromPath(help.capturescreenshot(driver)).build());
			
			System.out.println("Failure Status Captured and Report Generated"+help.capturescreenshot(driver));
		}
		
		else {
			log.pass("Test PASSED", MediaEntityBuilder.createScreenCaptureFromPath(help.capturescreenshot(driver)).build());
			System.out.println("Pass Status Captured and Report Generated"+help.capturescreenshot(driver));
		}
		report.flush();
		BrowserFactory.stopApp(driver);
	}
	
	
	@DataProvider (name = "loginpagedata")
	public Object[][] rawdata(){
		
		Object [][] data = new Object[2][2];
	
		for(int i=0; i<2; i++) {
		
			data[i][0] = exceldata.getData(i,0);
			data[i][1] = exceldata.getData(i,1);
		}
				
		return data;
	}
	
}
