package dataretriever;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;

import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteResult;

import org.testng.xml.XmlSuite;

public class DataForReporter {
	ISuite suite;
	XmlSuite xml;

	/**
	 * Constructor
	 * 
	 * @param suite
	 */
	public DataForReporter(ISuite suite, XmlSuite xml) {
		// TODO Auto-generated constructor stub
		this.suite = suite;
		this.xml = xml;

	}

	/**
	 * Gets the suite name
	 * 
	 * @return name
	 */
	public String getSuiteName() {
		return suite.getName();
	}

	/**
	 * Gets the number of test tags present in the suite
	 * 
	 * @return count
	 */
	public int getNumberOfTestTags() {
		return xml.getTests().size();
	}

	/**
	 * Gets the number of test
	 * 
	 * @return count
	 */
	public int getNumberOfTest() {
		return suite.getAllMethods().size();
	}

	/**
	 * Get the total number of time taken for the test to get complete
	 * 
	 * @return count
	 */
	public Map<String, String> getTotalTime() {
		Map<String, String> dateValues = new HashMap<String, String>();
		String pattern = "dd-MM-yyyy HH:mm:ss";
		Date startDate = null;
		Date endDate = null;
		SimpleDateFormat format = new SimpleDateFormat(pattern);

		for (ISuiteResult result : suite.getResults().values()) {
			startDate = result.getTestContext().getStartDate();
			endDate = result.getTestContext().getEndDate();

		}

		long differnces = endDate.getTime() - startDate.getTime();
		System.out.println(differnces);
		totalTimeCaluator(differnces);
		dateValues.put("start-time", format.format(startDate));
		dateValues.put("end-time", format.format(endDate));
		dateValues.put("total-time", totalTimeCaluator(differnces));
		return dateValues;

	}

	/**
	 * Convert the milliseconds to time in format of HH:MM:SS
	 * 
	 * @return time
	 */
	protected static String totalTimeCaluator(long differnces) {
		long diffSeconds = differnces / 1000 % 60;
		long diffMinutes = differnces / (60 * 1000) % 60;
		long diffHours = differnces / (60 * 60 * 1000) % 24;
		long diffDays = differnces / (24 * 60 * 60 * 1000);
		String total = "";
		if (diffDays > 0) {
			total += diffDays + " days";
		}
		if (diffHours > 0) {
			total += diffHours + " hours";
		}
		if (diffMinutes > 0) {
			total += diffMinutes + " min";
		}
		if (diffSeconds > 0) {
			total += diffSeconds + " secs";
		}
		return total;
	}

	/**
	 * Gets the number of methods that falls into PASS category
	 * 
	 * @return count
	 */
	public int getNumberofTestPassed() {
		int count = 0;
		for (ISuiteResult results : suite.getResults().values()) {
			count += results.getTestContext().getPassedTests().getAllResults()
					.size();
		}
		return count;
	}

	/**
	 * Gets the number of methods that falls into FAIL category
	 * 
	 * @return count
	 */
	public int getNumberofTestFailed() {
		int count = 0;
		for (ISuiteResult results : suite.getResults().values()) {
			count += results.getTestContext().getFailedTests().getAllResults()
					.size();
		}
		return count;
	}

	/**
	 * Gets the number of methods that falls into SKIP category
	 * 
	 * @return count
	 */
	public int getNumberofTestSkipped() {
		int count = 0;
		for (ISuiteResult results : suite.getResults().values()) {
			count += results.getTestContext().getSkippedTests().getAllResults()
					.size();
		}
		return count;
	}
}
