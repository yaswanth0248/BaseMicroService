package com.kira.authorization.model;

import java.io.Serializable;

/**
 * @author YARKB
 *
 */
public class JwtResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String jwttoken;
	private String userName;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}