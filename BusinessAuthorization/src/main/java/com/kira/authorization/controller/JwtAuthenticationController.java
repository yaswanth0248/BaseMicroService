package com.kira.authorization.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kira.authorization.constant.URLS;
import com.kira.authorization.model.JwtRequest;
import com.kira.authorization.model.JwtResponse;
import com.kira.authorization.model.LoginUsersDTO;
import com.kira.authorization.service.AuthonicateServiceImpl;
import com.kira.authorization.service.JwtUserDetailsService;
import com.kira.authorization.utill.JwtTokenUtil;

/**
 * @author YARKB
 *
 */

@CrossOrigin
@RestController
@RequestMapping(URLS.master)
public class JwtAuthenticationController {

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);

	@Autowired
	private AuthonicateServiceImpl authonicateServiceImpl;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {
	
			final LoginUsersDTO userDetails = (LoginUsersDTO) userDetailsService
					.loadUserByUsername(authenticationRequest.getUserName());
			authonicateServiceImpl.authenticate(authenticationRequest.getUserName(),
					authenticationRequest.getPassword());
			final String token = jwtTokenUtil.generateToken(userDetails);
			JwtResponse result = new JwtResponse(token);
			return new ResponseEntity<>(userDetails,HttpStatus.OK);
		} 
	

	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	public ResponseEntity<?> refreshAndGetAuthToken(@RequestHeader(value = "Authorization") String token,
			HttpServletRequest req, HttpServletResponse res) {
	
			// String token=req.getHeader("Authorization");
			String result = jwtTokenUtil.refreshToken(token);

			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<?> userLogout(HttpServletRequest req, HttpServletResponse res) {
		
			String token = req.getHeader("Authorization");
			authonicateServiceImpl.singoutuser(req, res, token);

			return new ResponseEntity<>("success", HttpStatus.OK);
		}
	

	

}