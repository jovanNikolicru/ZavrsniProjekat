package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	public List<WebElement> favoriteMeals(){
		return driver.findElements(By.xpath("//*[contains(@class, 'itemfav')]"));
	}
	
	public List<WebElement> listOfMeals(){
		return driver.findElements(By.xpath("//div[contains(@class,'product-name')]//a"));
	}
	
	public int searchResultsNumber() {
		return favoriteMeals().size();
	}

}
