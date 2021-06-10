package com.kira.agent.service;

import org.springframework.stereotype.Service;

import com.kira.agent.vo.BusinessPropertyVO;

@Service
public interface BusinessAgentService {
	
	public String createProperty(BusinessPropertyVO vo);
	public BusinessPropertyVO getProperty(Long propertyId);
	public String updateProperty(BusinessPropertyVO vo);

}
