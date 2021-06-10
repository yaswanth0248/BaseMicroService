package com.kira.agent.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kira.agent.dto.BusinessPropertyDTO;
import com.kira.agent.vo.BusinessPropertyVO;

@Component
public class BusinessPropertyMapper {
	
	public BusinessPropertyDTO convertVO(BusinessPropertyVO vo)
	{
		BusinessPropertyDTO dto=new BusinessPropertyDTO();
		
		dto.setAgentId(vo.getAgentId());
		dto.setAgentName(vo.getAgentUserName());
		dto.setAgentUserName(vo.getAgentUserName());
		dto.setBulidingAge(vo.getBulidingAge());
		dto.setBulidingSqft(vo.getBulidingSqft());
		dto.setBulidingStoreys(vo.getBulidingStoreys());
		dto.setBulidingType(vo.getBulidingType());
		dto.setCostOfAsset(vo.getCostOfAsset());
		dto.setCustomerId(vo.getCustomerId());
		dto.setInsuranceType(vo.getInsuranceType());
		dto.setPropertyId(vo.getPropertyId());
		dto.setPropertyType(vo.getPropertyType());
		dto.setSalvageValue(vo.getSalvageValue());
		dto.setUserFulLifeAsset(vo.getUserFulLifeAsset());
		
		return dto;
	}
	
	
	public List<BusinessPropertyDTO> convertVOS(List<BusinessPropertyVO> vos)
	{
		List<BusinessPropertyDTO> listDTOS=new ArrayList<>();
		
		for(BusinessPropertyVO vo:vos)
		{
			BusinessPropertyDTO dto=this.convertVO(vo);
			listDTOS.add(dto);
		}
			
		return listDTOS;
	}
	
	public BusinessPropertyVO convertDTO(BusinessPropertyDTO dto)
	{
		BusinessPropertyVO vo=new BusinessPropertyVO();
		
		vo.setAgentId(dto.getAgentId());
		vo.setAgentName(dto.getAgentUserName());
		vo.setAgentUserName(dto.getAgentUserName());
		vo.setBulidingAge(dto.getBulidingAge());
		vo.setBulidingSqft(dto.getBulidingSqft());
		vo.setBulidingStoreys(dto.getBulidingStoreys());
		vo.setBulidingType(dto.getBulidingType());
		vo.setCostOfAsset(dto.getCostOfAsset());
		vo.setCustomerId(dto.getCustomerId());
		vo.setInsuranceType(dto.getInsuranceType());
		vo.setPropertyId(dto.getPropertyId());
		vo.setPropertyType(dto.getPropertyType());
		vo.setSalvageValue(dto.getSalvageValue());
		vo.setUserFulLifeAsset(dto.getUserFulLifeAsset());
		
		return vo;
		
	}
	
	public List<BusinessPropertyVO> convertDTOS(List<BusinessPropertyDTO> dtos)
	{
		List<BusinessPropertyVO> vos=new ArrayList<>();
		
		for(BusinessPropertyDTO dto:dtos)
		{
			BusinessPropertyVO vo=this.convertDTO(dto);
			vos.add(vo);
		}
		
		return vos;
	
	}

}
