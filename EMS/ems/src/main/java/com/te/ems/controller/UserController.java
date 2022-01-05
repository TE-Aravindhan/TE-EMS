package com.te.ems.controller;

import javax.validation.Valid;

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
@RequestMapping(path = "/ems")
public class UserController {

	@Autowired(required = false)
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponse> storeData(@Valid @RequestBody UserInfo info){	
		UserResponse response=new UserResponse(false,userService.register(info));	
		return new ResponseEntity<UserResponse>(response,HttpStatus.OK);	
	}
	
	
	
	
}
