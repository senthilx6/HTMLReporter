package dataretriever;

import org.testng.ISuite;
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
	
	public String getSuiteName()
	{
		return suite.getName();
	}
	
	public int getNumberOfTestTags()
	{
		return xml.getTests().size();
	}
	
	public int getNumberOfTest()
	{
		return suite.getAllMethods().size();
	}
}
