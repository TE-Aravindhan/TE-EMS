package com.te.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.ems.bean.UserResponse;


@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<UserResponse> methodArgumentNotValidException(MethodArgumentNotValidException exp){
		UserResponse res = new UserResponse(true,exp.getFieldError().getDefaultMessage());
		return new ResponseEntity<UserResponse>(res,HttpStatus.NOT_FOUND);
	}
}
