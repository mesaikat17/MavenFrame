package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(id="login-input") WebElement uname;
	@FindBy(id="login-continue-btn") WebElement unameButton;
	@FindBy(id="login-password") WebElement pass;
	@FindBy(id="login-submit-btn") WebElement loginButton;
	


public void loginyatra(String username, String password) {
	
	uname.sendKeys(username);
	unameButton.click();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	
	pass.sendKeys(password);
	loginButton.click();
	
}

}