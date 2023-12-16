package com.example.recime.controller.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.recime.exception.RecipeException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { RecipeException.class })
	protected ResponseEntity<Object> handleRecipeException(Exception ex, WebRequest request) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("message", ex.getMessage());
		return ResponseEntity.status(400).body(errorResponse);
	}

}
