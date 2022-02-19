package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	public WebElement getFirstName() {
		return driver.findElement(By.name("user_first_name"));
	}
	public WebElement getLastName() {
		return driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getAddress() {
		return driver.findElement(By.name("user_address"));
	}
	public WebElement getPhone() {
		return driver.findElement(By.name("user_phone"));
	}
	public WebElement getZip() {
		return driver.findElement(By.name("user_zip"));
	}
	public Select getCountry() {
		WebElement ElCountry= driver.findElement(By.name("user_country_id"));
		Select country= new Select(ElCountry);
		wait.until(ExpectedConditions.elementToBeClickable(ElCountry));
		return country;
		
	}
	public Select getState() {
		WebElement ElState= driver.findElement(By.id("user_state_id"));
		
		Select state= new Select(ElState);
		wait.until(ExpectedConditions.elementToBeClickable(ElState));
		
		return state;
		
	}
	public Select getCity() {
		WebElement ElCity= driver.findElement(By.name("user_city"));
		
		
		Select city= new Select(ElCity);
		wait.until(ExpectedConditions.elementToBeClickable(ElCity));
		return city;
		
	}
	public WebElement getPswdSaveBtn() {
		return driver.findElement(By.xpath("//*[@name= 'changePwdFrm']//*[contains(@class, 'btn--primary')]"));
	}
	public WebElement getProfileSaveBtn() {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id= 'profileInfoFrmBlock']//*[@name= 'btn_submit']")));
		return driver.findElement(By.xpath("//*[@id= 'profileInfoFrmBlock']//*[@name= 'btn_submit']"));
	}
	public WebElement getCurrentPswd() {
		return driver.findElement(By.name("current_password"));
	}
	public WebElement getNewPswd() {
		return driver.findElement(By.name("new_password"));
	}
	public WebElement getConfirmPswd() {
		return driver.findElement(By.name("conf_new_password"));
	}
	public WebElement getPicField() {
		return driver.findElement(By.className("avatar"));
	}
	public WebElement getUploadBtn() {
		Actions action = new Actions(driver);
		action.moveToElement(getPicField()).perform();
		return driver.findElement(By.xpath("//*[contains(@class, 'upload')]"));
	}
	public WebElement getRemoveBtn() {
		Actions action = new Actions(driver);
		action.moveToElement(getPicField()).perform();
		return driver.findElement(By.xpath("//*[contains(@class, 'remove')]"));
	}
	public void setPic(String imgPath) throws InterruptedException {
		js.executeScript("arguments[0].click();", getUploadBtn());
		WebElement upload= driver.findElement(By.xpath("//input[@type='file']"));
		
		upload.sendKeys(imgPath);
	}
	public void clearAllFields() {
		getFirstName().clear();
		wait.until(ExpectedConditions.elementToBeClickable(getFirstName()));
		getLastName().clear();
		wait.until(ExpectedConditions.elementToBeClickable(getLastName()));
		getPhone().clear();
		wait.until(ExpectedConditions.elementToBeClickable(getPhone()));
		getAddress().clear();
		wait.until(ExpectedConditions.elementToBeClickable(getAddress()));
		getZip().clear();
		wait.until(ExpectedConditions.elementToBeClickable(getZip()));
	}
	
	
}
