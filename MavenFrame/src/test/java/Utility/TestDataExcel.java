package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataExcel {

XSSFWorkbook wb;
XSSFSheet sheet;
	
	public TestDataExcel()  {
		
			try {
				File f = new File("F:\\GitHub\\MavenFrame\\MavenFrame\\MavenFrame\\TestData\\Data.xlsx");
					
				FileInputStream file = new FileInputStream(f);
				
				wb = new XSSFWorkbook(file);
				
				
				sheet = wb.getSheetAt(0);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
	}
	
	public String getData(int row, int cell) {
		
		String data = sheet.getRow(row).getCell(cell).getStringCellValue();
		//System.out.println(data);
		
		return data;
	}
	
}
