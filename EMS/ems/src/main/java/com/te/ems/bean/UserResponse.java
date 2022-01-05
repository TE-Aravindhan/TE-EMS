package com.te.ems.bean;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class UserResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Boolean error;
	
	private Object data;

}
