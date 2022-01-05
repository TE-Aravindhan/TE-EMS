package com.te.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.ems.bean.UserResponse;
import com.te.ems.customexceptions.InvalidCredentialsException;
import com.te.ems.customexceptions.UserNotFoundException;

@RestControllerAdvice
public class UserControllerAdvice {
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<UserResponse> login (InvalidCredentialsException exp){
		UserResponse response = new UserResponse(true,exp.getMessage());
		return new ResponseEntity<UserResponse>(response,HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserResponse> userNotFound(UserNotFoundException exp){
		UserResponse response = new UserResponse(true,exp.getMessage());
		return new ResponseEntity<UserResponse>(response,HttpStatus.NOT_FOUND);
	}
}
