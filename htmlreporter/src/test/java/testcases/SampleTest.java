package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import customannotation.TestCaseInfo;

/**
* Sample test class used to check the format of the test report
* @author  Senthil vel
* @version 1.0
* @since   27-11-2016 
*/
public class SampleTest {

	@BeforeSuite
	public void beforeSuit() {

	}

	@BeforeClass
	public void beforeClass() {

	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@TestCaseInfo(severity=TestCaseInfo.Severity.LOW, id = "TC-1")
	@Test
	public void login() {
		try {
		//	WebDriver driver = new FirefoxDriver();
	
			//  Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			   // String browserName = cap.getBrowserName().toLowerCase();
			    //System.out.println(browserName);
			//driver.get("https://www.ubuntu.com/");
			System.out.println(System.getProperties().keySet());
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@TestCaseInfo(severity=TestCaseInfo.Severity.LOW, id = "TC-2")
	@Test
	public void signUp() {
		try {
			Integer c =null;
			int sum = c+7;
			Thread.sleep(5000);
		} catch (InterruptedException  e) {
			// TODO Auto-generated catch block

		}
	}
	
	@TestCaseInfo(severity=TestCaseInfo.Severity.LOW, id = "TC-3")
	@Test
	public void accountDetails() {
		try {
			Integer c =null;
			int sum = c+7;
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@TestCaseInfo(severity=TestCaseInfo.Severity.LOW, id = "TC-4")
	@Test
	public void paymentDetails() {
		try {
			Thread.sleep(100000);
			Integer c =null;
			int sum = c+7;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@TestCaseInfo(severity=TestCaseInfo.Severity.LOW, id = "TC-5")
	@Test
	public void orderDetails() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@TestCaseInfo(severity=TestCaseInfo.Severity.LOW, id = "TC-6")
	@Test
	public void orderDetails1() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
