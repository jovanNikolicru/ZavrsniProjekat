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
		// TODO Auto-generated constructor stub
	}
	public List<WebElement> searchResults() {
		return  driver.findElements(By.xpath("//*[@class='product-name']/a"));
	}
	public void namesOfMeals() {
		List<WebElement> names= searchResults();
		ArrayList<String> obtainedList = new ArrayList<>(); 
		
		for(WebElement we:names){
		   obtainedList.add(we.getText());
		}
	}
	public int searchResultsNumber() {
		return searchResults().size();
	}

}
