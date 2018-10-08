package com.polo.rest.polo.exceptions;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler( AccountException.class )
	public void handleAccountException( AccountException exception, HttpServletResponse response ) throws IOException {
		response.sendError( HttpStatus.BAD_REQUEST.value(), exception.getMessage() );
	}
	
	@ExceptionHandler( PaymentException.class )
	public void handlePaymentException( PaymentException exception, HttpServletResponse response ) throws IOException {
		response.sendError( HttpStatus.BAD_REQUEST.value(), exception.getMessage() );
	}
	
}
