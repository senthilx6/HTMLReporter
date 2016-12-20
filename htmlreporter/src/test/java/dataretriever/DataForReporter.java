package dataretriever;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.regexp.recompile;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class DataForReporter {
	ISuite suite;
	XmlSuite xml;

	/**
	 * 
	 * @param suite
	 */
	public DataForReporter(ISuite suite, XmlSuite xml) {
		// TODO Auto-generated constructor stub
		this.suite = suite;
		this.xml = xml;

	}

	public String getSuiteName() {
		return suite.getName();
	}

	public int getNumberOfTestTags() {
		return xml.getTests().size();
	}

	public int getNumberOfTest() {
		return suite.getAllMethods().size();
	}

	public Map<String, String> getTotalTime() {
		Map<String, String> dateValues = new HashMap<String, String>();
		String pattern = "dd-MM-yyyy HH:mm:ss";
		String startTime = new String();
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

	private String totalTimeCaluator(long differnces) {
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

	public int getNumberofTestPassed() {
		int count = 0;
		for (ISuiteResult results : suite.getResults().values()) {
			count += results.getTestContext().getPassedTests().getAllResults()
					.size();
		}
		return count;
	}

	public int getNumberofTestFailed() {
		int count = 0;
		for (ISuiteResult results : suite.getResults().values()) {
			count += results.getTestContext().getFailedTests().getAllResults()
					.size();
		}
		return count;
	}

	public int getNumberofTestSkipped() {
		int count = 0;
		for (ISuiteResult results : suite.getResults().values()) {
			count += results.getTestContext().getSkippedTests().getAllResults()
					.size();
		}
		return count;
	}
}
