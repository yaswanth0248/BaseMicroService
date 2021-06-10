package com.kira.authorization.model;

import java.io.Serializable;

import com.kira.authorization.dto.ConsumerDTO;

/**
 * @author YARKB
 *
 */
public class JwtUser implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	
	
	

	private String userName;

	private String password;

	private String role;

	private Boolean useStatus;

	private Boolean isEnabled;

	private Boolean isAccoutNonExpired;

	private Boolean isCredentialsNonExpired;

	private Boolean isAccountNonLocked;

	public JwtUser() {
		super();
	}

//String id, String fName, String lName,
	public JwtUser( String userName, String password, String role,
			Boolean useStatus, Boolean isEnabled, Boolean isAccoutNonExpired, Boolean isCredentialsNonExpired,
			Boolean isAccountNonLocked) {
		super();
				 
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.useStatus = useStatus;
		this.isEnabled = isEnabled;
		this.isAccoutNonExpired = isAccoutNonExpired;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
	}






	public JwtUser(ConsumerDTO dto) {
		super();
		 		
		this.userName = dto.getUserId();
		this.password = dto.getPassword();
		this.role = dto.getRole();
		
	}

	


	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Boolean getUseStatus() {
		return useStatus;
	}


	public void setUseStatus(Boolean useStatus) {
		this.useStatus = useStatus;
	}


	public Boolean getIsEnabled() {
		return isEnabled;
	}


	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}


	public Boolean getIsAccoutNonExpired() {
		return isAccoutNonExpired;
	}


	public void setIsAccoutNonExpired(Boolean isAccoutNonExpired) {
		this.isAccoutNonExpired = isAccoutNonExpired;
	}


	public Boolean getIsCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}


	public void setIsCredentialsNonExpired(Boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}


	public Boolean getIsAccountNonLocked() {
		return isAccountNonLocked;
	}


	public void setIsAccountNonLocked(Boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}
	
}
