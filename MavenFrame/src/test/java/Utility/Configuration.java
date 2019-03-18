package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {

	
	Properties pro;
	
	public Configuration() throws Exception {
		
			File f = new File("./Config/Config.properties");
				
			FileInputStream file = new FileInputStream(f);
			
			pro.load(file);
					
	}
	
		public String getBrowser() {
			
		return pro.getProperty("browser");
	}
		
		public String getUrl() {
			
			return pro.getProperty("url");
		}
}
