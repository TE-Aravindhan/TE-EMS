package com.te.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.ems.bean.UserInfo;

public interface UserDao extends JpaRepository<UserInfo, String>{


}
