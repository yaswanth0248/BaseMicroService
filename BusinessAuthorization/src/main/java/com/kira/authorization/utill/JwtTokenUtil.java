package com.kira.authorization.utill;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kira.authorization.exceptions.KiraGobalException;
import com.kira.authorization.mapper.LogMapper;
import com.kira.authorization.model.JwtUser;
import com.kira.authorization.model.LoginUsersDTO;
import com.kira.authorization.otherservice.LoadUsers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author YARKB
 *
 */
@Component
public class JwtTokenUtil implements Serializable {
	private static final long serialVersionUID = -2550185165626007488L;

	public static final long JWT_TOKEN_VALIDITY = 7776000;

	private static final String CLAIM_KEY_USERNAME = "sub";
	private static final String CLAIM_KEY_SCOPE = "scope";
	private static final String CLAIM_KEY_CREATED = "created";

	private String secret = "mySecret";

	
	
	@Autowired
	private LoadUsers loadUsers;

//retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		String userName;
		try {

			userName = getClaimFromToken(token, Claims::getSubject);
		} catch (Exception e) {
			userName = null;
		}
		return userName;
	}

	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		Date date;
		try {

			date = getClaimFromToken(token, Claims::getExpiration);
		} catch (Exception e) {
			date = null;
		}
		return date;
	}

	public Date getIssuedDateFromToken(String token) {
		Date date;
		try {

			date = getClaimFromToken(token, Claims::getIssuedAt);
		} catch (Exception e) {
			date = null;
		}

		return date;
	}

	public String getingRole(String token) {
		String role;
		try {
		
			final Claims claims = getAllClaimsFromToken(token);
			role = String.valueOf(claims.get(CLAIM_KEY_SCOPE));
		} catch (Exception e) {
			role = null;
		}
		return role;
	}

	public Date getingCreatedDateFromToken(String token) {
		Date Created;
		try {
			
			final Claims claims = getAllClaimsFromToken(token);
			Created = new Date((long) claims.get(CLAIM_KEY_CREATED));
		} catch (Exception e) {
			Created = null;
		}
		return Created;
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		Claims claims;
		try {
			
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

//check if the token has expired
	private Boolean isTokenExpired(String token) {
		Boolean isvalue;
		try {
			
			final Date expiration = getExpirationDateFromToken(token);
			isvalue = expiration.before(new Date());
		} catch (Exception e) {
			isvalue = Boolean.FALSE;
		}
		return isvalue;
	}

//generate token for user
	public String generateToken(LoginUsersDTO userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
		claims.put(CLAIM_KEY_SCOPE, userDetails.getRole());
		claims.put(CLAIM_KEY_CREATED, new Date());
		String token = doGenerateToken(claims, userDetails.getUsername());
		

		return token;
	}

	private Date generateExpairDate() {

		return new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000);
	}

//while creating the token -
//1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
//2. Sign the JWT using the HS512 algorithm and secret key.
//3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
//   compaction of the JWT to a URL-safe string 
	// .setSubject(subject)
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(generateExpairDate()).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	// setExpiration

	@SuppressWarnings("unused")
	public Boolean blockingGenerateToken(String token) {
		Boolean isgotexpried;
		try {
			
			final Claims claims = getAllClaimsFromToken(token);
			claims.setExpiration(new Date());

		} catch (Exception e) {
			isgotexpried = Boolean.FALSE;
		}
		return isgotexpried = Boolean.TRUE;
	}

//validate token
	public Boolean validateToken(String token, LoginUsersDTO userDetails) {
		
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	// refreshing browser then token
	public String refreshToken(String token) {
		String tokenref;
		try {
			
			final Claims claims = getAllClaimsFromToken(token);
			String userName = getUsernameFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			tokenref = doGenerateToken(claims, userName);
		} catch (Exception e) {
			tokenref = null;
		}

		return tokenref;
	}
	
	public LoginUsersDTO getingUserDetailsFromToken(String token)
	{
		JwtUser jwtUser;
		try {
			String userName=this.getUsernameFromToken(token);
			jwtUser=loadUsers.getUsers(userName);
		}catch (Exception e) {
			jwtUser=null;
		}
		if(jwtUser==null)
		{
			throw new KiraGobalException("no userFound..!");
		}
		return LogMapper.mappers(jwtUser);
	}
}