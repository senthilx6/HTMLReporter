package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import customannotation.TestCaseInfo;

//Used to Check the format of the report that is going to be generated

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
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@TestCaseInfo(severity=TestCaseInfo.Severity.LOW, id = "TC-3")
	@Test
	public void accountDetails() {
		try {
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
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@TestCaseInfo(severity=TestCaseInfo.Severity.LOW, id = "TC-5")
	@Test
	public void orderDetails() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
