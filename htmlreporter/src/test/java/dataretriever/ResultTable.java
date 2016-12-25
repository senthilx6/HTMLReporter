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


	/**
	 * 
	 * @param suite
	 */
	private Map<String, ResultVo> generateTableData(ISuite suite) {
		Map<String, ResultVo> dataMap = new HashMap<String, ResultVo>();
		suite.getAllMethods()
				.forEach(
						invokedMethods -> {
							ResultVo value = new ResultVo();
							String methodName = invokedMethods.getMethodName();
							ConstructorOrMethod cons = invokedMethods.getConstructorOrMethod();
							TestCaseInfo caseInfo = cons.getMethod()
									.getAnnotation(TestCaseInfo.class);
							value.setTestCaeId(caseInfo.id());
							value.setMethodName(methodName);
							value.setPrioirty(caseInfo.severity().severity());
							dataMap.put(methodName, value);
						});
		return dataMap;
	}
	
	/**
	 * 
	 * @param suite
	 */
	public Map<String, ResultVo> getEntireTableData(ISuite suite)
	{
		Map<String, ResultVo>	dataMap = 	this.generateTableData(suite);
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
		return dataMap;
	}
}
