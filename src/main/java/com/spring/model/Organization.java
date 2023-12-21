package com.spring.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

//@SuppressWarnings("serial")
//@Entity
//@Table(name = "organization")
public class Organization implements Serializable {

   // @Id
   // @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int  id;
   // @Column
    private String name;
   // @Column
    private String type;
  
//@Column
private String phoneNumber;

   // @Column
    private String email;
    //@Column
    private Date registrationDate;
    //@Column
    private String emailOtp;
	//@Column
    private String phonenumberOtp;
	//@Column
    private boolean emailOtpExipry;
	//@Column
    private boolean phonenumberOtpExpiry;

   
    public String getEmailOtp() {
		return emailOtp;
	}

	public void setEmailOtp(String emailOtp) {
		this.emailOtp = emailOtp;
	}

	public String getPhonenumberOtp() {
		return phonenumberOtp;
	}

	public void setPhonenumberOtp(String phonenumberOtp) {
		this.phonenumberOtp = phonenumberOtp;
	}

	public boolean isEmailOtpExipry() {
		return emailOtpExipry;
	}

	public void setEmailOtpExipry(boolean emailOtpExipry) {
		this.emailOtpExipry = emailOtpExipry;
	}

	public boolean isPhonenumberOtpExpiry() {
		return phonenumberOtpExpiry;
	}

	public void setPhonenumberOtpExpiry(boolean phonenumberOtpExpiry) {
		this.phonenumberOtpExpiry = phonenumberOtpExpiry;
	}
  
    public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}  


	public int getId() {
        return id;
    }

    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	

  
  }
