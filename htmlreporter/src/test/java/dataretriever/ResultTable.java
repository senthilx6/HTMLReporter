package dataretriever;

import java.util.LinkedList;
import java.util.List;





import org.testng.ISuite;


import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.internal.ConstructorOrMethod;

import customannotation.TestCaseInfo;
import vo.ResultVo;

public class ResultTable {

	List<ResultVo> dataList; 
	/**
	 * 
	 * @param suite
	 * @return
	 */
	public List<ResultVo> generateTableData(ISuite suite)
	{
	suite.getAllMethods().stream().forEach(methods->{
		ResultVo value = new ResultVo();
		String methodName = methods.getConstructorOrMethod().getMethod().getName();
		TestCaseInfo caseInfo =  methods.getConstructorOrMethod().getClass().getAnnotation(TestCaseInfo.class);
	value.setTestCaeId(caseInfo.id());
	value.setMethodName(methodName);
	value.setPrioirty(caseInfo.severity().severity());
	});
		return dataList;
	}
/**
 * 	
 * @param suite
 */
	public void generateStartAndEndTime(ISuite suite)
	{
		
		suite.getAllInvokedMethods().stream().forEach(invokedMethods->{
			ResultVo value = new ResultVo();
	ITestNGMethod method =		invokedMethods.getTestResult().getMethod();
	ConstructorOrMethod cons = method.getConstructorOrMethod();
	TestCaseInfo caseInfo =  cons.getClass().getAnnotation(TestCaseInfo.class);
	value.setTestCaeId(caseInfo.id());
	value.setMethodName(method.getMethodName());
	value.setPrioirty(caseInfo.severity().severity());
ITestResult result = invokedMethods.getTestResult();
value.setStartTime(this.convertDate(result.getStartMillis()));
value.setStartTime(this.convertDate(result.getEndMillis()));
	
		});
	}
	
	/**
	 * 
	 * @param milliSeconds
	 * @return
	 */
	private String convertDate(Long milliSeconds)
	{
		String convertedTime = "";
		
		return convertedTime;
	}
}
