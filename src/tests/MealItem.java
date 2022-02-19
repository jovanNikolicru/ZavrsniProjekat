package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItem extends BasicTest {

	@Test
	public void addMealToCart() throws InterruptedException {
		driver.navigate().to("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		driver.manage().window().maximize();
		lpp.closePopup();
		mp.addMealToCart("3");
		Assert.assertTrue(nsp.getMessageOfNotification().contains("Please Select Location"),"Message did't show up");
		nsp.waitForMessageToDisappear();
		
		lpp.setLocation("City Center - Albany");
		mp.addMealToCart("3");
		Assert.assertTrue(nsp.getMessageOfNotification().contains("Meal Added To Cart"),"Message did't show up");
	}
	@Test
	public void addMealToFavorite() throws InterruptedException, IOException {
		SoftAssert sa =new SoftAssert();
		driver.navigate().to("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		driver.manage().window().maximize();
		lpp.closePopup();
		mp.getAddToFavorite().click();
		sa.assertTrue(nsp.getMessageOfNotification().contains("Please login first"),"Message didn't show up");
		lp.getLoginPage().click();
		
		lp.getUsername().clear();
		lp.getPassword().clear();
		lp.login(email, password);
		nsp.waitForMessageToDisappear();
		driver.navigate().to("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		mp.getAddToFavorite().click();
		sa.assertTrue(nsp.getMessageOfNotification().contains("has been added to your favorites"),"Message didn't show up");
		sa.assertAll();
	}
	@Test
	public void clearCart() throws InterruptedException, IOException {
		SoftAssert sa =new SoftAssert();
		driver.navigate().to("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		driver.manage().window().maximize();
		lpp.closePopup();
		
		
		lpp.setLocation("City Center - Albany");
		File file= new File("data/Data.xlsx");
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet =wb.getSheet("Meals");
		for(int i =1; i<6;i++) {
			String url= sheet.getRow(i).getCell(0).getStringCellValue();
			driver.navigate().to(url);
			mp.addMealToCart(""+i);
			sa.assertTrue(nsp.getMessageOfNotification().contains("Meal Added To Cart"));
		}
		csp.clearCart();
		sa.assertTrue(nsp.getMessageOfNotification().contains("removed from Cart"));
		
		sa.assertAll();
		
	}
}

