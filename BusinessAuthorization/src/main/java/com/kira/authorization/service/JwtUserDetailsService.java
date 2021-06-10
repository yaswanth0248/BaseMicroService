package com.kira.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kira.authorization.exceptions.KiraGobalException;
import com.kira.authorization.mapper.LogMapper;
import com.kira.authorization.model.JwtUser;
import com.kira.authorization.otherservice.LoadUsers;

/**
 * @author YARKB
 *
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private LoadUsers loadUsers;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		JwtUser dto = loadUsers.getUsers(username);
		if (dto == null) {
			throw new KiraGobalException("no user found..!");
		}

		return LogMapper.mappers(dto);
	}

	
}