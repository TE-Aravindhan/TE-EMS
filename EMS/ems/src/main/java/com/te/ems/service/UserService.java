package com.te.ems.service;

import java.util.List;

import com.te.ems.bean.UserInfo;

public interface UserService {
	
	public List<UserInfo> getAllDetials();
  
  public Object toUpdate(UserInfo info);
  
  	public Boolean login(String userName, String password);



}
