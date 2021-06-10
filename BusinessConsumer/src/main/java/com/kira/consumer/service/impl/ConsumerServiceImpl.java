package com.kira.consumer.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kira.consumer.dao.ConsumerRepository;
import com.kira.consumer.dto.ConsumerDTO;
import com.kira.consumer.exceptions.KiraGobalException;
import com.kira.consumer.mappers.ConsumerMapper;
import com.kira.consumer.service.ConsumerService;
import com.kira.consumer.utill.UserNameFormate;
import com.kira.consumer.vo.ConsumerVO;

@Service
public class ConsumerServiceImpl implements ConsumerService {
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private ConsumerMapper consumerMapper;
	
	@Autowired
	private UserNameFormate userNameFormate;

	@Override
	public String createConsumer(ConsumerVO vo) {
		ConsumerDTO dto=consumerMapper.convertVO(vo);
		//String userName=userNameFormate.withoutSpace(vo.getfName())+userNameFormate.withoutSpace(vo.getlName())+vo.getAgentId();
		Optional<ConsumerDTO> optDTO=consumerRepository.findByUserId(vo.getUserId());
		if(optDTO.isPresent())
		{
			throw new KiraGobalException("userName already present..!");
		}
		//dto.setUserId(userName);
		consumerRepository.save(dto);
		dto.setPassword("user1");
		return "succefully consumer created...!";
	}

	@Override
	public ConsumerVO getConsumer(Long customerId) {
		Optional<ConsumerDTO> optConsumer=consumerRepository.findByCustomerId(customerId);
		if(!optConsumer.isPresent())
		{
			throw new KiraGobalException("no value present");
		}
		ConsumerVO vo=consumerMapper.convertDTO(optConsumer.get());
		return vo;
	}

	@Override
	public String updateConsumer(ConsumerVO vo) {
		ConsumerDTO dto=consumerMapper.convertVO(vo);
		consumerRepository.save(dto);
		return "succefully consumer updated...!";
	}

}
