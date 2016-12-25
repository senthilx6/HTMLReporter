package vo;

public class ResultVo {

	private String methodName;

	private String testCaeId;

	private String StartTime;

	private String EndTime;
	
	private String prioirty;
	
	private String totalTime;
	
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
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
