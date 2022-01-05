package com.te.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ems.bean.UserInfo;
import com.te.ems.dao.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired(required = false)
	private UserDao userDao;
	
	@Override
	public UserInfo register(UserInfo info) {
		return userDao.save(info);
	}

}
