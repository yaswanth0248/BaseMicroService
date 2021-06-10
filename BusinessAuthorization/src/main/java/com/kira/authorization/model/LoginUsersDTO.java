package com.kira.authorization.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author YARKB
 *
 */
public class LoginUsersDTO implements UserDetails, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String userName;

	private final String password;

	private final String role;

	private final boolean useStatus;

	private final boolean isEnabled;

	private final boolean isAccoutNonExpired;

	private final boolean isCredentialsNonExpired;

	private final boolean isAccountNonLocked;

//String id, String fName, String lName, 

	public String getUserName() {
		return userName;
	}

	public LoginUsersDTO(String userName, String password, String role, boolean useStatus, boolean isEnabled,
			boolean isAccoutNonExpired, boolean isCredentialsNonExpired, boolean isAccountNonLocked) {
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

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public boolean isUseStatus() {
		return useStatus;
	}

	public boolean isAccoutNonExpired() {
		return isAccoutNonExpired;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	public String getUsername() {

		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {

		return isCredentialsNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return isEnabled;
	}

}
