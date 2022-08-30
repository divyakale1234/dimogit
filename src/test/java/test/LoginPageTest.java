package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parametrization;
import utility.Reports;
@Listeners(utility.Listeners.class)
public class LoginPageTest extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void addreports() {
	  reports = Reports.generateReports();
	}
     // WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser()
	{
		driver =LaunchBrowser.chromeBrowser();
	}
	
	@Test
	public void ZerodhaLoginTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		test = reports.createTest("ZerodhaLoginTest");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String user = Parametrization.getData("Credentials", 0, 1);
		String pass = Parametrization.getData("Credentials", 1, 1);
		String pin = Parametrization.getData("Credentials", 2, 1);
		zerodhaLoginPage.enterUserName(user);
		zerodhaLoginPage.enterPassWord(pass);
		zerodhaLoginPage.clickOnSubmit();
		Thread.sleep(1000);
		
		zerodhaLoginPage.enterPin(pin, driver);
		zerodhaLoginPage.clickOnContinue();
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void ValidateZerodhaForgotLink() throws InterruptedException {
		test= reports.createTest("validateZerodhaForgotLink");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnForgot();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("(//form//label[2]")).click();
		
	}
	@AfterMethod 
	public void postTest(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if (result.getStatus() ==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName());
		}
		
	}
	@AfterTest
	public void flushReport()
	{
		reports.flush();
	}
}




