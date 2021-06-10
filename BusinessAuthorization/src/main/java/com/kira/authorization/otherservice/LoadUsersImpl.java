package com.kira.authorization.otherservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kira.authorization.dao.ConsumerRepository;
import com.kira.authorization.dto.ConsumerDTO;
import com.kira.authorization.model.JwtUser;

/**
 * @author YARKB
 *
 */
@Service
public class LoadUsersImpl implements LoadUsers {

	@Autowired
	private ConsumerRepository customerDAO;



	public JwtUser getUsers(String userName) {
		JwtUser loginDTO = null;
		Optional<ConsumerDTO> genDto = customerDAO.findByUserId(userName);
		if (genDto.isPresent()) {
			loginDTO = new JwtUser(genDto.get());
		}

		return loginDTO;
	}

	
	}