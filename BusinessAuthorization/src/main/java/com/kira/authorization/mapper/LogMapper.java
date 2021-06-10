package com.kira.authorization.mapper;

import org.springframework.stereotype.Component;

import com.kira.authorization.model.JwtUser;
import com.kira.authorization.model.LoginUsersDTO;

/**
 * @author YARKB
 *
 */
@Component
public class LogMapper{

	public LogMapper() {
		super();
	}

	public static LoginUsersDTO mappers(JwtUser dto) {
		return new LoginUsersDTO( 
								 
				dto.getUserName(),
				dto.getPassword(),
				dto.getRole(),true,true,true,true,true);

	}

	

}
