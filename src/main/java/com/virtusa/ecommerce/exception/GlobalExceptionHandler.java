package com.virtusa.ecommerce.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);

	
	@ExceptionHandler(UsernameNotFoundException.class)
	public void handleAllUsernameNotFoundException(UsernameNotFoundException ex) {

		LOG.info("----- UsernameNotFoundException  -----" + ex.getMessage());

	}

	@ExceptionHandler(NullPointerException.class)
	public void handleAllNullPointerException(NullPointerException ex) {

		LOG.info("-----NullPointerException-----" + ex.getMessage());

	}

	
	@ExceptionHandler(Exception.class)
	public void handleAllException(Exception ex) {

		LOG.info("----exception -----" + ex.getMessage());

	}
}
