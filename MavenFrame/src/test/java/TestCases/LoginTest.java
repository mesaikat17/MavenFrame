package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test (dataProvider="loginpagedata")
	public void CanLogin(String username, String password) {
		
		PageFactory.initElements(driver, LoginPage.class);
		
		page.loginyatra(username, password);
	}
	
}
