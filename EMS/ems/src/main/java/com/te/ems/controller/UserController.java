package com.te.ems.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.bean.UserInfo;
import com.te.ems.bean.UserResponse;
import com.te.ems.service.UserService;

@RestController
@RequestMapping(path = "/ems")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/register")
	public ResponseEntity<UserResponse> storeData(@Valid @RequestBody UserInfo info) {
		UserResponse response = new UserResponse(false, userService.register(info));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/login")
	public ResponseEntity<UserResponse> logIn(@RequestBody UserInfo login) {
		UserResponse response = new UserResponse(false, userService.login(login.getUserName(), login.getPassword()));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);

	}

	@PutMapping(path = "/update")
	public ResponseEntity<UserResponse> update(@RequestBody UserInfo info) {
		UserResponse response = new UserResponse(false, userService.toUpdate(info));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/userdetails")
	public ResponseEntity<UserResponse> getAllDetails() {
		UserResponse response = new UserResponse(false, userService.getAllDetials());
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@DeleteMapping(path = "/delete")
	public ResponseEntity<UserResponse> toDelete(@RequestParam String userName) {
		UserResponse response = new UserResponse(false,userService.toDelete(userName));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

}
