package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

	@Test
	public void test() {

	}

	@Test
	public void test2() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
