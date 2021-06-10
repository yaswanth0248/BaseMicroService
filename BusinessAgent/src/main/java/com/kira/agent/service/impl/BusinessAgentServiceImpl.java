package com.kira.agent.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kira.agent.dao.PropertyRepository;
import com.kira.agent.dto.BusinessPropertyDTO;
import com.kira.agent.exceptions.KiraGobalException;
import com.kira.agent.mappers.BusinessPropertyMapper;
import com.kira.agent.service.BusinessAgentService;
import com.kira.agent.vo.BusinessPropertyVO;

@Service
public class BusinessAgentServiceImpl implements BusinessAgentService {
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private BusinessPropertyMapper businessPropertyMapper;

	@Override
	public String createProperty(BusinessPropertyVO vo) {
		
		BusinessPropertyDTO dto=businessPropertyMapper.convertVO(vo);
		propertyRepository.save(dto);
		
		return "succefully created property..!";
	}

	@Override
	public BusinessPropertyVO getProperty(Long propertyId) {
		Optional<BusinessPropertyDTO> optProperty=propertyRepository.findByPropertyId(propertyId);
		if(!optProperty.isPresent())
		{
			throw new KiraGobalException("no value present...!");
		}
		BusinessPropertyVO property=businessPropertyMapper.convertDTO(optProperty.get());
		return property;
	}

	@Override
	public String updateProperty(BusinessPropertyVO vo) {
		BusinessPropertyDTO dto=businessPropertyMapper.convertVO(vo);
		propertyRepository.save(dto);
		return "succefully updated ...!";
	}

}
