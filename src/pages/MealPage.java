package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	
	}
	public WebElement goToMealPage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'right-head')]//li[1]//a"));
	}
	public WebElement getAddToCartBtn() {
		return driver.findElement(By.className("js-proceedtoAddInCart"));
	}
	public WebElement getAddToFavorite() {
		return driver.findElement(By.xpath("//*[contains(@class, 'itemfav')]"));
	}
	public WebElement getMessage() {
		return driver.findElement(By.className("alert--positioned-top-full"));
	}
	public WebElement getQuantity() {
		return driver.findElement(By.className("js-current-product-qty"));
	}
	
	public void addMealToCart(String quantity) {
		this.getQuantity().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		
		this.getQuantity().sendKeys(quantity);
		getAddToCartBtn().click();
	}
	
	
}
