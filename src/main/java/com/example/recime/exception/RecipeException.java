package com.example.recime.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RecipeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3629740422881665353L;

	public RecipeException() {
		super();
	}

	public RecipeException(String message) {
		super(message);
	}
	
	public RecipeException(String message, Throwable cause) {
		super(message, cause);
	}
	public RecipeException(Throwable cause) {
		super(cause);
	}
}
