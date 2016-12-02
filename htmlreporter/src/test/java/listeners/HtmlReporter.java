package listeners;

import java.awt.image.TileObserver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import dataretriever.DataForReporter;

public class HtmlReporter implements IReporter {
/**
 * Data for the reporter
 */
	DataForReporter data = null;
/**
 * Generates the custom reports
 * @param {List<XmlSuite>} xmlSuite
 * @param {List<ISuite>} iSuite
 * @param {String} name
 */
	public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> iSuite,
			String name) {
		BufferedWriter writer = null;
		try {
			ISuite isuite= iSuite.get(0);
		data	 = new DataForReporter(isuite,xmlSuite.get(0));
			isuite.getName();
			writer  = createWriter(name,"test-report.html");
			createHTML(writer);
			endHTML(writer);
			createTitleContent(writer);
			createTotalTest(writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

	/**
	 * 
	 * @param filepath
	 * @return bufferWriter
	 * @throws IOException
	 */
	private BufferedWriter createWriter(String filePath,String fileName) throws IOException {
		String fullPath = filePath+"/"+fileName;
		File file = new File(fullPath);
		boolean exists = new File(filePath).exists();
		if(!exists){
			file.mkdir();
		}
		FileWriter writer = new FileWriter(file);
		BufferedWriter bufferWriter = new BufferedWriter(writer);
		
return bufferWriter;
	}
	
	/**
	 * Used to create the HTML
	 * @param writer
	 * @throws IOException 
	 */
	private void createHTML(BufferedWriter writer) throws IOException
	{
		String startHead ="<html><head></head><body style='background-color: #141F1F;''>" ;
		writer.write(startHead);
	}
	

	/**
	 * Used to finish the HTML
	 * @param writer
	 * @throws IOException 
	 */
	private void endHTML(BufferedWriter writer) throws IOException
	{
		String startHead ="</body></htm>" ;
		writer.write(startHead);
	}

	/**
	 *  writes the title area which contain the name
	 * @param writer
	 * @throws IOException
	 */
private void createTitleContent(BufferedWriter writer) throws IOException
{
	String title = data.getSuiteName();
	String titleTag = "<div style='height: 50px; width: inherit;background-color: #293d3d;'>";
	String label = "<label style='font-weight: bold;position: absolute;padding-left: 16px;color: white;padding-top: 8px;'>"+title+"</label></div>";
	writer.write(titleTag);
writer.write(label);	
}

/**
 * 
 * @param writer
 */
private void createSubContent(BufferedWriter writer){
	
	
}

/**
 * 
 * @param writer
 * @throws IOException 
 */
private void createTotalTest(BufferedWriter writer) throws IOException{
//Creates the layout
	String layout = "<div style ='height: 50px;width: inherit;'>";
	// Creates the child div
	String displayTotalTestLayout = "<div style='width: 260px;background-color: #293d3d;height: 85px;position: absolute;top: 67px;'>";
	
	//Creates Total Test Tag count
	writer.write(layout);
	writer.write(displayTotalTestLayout);
	createTotalTestCase(writer);
	createTotalTestMethod(writer);
	writer.write("</div></div>");
}
/**
 * 
 * @param writer
 * @throws IOException 
 */
private void createTotalTestCase(BufferedWriter writer) throws IOException
{
	String parent = "<label style='margin-top: 8px;position: absolute;'>";
	String content = "<span style='display: inline;color: white;margin-left: 8px;font-weight: bold;'>Total TestCases</span>";
	String total = "<span style='display: inline;color: white;margin-left: 100px;font-weight: bold;'>"+data.getNumberOfTestTags()+"</span></label>";
writer.write(parent+content+total);
}

/**
 * 
 * @param writer
 * @throws IOException 
 */
private void createTotalTestMethod(BufferedWriter writer) throws IOException
{
	String parent = "<label style='position: inherit;top: 57px;'>";
	String content = "<span style='color: white;font-weight: bold;padding-left: 8px;'>Total TestMethod</span>";
	String total = "<span style='margin-left: 83px;color: white;font-weight: bold;''>"+data.getNumberOfTest()+"</span></label>";
writer.write(parent+content+total);
}


}