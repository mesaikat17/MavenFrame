package Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.*;

public class Helper {

	public void capturescreenshot(WebDriver driver) {
		
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			org.openqa.selenium.io.FileHandler.copy(scr, new File("./Screenshot/Screenshot_"+getCurrentDateTime()+".png"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		}
	
	public static String getCurrentDateTime() {
		
		DateFormat dateformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentdate = new Date();
		
		return dateformat.format(currentdate);
		
			
	}
	
}
