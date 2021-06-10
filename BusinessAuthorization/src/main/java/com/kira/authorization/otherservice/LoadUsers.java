package com.kira.authorization.otherservice;

import com.kira.authorization.model.JwtUser;

/**
 * @author YARKB
 *
 */
public interface LoadUsers {
	public JwtUser getUsers(String userName);
	
}
