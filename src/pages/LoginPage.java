package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	public WebElement getUsername() {
		return driver.findElement(By.name("username"));
	}
	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}
	public WebElement getLoginBtn() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public void login(String email, String password) throws InterruptedException {
		getUsername().sendKeys(email);
		getPassword().sendKeys(password);
		getLoginBtn().click();
		Thread.sleep(1000);
	}
	public WebElement getLoginPage() {
		return driver.findElement(By.xpath("//*[contains(@class,'filled')]//a"));
	}

}
