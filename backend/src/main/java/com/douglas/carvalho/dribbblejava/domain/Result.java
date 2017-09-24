package com.douglas.carvalho.dribbblejava.domain;

public class Result {
	
	private String message;

	private ResultStatus resultStatus;
	
	public Result() {}
	
	public Result(String message, ResultStatus resultStatus) {
		this.message = message;
		this.resultStatus = resultStatus;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultStatus getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}
	
}
