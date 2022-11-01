package com.hnk.springboot.exception;

public class ErrorResponse {
	
	private String Code;
	
	private String message;
	
	private String additionalInfo;

	public String getCode() {
		return Code;
	}

	
	public void setCode(String code) {
		Code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	
	public ErrorResponse() {
		super();
	}
	
	public ErrorResponse(String code, String message) {
		super();
		Code = code;
		this.message = message;
	}

	
	public ErrorResponse(String code, String message, String additionalInfo) {
		super();
		Code = code;
		this.message = message;
		this.additionalInfo = additionalInfo;
	}
	
}
