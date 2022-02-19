package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.BasicPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;
import pages.SearchResultPage;

public class ProfileTest extends BasicTest {

	@Test
	public void editProfile() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		
		driver.navigate().to("http://demo.yo-meals.com/guest-user/login-form");
		driver.manage().window().maximize();
		lpp.closePopup();
		lp.getUsername().clear();
		lp.getPassword().clear();
		lp.login(email, password);
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Login Successfull"), "Login message did't show up");
		driver.navigate().to("http://demo.yo-meals.com/member/profile");
		pp.clearAllFields();
		pp.getFirstName().sendKeys("Miki");
		pp.getLastName().sendKeys("Mikic");
		pp.getPhone().sendKeys("432414");
		pp.getAddress().sendKeys("Prvomajska 1");
		pp.getZip().sendKeys("12345");
		js.executeScript("arguments[0].scrollIntoView();",pp.getCountry());
		pp.getCountry().selectByVisibleText("India");
		Thread.sleep(500);
		pp.getState().selectByVisibleText("Delhi");
		pp.getCity().selectByVisibleText("Delhi");
	
		js.executeScript("arguments[0].click();",pp.getProfileSaveBtn());
	
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Setup Successful"), "Setup message ditn't show up");
		nsp.waitForMessageToDisappear();
		ap.logout();
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Logout Successfull!"),"Logout message didn't show up");
		}
	@Test
	public void changeProfilePic() throws InterruptedException, IOException {
		driver.navigate().to("http://demo.yo-meals.com/guest-user/login-form");
		driver.manage().window().maximize();
		lpp.closePopup();
		lp.getUsername().clear();
		lp.getPassword().clear();
		lp.login(email, password);
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Login Successfull"), "Login message did't show up");
		driver.navigate().to("http://demo.yo-meals.com/member/profile");
		
		String imgPath = new File("img/profile.png").getCanonicalPath();
		System.out.println(imgPath);
	
		pp.setPic(imgPath);
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Profile Image Uploaded Successfully"),"Upload of profile picture failed");
		nsp.waitForMessageToDisappear();
		pp.getRemoveBtn().click();
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Profile Image Deleted Successfully"),"Removing profile picture failed");
		nsp.waitForMessageToDisappear();
		ap.logout();
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Logout Successfull!"));
	}
	
}
