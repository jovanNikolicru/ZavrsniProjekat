package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.BasicPage;
import pages.LocationPopupPage;

public abstract class BasicTest {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;

	
	
	public BasicTest(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.js = js;
	}
	@BeforeMethod
	public abstract void beforeMethod() ;
	
	

	@AfterMethod
	public abstract void afterMethod() ;
}