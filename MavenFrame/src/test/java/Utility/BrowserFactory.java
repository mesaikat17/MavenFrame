package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	static WebDriver driver;

	public static WebDriver browser(WebDriver driver, String browserName, String url) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver1.exe");
			driver = new ChromeDriver();
		}
		
		if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
		
	}
}
