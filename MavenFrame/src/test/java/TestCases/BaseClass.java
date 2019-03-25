package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

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
	
	@BeforeSuite
	public void setup() {
		try {
			con = new Configuration();
			exceldata = new TestDataExcel();
			help = new Helper();
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
	public void stop(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			help.capturescreenshot(driver);
			System.out.println("Failure Status Captured");
		}
		
		else {
			help.capturescreenshot(driver);
			System.out.println("Pass Status Captured");
		}
		
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
