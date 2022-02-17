package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BasicPage;
import pages.LocationPopupPage;
import pages.LoginPage;

public class ProfileTest extends BasicTest {

	public ProfileTest(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}

	@Override
	public void beforeMethod() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterMethod() {
		// TODO Auto-generated method stub
		
	}
	

}
