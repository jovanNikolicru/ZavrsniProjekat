package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		// TODO Auto-generated constructor stub
	}

	public WebElement getLocationBtnHeader() {
		return driver.findElement(By.xpath("//*[contains (@class, 'location-selector')]/a"));
	}
	public WebElement getClosePopupBtn() {
		return driver.findElement(By.className("close-btn"));
	}
	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword'"));
	}
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	public void openPopupLocation() {
		getLocationBtnHeader().click();
	}
	public void setLocation(String locationName) {
		getKeyword().click();
		String value =getLocationItem(locationName).getText();
		js.executeScript("arguments[0].value=arguments[1]", getKeyword(),value);
		js.executeScript("arguments[0].click();", getSubmit());
	}
	public void closePopup() {
		getClosePopupBtn().click();
	}

}
