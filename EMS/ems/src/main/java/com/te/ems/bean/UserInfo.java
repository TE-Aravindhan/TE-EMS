package com.te.ems.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;

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

	@NotNull(message = "Name should not be null")
	@NotEmpty(message = "Name should not be empty")
	private String name;
	
	@Id
	@Column(name="user_name")
	@NotNull(message = "username should not be null")
	@NotEmpty(message = "username should not be empty")
	private String userName;
	
	@Min(value = 18 ,message = "age should be above 18")
	@Max(value = 50 ,message = "age should not be greater than 50")
	private Integer age;
	
	@NotNull(message = "job should not be null")
	@NotEmpty(message = "job should not be empty")
	private String job;
	
	private Double salary;
	
	@NotNull(message = "mail should not be null")
	@NotEmpty(message = "mail should not be empty")
	private String mail;
	

	@NotNull(message = "password should not be null")
	@NotEmpty(message = "password should not be empty")
	@JsonIgnore
	private String password;
	

}
