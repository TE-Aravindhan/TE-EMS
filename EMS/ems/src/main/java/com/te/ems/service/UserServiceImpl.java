package com.te.ems.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ems.bean.UserInfo;
import com.te.ems.customexceptions.InvalidCredentialsException;
import com.te.ems.customexceptions.UserNotFoundException;
import com.te.ems.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public String login(String userName, String password) {
		if (userDao.existsById(userName)) {
			if (userDao.getById(userName).getPassword().equals(password)) {
				return "Login Successfully";
			} else {
				throw new InvalidCredentialsException("Invalid Credentials");
			}
		} else {
			throw new UserNotFoundException("Please Register");
		}
	}

	@Override
	@Transactional
	public Object toUpdate(UserInfo info) {
		if (userDao.existsById(info.getUserName())) {
			UserInfo user = userDao.getById(info.getUserName());
			if (info.getName() != null && !info.getName().isEmpty()) {
				user.setName(info.getName());
			}
			if (info.getAge() != null) {
				user.setAge(info.getAge());
			}
			if (info.getJob() != null && !info.getJob().isEmpty()) {
				user.setJob(info.getJob());
			}
			if (info.getMail() != null && !info.getMail().isEmpty()) {
				user.setMail(info.getMail());
			}
			if (info.getSalary() != null) {
				user.setSalary(info.getSalary());
			}
			if (info.getPassword() != null && !info.getPassword().isEmpty()) {
				user.setPassword(info.getPassword());
			}
			userDao.save(user);
			return "Updated successfully";
		}
		return "Username not found";
	}

	@Override
	public List<UserInfo> getAllDetials() {
		return userDao.findAll();
	}

	@Override
	@Transactional
	public UserInfo register(UserInfo info) {
		return userDao.save(info);
	}

	@Override
	public String toDelete(String userName) {
		if (userName != null) {
			userDao.deleteById(userName);
			return "deleted success";
		}
		throw new UserNotFoundException("data not found");

	}

}
