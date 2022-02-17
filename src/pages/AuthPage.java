package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage{

	public AuthPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		// TODO Auto-generated constructor stub
	}
	public Select getDrop() {
		WebElement element= driver.findElement(By.xpath("//*[contains(@class, 'user-trigger-js')]"));
		Select drop= new Select(element);
		return drop;
	}
	public void getMyAcc() {
		getDrop().selectByVisibleText("My Account");
	}
	public void logout() {
		getDrop().selectByVisibleText("Logout");
	}
	

}
