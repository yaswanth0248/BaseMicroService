package com.kira.agent.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ConsumerVO {
	
	private String fName;
	private String lName;
	private Long customerId;
	private String userId;
	private String businessName;
	private String password;
	private String role;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	private String email;
	private Long phoneNo;
	private String panNo;
	private Double businessTurnover;
	private Integer totalEmployees;
	private String agentId;
	private String agentName;
	private String agentUsername;
	private String businessType;
	private String validity;
	private String website;
	private String businessOverview;
	private Integer captialInvested;
	private String businessAge;
	
	
	
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public Double getBusinessTurnover() {
		return businessTurnover;
	}
	public void setBusinessTurnover(Double businessTurnover) {
		this.businessTurnover = businessTurnover;
	}
	public Integer getTotalEmployees() {
		return totalEmployees;
	}
	public void setTotalEmployees(Integer totalEmployees) {
		this.totalEmployees = totalEmployees;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentUsername() {
		return agentUsername;
	}
	public void setAgentUsername(String agentUsername) {
		this.agentUsername = agentUsername;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getBusinessOverview() {
		return businessOverview;
	}
	public void setBusinessOverview(String businessOverview) {
		this.businessOverview = businessOverview;
	}
	public Integer getCaptialInvested() {
		return captialInvested;
	}
	public void setCaptialInvested(Integer captialInvested) {
		this.captialInvested = captialInvested;
	}
	public String getBusinessAge() {
		return businessAge;
	}
	public void setBusinessAge(String businessAge) {
		this.businessAge = businessAge;
	}
	
	
	

}
