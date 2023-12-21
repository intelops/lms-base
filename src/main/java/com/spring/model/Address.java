package com.spring.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//@SuppressWarnings("serial")
//@Entity
//@Table(name="address")
public class Address implements Serializable {
//	@Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
//	@Column
	private int city;
	//@Column
	private int country;
	//@Column
	private  String addressline1;
	//@Column
	private String addressline2;
	//@Column
	private String postalCode;
	//@Column
	private  int state;
	//@Column
	private  int userId;
	//@Column
	private  int orgId;
	//@OneToOne(cascade= CascadeType.ALL)
	//@JoinColumn(name = "userId", nullable = false, insertable = false, updatable = false)
	private User user;
	
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}