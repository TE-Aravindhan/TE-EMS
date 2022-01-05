package com.te.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.bean.UserResponse;
import com.te.ems.service.UserService;

@RestController
@RequestMapping(path = "/ems")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/userdetails")
	public ResponseEntity<UserResponse> getAllDetails(){
		UserResponse response = new UserResponse(userService.getAllDetials(),false);
		return new ResponseEntity<UserResponse>(response,HttpStatus.OK);
	}
	
	

}
