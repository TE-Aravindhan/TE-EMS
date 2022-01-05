package com.te.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ems.customexceptions.InvalidCredentialsException;
import com.te.ems.customexceptions.UserNotFoundException;
import com.te.ems.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Boolean login(String userName, String password) {
		if(userDao.existsById(userName)) {
			if(userDao.getById(userName).getPassword().equals(password)) {
				return true;
			}else {
				throw new InvalidCredentialsException("Invalid Credentials");
			}
		}else {
			throw new UserNotFoundException("Please Register");
		}
	}
	
	
}
