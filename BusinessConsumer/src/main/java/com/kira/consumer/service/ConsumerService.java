package com.kira.consumer.service;

import org.springframework.stereotype.Service;

import com.kira.consumer.vo.ConsumerVO;

@Service
public interface ConsumerService {
	
	public String createConsumer(ConsumerVO vo);
	public ConsumerVO getConsumer(Long customerId);
	public String updateConsumer(ConsumerVO vo);

}
