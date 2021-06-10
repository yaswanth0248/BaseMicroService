package com.kira.authorization.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kira.authorization.model.LoginUsersDTO;
import com.kira.authorization.service.JwtUserDetailsService;
import com.kira.authorization.utill.JwtTokenUtil;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * @author YARKB
 *
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	// @Value("${jwt.auth.head}")
	// public static String headerText;

	// public final String headerStr = headerText;
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = requestTokenHeader;
		// final String refreshToken="Bearer "+requestTokenHeader;
// JWT Token is in the form "Bearer token". Remove Bearer word and get
// only the Token
//&& refreshToken.startsWith("Bearer ")
		// jwtToken = requestTokenHeader.substring(7);
		if (requestTokenHeader != null) {
			//

			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String");
		}
// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			LoginUsersDTO userDetails = (LoginUsersDTO) this.jwtUserDetailsService.loadUserByUsername(username);
// if token is valid configure Spring Security to manually set
// authentication
			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
// After setting the Authentication in the context, we specify
// that the current user is authenticated. So it passes the
// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		chain.doFilter(request, response);
	}
}