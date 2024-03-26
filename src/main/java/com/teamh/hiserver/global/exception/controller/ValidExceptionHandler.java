package com.teamh.hiserver.global.exception.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.teamh.hiserver.global.dto.ValidMessageDto;

@RestControllerAdvice
public class ValidExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
       BindingResult result = ex.getBindingResult();
       
       FieldError error = result.getFieldError(); 
       ValidMessageDto validMessages = ValidMessageDto
    		   .builder()
    		   .field(error.getField())
    		   .message(error.getDefaultMessage())
    		   .build();
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validMessages);
   }
}
