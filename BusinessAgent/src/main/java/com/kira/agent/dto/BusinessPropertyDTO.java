package com.kira.agent.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "business_property")
public class BusinessPropertyDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="propertyId")
	private Long propertyId;
	
	@Column(name="customerid")
	private Long customerId;
	
	@Column(name="propertytype")
	private String propertyType;
	
	@Column(name="insurancetype")
	private String insuranceType;
	
	@Column(name="bulidingsqft")
	private Integer bulidingSqft;
	
	@Column(name="bulidingtype")
	private Integer bulidingType;
	
	@Column(name="bulidingstoreys")
	private Integer bulidingStoreys;
	
	@Column(name="bulidingage")
	private Integer bulidingAge;
	
	@Column(name="costofasset")
	private Double costOfAsset;
	
	@Column(name="salvagevalue")
	private Double salvageValue;
	
	@Column(name="userfulLifeasset")
	private Integer userFulLifeAsset;
	
	@Column(name="agentid")
	private Integer agentId;
	
	@Column(name="agentname")
	private String agentName;
	
	@Column(name="agentusername")
	private String agentUserName;
	
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public Integer getBulidingSqft() {
		return bulidingSqft;
	}
	public void setBulidingSqft(Integer bulidingSqft) {
		this.bulidingSqft = bulidingSqft;
	}
	public Integer getBulidingType() {
		return bulidingType;
	}
	public void setBulidingType(Integer bulidingType) {
		this.bulidingType = bulidingType;
	}
	public Integer getBulidingStoreys() {
		return bulidingStoreys;
	}
	public void setBulidingStoreys(Integer bulidingStoreys) {
		this.bulidingStoreys = bulidingStoreys;
	}
	public Integer getBulidingAge() {
		return bulidingAge;
	}
	public void setBulidingAge(Integer bulidingAge) {
		this.bulidingAge = bulidingAge;
	}
	public Double getCostOfAsset() {
		return costOfAsset;
	}
	public void setCostOfAsset(Double costOfAsset) {
		this.costOfAsset = costOfAsset;
	}
	public Double getSalvageValue() {
		return salvageValue;
	}
	public void setSalvageValue(Double salvageValue) {
		this.salvageValue = salvageValue;
	}
	public Integer getUserFulLifeAsset() {
		return userFulLifeAsset;
	}
	public void setUserFulLifeAsset(Integer userFulLifeAsset) {
		this.userFulLifeAsset = userFulLifeAsset;
	}
	public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentUserName() {
		return agentUserName;
	}
	public void setAgentUserName(String agentUserName) {
		this.agentUserName = agentUserName;
	}
	

}
