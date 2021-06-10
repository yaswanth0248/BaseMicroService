package com.kira.consumer.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kira.consumer.dto.ConsumerDTO;
import com.kira.consumer.vo.ConsumerVO;

@Component
public class ConsumerMapper {
	
	public ConsumerDTO convertVO(ConsumerVO vo)
	{
		ConsumerDTO dto=new ConsumerDTO();
		
		dto.setAgentId(vo.getAgentId());
		dto.setAgentName(vo.getAgentName());
		dto.setAgentUsername(vo.getAgentUsername());
		dto.setBusinessAge(vo.getBusinessAge());
		dto.setBusinessName(vo.getBusinessName());
		dto.setBusinessOverview(vo.getBusinessOverview());
		dto.setBusinessTurnover(vo.getBusinessTurnover());
		dto.setBusinessType(vo.getBusinessType());
		dto.setCaptialInvested(vo.getCaptialInvested());
		dto.setCustomerId(vo.getCustomerId());
		dto.setDob(vo.getDob());
		dto.setEmail(vo.getEmail());
		dto.setfName(vo.getfName());
		dto.setlName(vo.getlName());
		dto.setPanNo(vo.getPanNo());
		dto.setPassword(vo.getPassword());
		dto.setPhoneNo(vo.getPhoneNo());
		dto.setRole(vo.getRole());
		dto.setTotalEmployees(vo.getTotalEmployees());
		dto.setUserId(vo.getUserId());
		dto.setValidity(vo.getValidity());
		dto.setWebsite(vo.getWebsite());
		
		
		return dto;
	}
	
	public List<ConsumerDTO> convertVOS(List<ConsumerVO> vos)
	{
		List<ConsumerDTO> dtos=new ArrayList<ConsumerDTO>();
		
		for(ConsumerVO vo:vos)
		{
			ConsumerDTO dto=this.convertVO(vo);
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	public ConsumerVO convertDTO(ConsumerDTO dto) {
		ConsumerVO vo=new ConsumerVO();
		
		vo.setAgentId(dto.getAgentId());
		vo.setAgentName(dto.getAgentName());
		vo.setAgentUsername(dto.getAgentUsername());
		vo.setBusinessAge(dto.getBusinessAge());
		vo.setBusinessName(dto.getBusinessName());
		vo.setBusinessOverview(dto.getBusinessOverview());
		vo.setBusinessTurnover(dto.getBusinessTurnover());
		vo.setBusinessType(dto.getBusinessType());
		vo.setCaptialInvested(dto.getCaptialInvested());
		vo.setCustomerId(dto.getCustomerId());
		vo.setDob(dto.getDob());
		vo.setEmail(dto.getEmail());
		vo.setfName(dto.getfName());
		vo.setlName(dto.getlName());
		vo.setPanNo(dto.getPanNo());
		vo.setPassword(dto.getPassword());
		vo.setPhoneNo(dto.getPhoneNo());
		vo.setRole(dto.getRole());
		vo.setTotalEmployees(dto.getTotalEmployees());
		vo.setUserId(dto.getUserId());
		vo.setValidity(dto.getValidity());
		vo.setWebsite(dto.getWebsite());
		
		
		return vo;
	}
	
	public List<ConsumerVO> convertDTOS(List<ConsumerDTO> dtos) {
		
		List<ConsumerVO> vos=new ArrayList<>();
		
		for(ConsumerDTO dto:dtos)
		{
			ConsumerVO vo=this.convertDTO(dto);
			vos.add(vo);
		}
		
		return vos;
		
	}

}
