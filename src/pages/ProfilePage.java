package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public WebElement getEmail() {
		return driver.findElement(By.name("user_email"));
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
		return country;
		
	}
	public Select getState() {
		WebElement ElState= driver.findElement(By.name("user_state_id"));
		Select state= new Select(ElState);
		return state;
		
	}
	public Select getCity() {
		WebElement ElCity= driver.findElement(By.name("user_city"));
		Select city= new Select(ElCity);
		return city;
		
	}
	public WebElement getPswdSaveBtn() {
		return driver.findElement(By.xpath("//*[@name= 'changePwdFrm']//*[contains(@class, 'btn--primary')]"));
	}
	public WebElement getProfileSaveBtn() {
		return driver.findElement(By.xpath("//*[@id= 'profileInfoFrmBlock']//*[contains(@class, 'btn--primary')]"));
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
	
}
