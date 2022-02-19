package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BasicTest {
	
	@Test
	public void searchTest() throws InterruptedException, IOException {
		SoftAssert sa =new SoftAssert();
		driver.navigate().to("http://demo.yo-meals.com/meals");
		driver.manage().window().maximize();
		lpp.closePopup();
		lpp.setLocation("City Center - Albany");
		
		File file= new File("data/Data.xlsx");
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet =wb.getSheet("Meal Search Results");
		
		for(int i =1;i<7;i++) {
			
			String url= sheet.getRow(i).getCell(1).getStringCellValue();
			driver.navigate().to(url);
			lpp.setLocation(sheet.getRow(i).getCell(0).getStringCellValue());
			double actualNoOfResults=srp.searchResultsNumber();
			double noOfResultsInData= sheet.getRow(i).getCell(2).getNumericCellValue();
			
			sa.assertTrue(actualNoOfResults==noOfResultsInData,"Number of search results didn't match");
			
			for(int j=0;j<srp.listOfMeals().size();j++) {
				
				String namesInData=sheet.getRow(i).getCell(3+j).getStringCellValue();
				sa.assertTrue(srp.listOfMeals().get(j).getText().contains(namesInData),"Names not same");
			}
		}
		sa.assertAll();
	}
}
