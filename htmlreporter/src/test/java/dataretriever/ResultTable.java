package dataretriever;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.internal.ConstructorOrMethod;

import customannotation.TestCaseInfo;
import vo.ResultVo;
/**
* Data Manipulation class
* @author  Senthil vel
* @version 1.1
* @since   27-11-2016 
*/

public class ResultTable {

	private HashMap<String, ResultVo> dataMap = null;

	private ISuite suite = null;
	
	/**
	 * 
	 * @param suite
	 */
	public ResultTable(ISuite suite) {
		this.suite = suite;
	}

	/**
	 * 
	 * @param suite
	 */
	private void generateTableData() {
		dataMap = new HashMap<String, ResultVo>();
		suite.getAllMethods()
				.forEach(
						invokedMethods -> {
							ResultVo value = new ResultVo();
							String methodName = invokedMethods.getMethodName();
							ConstructorOrMethod cons = invokedMethods.getConstructorOrMethod();
							TestCaseInfo caseInfo = cons.getMethod()
									.getAnnotation(TestCaseInfo.class);
							if(caseInfo !=null){
							value.setTestCaeId(caseInfo.id());
							
							value.setPrioirty(caseInfo.severity().severity());
							}
							else
							{
								value.setTestCaeId("-");
								value.setPrioirty("-");	
							}
							value.setMethodName(methodName);
							dataMap.put(methodName, value);
						});
	}
	
	/**
	 *  Sets the total time and status of the test case
	 * @param suite
	 */
	protected void getEntireTableData()
	{
		this.generateTableData();
		suite.getAllInvokedMethods().stream().forEach(methods->{
			
			if (dataMap.containsKey(methods.getTestMethod().getMethodName()))
			{
				ResultVo vo = dataMap.get(methods.getTestMethod().getMethodName());
				long startMilliSeconds = methods.getTestResult().getStartMillis();
				vo.setStartTime(DataForReporter.totalTimeCaluator(startMilliSeconds));
				long endMilliSeconds = methods.getTestResult().getEndMillis();
				
				
				vo.setEndTime(DataForReporter.totalTimeCaluator(endMilliSeconds));
				result status = null;
				Throwable error =methods.getTestResult().getThrowable();
				if(error!=null)
				{
					vo.setExpectionMessage(this.expectionMessage(error));
				}
				switch(methods.getTestResult().getStatus())
				{
				case ITestResult.SUCCESS:
					status = result.PASS;
					break;
case ITestResult.FAILURE:
					status = result.FAIL;
					break;
case ITestResult.SKIP:
status = result.SKIP;
break;
					
				}
				vo.setResult(status);
	long difference = endMilliSeconds - startMilliSeconds;
	vo.setTotalTime(DataForReporter.totalTimeCaluator(difference));		
			}
		});
	}
	
	/**
	 * gets the result data
	 * @return
	 */
	public  Map<String, ResultVo> getResultData()
	{
		return dataMap;
	}
	
	
	public static enum result{
		PASS("pass"),SKIP("skip"),FAIL("fail");
		
		String status;
		result(String status)
		{
			this.status = status;
		}
		public String  toString()
		{
			return this.status;
		}
		
	}
	/**
	 *  returns the size of the data count
	 * @return
	 */
	public  int getDataCount()
	{
		return dataMap.size();
	}
	
	
	/**
	 * gets the result data based on the sorted result
	 */
	public Map<String, ResultVo> sortBasedOnResult()
	{
	Set<Entry<String, ResultVo>> entrySet = dataMap.entrySet();
	List<Map.Entry<String,ResultVo>> list = new LinkedList<Map.Entry<String,ResultVo>>();
	list.addAll(entrySet);
	Collections.sort(list,new Comparator<Map.Entry<String,ResultVo>>() {

		@Override
		public int compare(Map.Entry<String, ResultVo> firstEntry,
				Map.Entry<String, ResultVo> secondEntry) {
			
			if (firstEntry.getValue().getResult().ordinal() == firstEntry.getValue().getResult().ordinal())
			{
				return 0;
			}
			else if(firstEntry.getValue().getResult().ordinal() > firstEntry.getValue().getResult().ordinal()){
			return -1;
		}
		else
		{
			return 1;
		}
	}});
	Map<String,ResultVo> sortedMap = new LinkedHashMap<String,ResultVo>();
	for(Map.Entry<String, ResultVo> entry : list){
		sortedMap.put(entry.getKey(), entry.getValue());
	}
	return sortedMap;
	}
	
	/**
	 *  does the calculation for the process data
	 */
	public void processData()
	{
		this.getEntireTableData();
	}
	/**
	 * Returns the Expection thrown by the class
	 * @param error
	 * @return
	 */
	private String expectionMessage (Throwable error)
	{ //TODO check the coding Style
		StringWriter writer = new StringWriter();
		PrintWriter printer = new PrintWriter(writer);
		error.printStackTrace(printer);
		String [] splitMessage = writer.toString().split("\n");
	return splitMessage[0]+"\n"+splitMessage[1];
	}
}
