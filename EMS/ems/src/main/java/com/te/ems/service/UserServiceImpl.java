package com.te.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ems.bean.UserInfo;
import com.te.ems.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public List<UserInfo> getAllDetials() {
		return userDao.findAll();
	}
	
	
	

}
