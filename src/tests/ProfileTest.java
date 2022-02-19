package tests;

import java.io.File;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProfileTest extends BasicTest {

	@Test (priority=0)
	public void editProfile() throws InterruptedException {
		driver.navigate().to("http://demo.yo-meals.com/guest-user/login-form");
		driver.manage().window().maximize();
		lpp.closePopup();
		lp.getUsername().clear();
		lp.getPassword().clear();
		lp.login(email, password);
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Login Successfull"), "[ERROR] Login message did't show up");
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
	
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Setup Successful"), "[ERROR] Setup message ditn't show up");
		nsp.waitForMessageToDisappear();
		ap.logout();
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Logout Successfull!"),"[ERROR] Logout message didn't show up");
		}
	/*@Test (priority=3)
	public void changeProfilePic() throws InterruptedException, IOException {
		driver.navigate().to(baseUrl +"/guest-user/login-form");
		driver.manage().window().maximize();
		lpp.closePopup();
		lp.getUsername().clear();
		lp.getPassword().clear();
		lp.login(email, password);
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Login Successfull"), "[ERROR] Login message did't show up");
		driver.navigate().to(baseUrl +"member/profile");
		
		String imgPath = new File("img/profile.png").getCanonicalPath();
		pp.setPic(imgPath);
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Profile Image Uploaded Successfully"),"[ERROR] Upload of profile picture failed");
		nsp.waitForMessageToDisappear();
		pp.getRemoveBtn().click();
		Thread.sleep(100);
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Profile Image Deleted Successfully"),"[ERROR] Removing profile picture failed");
		nsp.waitForMessageToDisappear();
		ap.logout();
		Assert.assertTrue(nsp.getMessageOfNotification().equals("Logout Successfull!"),"[ERROR] Logout unsuccessful");
	}*/
	
}
