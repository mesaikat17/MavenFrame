package Utility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataExcel {

XSSFWorkbook wb;
XSSFSheet sheet;
	
	public TestDataExcel() throws Exception {
		
			File f = new File("./TestData/Data.xlsx");
				
			FileInputStream file = new FileInputStream(f);
			
			wb = new XSSFWorkbook(file);
					
	}
	
	public String getData(int sheetName, int row, int cell ) {
		
		return wb.getSheetAt(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
}
