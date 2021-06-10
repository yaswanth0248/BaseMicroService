package com.kira.consumer.controllers;

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

import com.kira.consumer.constant.URLS;
import com.kira.consumer.service.ConsumerService;
import com.kira.consumer.vo.ConsumerVO;
import com.kira.consumer.vo.ResponseVO;

@CrossOrigin
@RestController
@RequestMapping(URLS.master)
public class ConsumerController {
	
	@Autowired	
	private ConsumerService consumerService;
	
	@PostMapping(value = URLS.createConsumerBusiness, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> creatingConsumer(@RequestBody ConsumerVO vo){
		String result=consumerService.createConsumer(vo);
		ResponseVO response=new ResponseVO();
		response.setStatus(true);
		response.setMessage(result);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(value = URLS.updateConsumerBusiness, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> updateConsumer(@RequestBody ConsumerVO vo){
		String result=consumerService.updateConsumer(vo);
		ResponseVO response=new ResponseVO();
		response.setStatus(true);
		response.setMessage(result);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(value = URLS.viewConsumerBusiness, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> consumer(@RequestParam("customerId")long customerId){
		ConsumerVO result=consumerService.getConsumer(customerId);
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}

}
