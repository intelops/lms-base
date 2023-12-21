package com.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name = "sms")
public class Sms implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String toMobileNumber;
	@Column
	private String fromMobileNumber;
	@Column
	private String text;
	
	@CreationTimestamp
	@Column(columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public String getToMobileNumber() {
		return toMobileNumber;
	}
	public void setToMobileNumber(String toMobileNumber) {
		this.toMobileNumber = toMobileNumber;
	}
	public String getFromMobileNumber() {
		return fromMobileNumber;
	}
	public void setFromMobileNumber(String fromMobileNumber) {
		this.fromMobileNumber = fromMobileNumber;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	


	

}
