package Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper {

	public String capturescreenshot(WebDriver driver) {
		
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshot = System.getProperty("user.dir")+"Screenshot_"+ getCurrentDateTime()+".jpg";
		
		try {
			org.openqa.selenium.io.FileHandler.copy(scr, new File(screenshot));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return screenshot;
		}
	
	public static String getCurrentDateTime() {
		
		DateFormat dateformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentdate = new Date();
		
		return dateformat.format(currentdate);
		
			
	}
	
}
