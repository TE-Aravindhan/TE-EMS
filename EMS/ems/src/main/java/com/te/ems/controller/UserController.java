package com.te.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.bean.UserInfo;
import com.te.ems.bean.UserResponse;
import com.te.ems.service.UserService;

@RestController
@RequestMapping(path = "/ems")
public class UserController {
	
	@Autowired
	private UserService service;

	@PutMapping(path ="/update")
	public ResponseEntity<UserResponse> update(@RequestBody UserInfo info) {
		UserResponse response = new UserResponse(false, service.toUpdate(info));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	
}
