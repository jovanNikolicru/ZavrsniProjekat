package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {

	public CartSummaryPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		// TODO Auto-generated constructor stub
	}
	public WebElement getClearAllBtn() {
		return driver.findElement(By.className("btn--third"));
	}
	public WebElement getOpenCartBtn() {
		return driver.findElement(By.className("js-triger-footer-cart"));
	}
	public void clearCart() {
		js.executeScript("arguments[0].click();", getClearAllBtn());
	}

}
