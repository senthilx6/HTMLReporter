package vo;
/**
* Value object class used to set and get data for the report
* @author  Senthil vel
* @version 1.0
* @since   27-11-2016 
*/
public class ResultVo {

	private String methodName;

	private String testCaeId;

	private String StartTime;

	private String EndTime;
	
	private String prioirty;
	
	private String totalTime;
	
	private dataretriever.ResultTable.result result;

	public dataretriever.ResultTable.result getResult() {
		return result;
	}

	public void setResult(dataretriever.ResultTable.result result) {
		this.result = result;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public String getPrioirty() {
		return prioirty;
	}

	public void setPrioirty(String prioirty) {
		this.prioirty = prioirty;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getTestCaeId() {
		return testCaeId;
	}

	public void setTestCaeId(String testCaeId) {
		this.testCaeId = testCaeId;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
}
