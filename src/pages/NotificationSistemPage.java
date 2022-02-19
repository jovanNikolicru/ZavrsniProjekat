package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage{

	public NotificationSistemPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	public WebElement getNotification() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("system_message")));
		return driver.findElement(By.className("system_message"));
	}
	public String getMessageOfNotification() throws InterruptedException {
		Thread.sleep(200);
		return getNotification().getText();
	}
	public void waitForMessageToDisappear() {
		WebElement element= driver.findElement(By.xpath("//*[contains(@class, 'system_message')]"));
		wait.until(ExpectedConditions.attributeToBe(element, "style", "display: none;"));
	}

}
