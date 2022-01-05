package com.te.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.bean.UserInfo;
import com.te.ems.bean.UserResponse;
import com.te.ems.service.UserService;

@RestController
@RequestMapping(path="/ems")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	public ResponseEntity<UserResponse> logIn(@RequestBody UserInfo login){
		UserResponse response = new UserResponse(false,userService.login(login.getUserName(),login.getPassword()));
		return new ResponseEntity<UserResponse> (response,HttpStatus.OK);
				
	}
	
	
}
