package com.springboot.exceptionhandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler (NullPointerException.class)
	public String nullExceptionHandler() {
		
		return "exce_handler";
	}

}
