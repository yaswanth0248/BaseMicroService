package com.kira.authorization.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthonicateService {
	public void singoutuser(HttpServletRequest request, HttpServletResponse response,String token);
	
	}
