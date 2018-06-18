package com.base.billing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
	
	private HttpStatus status;
	private String errorMessage;
	
	public BadRequestException(String message){
		this.status = HttpStatus.BAD_REQUEST;
		errorMessage = message;
	}

}
