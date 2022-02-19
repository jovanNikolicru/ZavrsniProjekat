package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage{

	public AuthPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	public WebElement getDropMenu() {
		return driver.findElement(By.xpath("//*[contains(@class, 'user-trigger-js')]"));
		
	}
	public void getMyAcc() {
		getDropMenu().click();
		driver.findElement(By.xpath("//*[contains(@class, 'my-account-dropdown')]//li[1]//a")).click();
	}
	public void logout() {
		getDropMenu().click();
		driver.findElement(By.xpath("//*[contains(@class, 'my-account-dropdown')]//li[2]//a")).click();
	}
	

}
