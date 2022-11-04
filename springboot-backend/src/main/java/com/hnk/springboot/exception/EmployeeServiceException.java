package com.hnk.springboot.exception;

public class EmployeeServiceException extends Exception {
	
	private final String code;
	
	private final String message;
	
	private final String additionalInfo;
	
	
	public String getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}


	public String getAdditionalInfo() {
		return additionalInfo;
	}


	public EmployeeServiceException(String errorCode, String message) {
		super();
		this.code = errorCode;
		this.message = message;
		this.additionalInfo = null;
	}


	public EmployeeServiceException(String errorCode, String message, String additionalInfo) {
		super();
		this.code = errorCode;
		this.message = message;
		this.additionalInfo = additionalInfo;
	}
	

}
