package com.kira.agent.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class KiraGobalExceptionHandler {
	
	@ExceptionHandler({ KiraGobalException.class })
	public ResponseEntity<ErrorInfo> KiraGobalException(KiraGobalException e ,WebRequest req)
	{
		ErrorInfo info=new ErrorInfo();
		info.setMessage(e.getMessage());
		info.setErrorCode(HttpStatus.NOT_FOUND.value());
		info.setTimestamp(LocalDateTime.now());
		info.setUrlPath(req.getContextPath());
		return new ResponseEntity<>(info,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ErrorInfo> GobalException(Exception e ,WebRequest req)
	{
		ErrorInfo info=new ErrorInfo();
		info.setMessage(e.getMessage());
		info.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		info.setTimestamp(LocalDateTime.now());
		info.setUrlPath(req.getContextPath());
		return new ResponseEntity<>(info,HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
