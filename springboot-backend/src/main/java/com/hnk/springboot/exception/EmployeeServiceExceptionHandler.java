package com.hnk.springboot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeServiceExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceExceptionHandler.class);
	
	@ExceptionHandler(EmployeeServiceException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleException (EmployeeServiceException e) {
		
		ErrorResponse er = new ErrorResponse();
		er.setCode(e.getCode());
		er.setMessage(e.getMessage());
		er.setAdditionalInfo(e.getAdditionalInfo());
		return er;
	}
	

}
