package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test (dataProvider="loginpagedata")
	public void CanLogin(String username1, String password1) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		page = PageFactory.initElements(driver, LoginPage.class);
		
		page.loginyatra(username1, password1);
		
		
		
		String url = "https://www.yatra.com/"; 
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(driver.getCurrentUrl(), url, "LOGIN FAILED");
		
		System.out.println("LOGIN PASSED");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
