package dataretriever;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ISuite;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.internal.ConstructorOrMethod;

import customannotation.TestCaseInfo;
import vo.ResultVo;

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
				String status = null;
				switch(methods.getTestResult().getStatus())
				{
				case ITestResult.SUCCESS:
					status = "pass";
					break;
case ITestResult.FAILURE:
					status = "fail";
					break;
case ITestResult.SKIP:
status = "skip";
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
	
	/**
	 *  returns the size of the data count
	 * @return
	 */
	public  int getDataCount()
	{
		return dataMap.size();
	}
	
	
	/**
	 *  does the calculation for the process data
	 */
	public void processData()
	{
		this.getEntireTableData();
	}
}
