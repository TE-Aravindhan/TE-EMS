package com.te.ems.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="user_info")
public class UserInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	@Id
	@Column(name="user_name")
	private String userName;
	
	private Integer age;
	
	private String job;
	
	private Double salary;
	
	private String mail;
	
	@JsonIgnore
	private String password;
	
}
