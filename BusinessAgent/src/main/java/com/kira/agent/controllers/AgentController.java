package com.kira.agent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kira.agent.constant.URLS;
import com.kira.agent.service.BusinessAgentService;
import com.kira.agent.vo.BusinessPropertyVO;
import com.kira.agent.vo.ResponseVO;

@CrossOrigin
@RestController
@RequestMapping(URLS.master)
public class AgentController {
	
	@Autowired
	private BusinessAgentService businessAgentService;
	
	@PostMapping(value = URLS.createBusinessProperty, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> creatingProperty(@RequestBody BusinessPropertyVO vo){
		String result=businessAgentService.createProperty(vo);
		ResponseVO response=new ResponseVO();
		response.setStatus(true);
		response.setMessage(result);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(value = URLS.updateBusinessProperty, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> updateProperty(@RequestBody BusinessPropertyVO vo){
		String result=businessAgentService.updateProperty(vo);
		ResponseVO response=new ResponseVO();
		response.setStatus(true);
		response.setMessage(result);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	@GetMapping(value = URLS.viewConsumerProperty, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> getProperty(@RequestParam("propertyId")long propertyId){
		BusinessPropertyVO result=businessAgentService.getProperty(propertyId);
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}

}
