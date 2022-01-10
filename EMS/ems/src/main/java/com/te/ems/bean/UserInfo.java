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
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "user_info")

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Name should not be null")
	@NotEmpty(message = "Name should not be empty")
	@Pattern(regexp = "[a-zA-Z]{3,30}", message = "Please Enter valid Name")
	private String name;

	@Id
	@Column(name = "user_name")
	@NotNull(message = "username should not be null")
	@NotEmpty(message = "username should not be empty")
	@Pattern(regexp = "\r\n"
			+ "^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")
	private String userName;

	@Min(value = 18, message = "age should be above 18")
	@Max(value = 50, message = "age should not be greater than 50")
	private Integer age;

	@NotNull(message = "job should not be null")
	@NotEmpty(message = "job should not be empty")
	private String job;

	private Double salary;

	@NotNull(message = "mail should not be null")
	@NotEmpty(message = "mail should not be empty")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Please Enter valid E-mail")
	private String mail;

	@NotNull(message = "password should not be null")
	@NotEmpty(message = "password should not be empty")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$", message = "Please Enter valid Password")
	@JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
	private String password;

}
