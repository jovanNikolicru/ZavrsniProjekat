package tests;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
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

public abstract class BasicTest {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected AuthPage ap;
	protected CartSummaryPage csp;
	protected LocationPopupPage lpp;
	protected LoginPage lp;
	protected MealPage mp;
	protected NotificationSistemPage nsp;
	protected ProfilePage pp;
	protected SearchResultPage srp;
	protected String baseUrl ="http://demo.yo-meals.com/";
	protected String email="customer@dummyid.com";
	protected String password=	"12345678a";	
	
	


	@BeforeMethod
	public  void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
		wait = new WebDriverWait(driver, 15);
		js=(JavascriptExecutor)driver;
		 ap= new AuthPage(driver, wait, js);
		 csp=new CartSummaryPage(driver, wait, js);
		 lpp= new LocationPopupPage(driver, wait, js);
		 lp= new LoginPage(driver, wait, js);
		 mp=new MealPage(driver, wait, js);
		 nsp=new NotificationSistemPage(driver, wait, js);
		 pp= new ProfilePage(driver, wait, js);
		 srp= new SearchResultPage(driver, wait, js);
		 
	}
	

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
	DateTimeFormatter currentTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
	LocalDateTime now = LocalDateTime.now(); 
		
		if(ITestResult.FAILURE==result.getStatus()) {
			 String path="D:\\projekti\\ZavrsniProjekat\\screenshots\\"+currentTime.format(now)+".png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);
				
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				File DestFile=new File(path);
				FileUtils.copyFile(SrcFile, DestFile);
		}
		}
	}
		
		
	

