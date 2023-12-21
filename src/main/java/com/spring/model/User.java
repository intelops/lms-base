  package com.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;

import java.util.List;
import java.util.Set;


//@Entity
//@Table(name = "user")
public class User implements Serializable {

  //  @Id
   // @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int  id;
   // @Column
    private String firstname;
   // @Column
    private String lastname;
    // @OneToOne(fetch = FetchType.EAGER,mappedBy="user",cascade = CascadeType.ALL) 
   	private Address address;
    // @OneToMany(fetch = FetchType.EAGER,mappedBy="user",cascade = CascadeType.ALL) 
    	private UserOrganization userorganization;
    //  @Column
    private String experience;
 // @Column
    private String skills;
   // @Column
    private String education;
   // @Column
    private String partnerType;
  
	public UserOrganization getUserOrganization() {
		return userorganization;
	}

	public void setUserOrganization(UserOrganization userOrganization) {
		this.userorganization = userOrganization;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Boolean getEmailOtpExipry() {
		return emailOtpExipry;
	}

	public void setEmailOtpExipry(Boolean emailOtpExipry) {
		this.emailOtpExipry = emailOtpExipry;
	}

	public Boolean getPhonenumberOtpExpiry() {
		return phonenumberOtpExpiry;
	}

	public void setPhonenumberOtpExpiry(Boolean phonenumberOtpExpiry) {
		this.phonenumberOtpExpiry = phonenumberOtpExpiry;
	}

	public Boolean getTermsandconditions() {
		return termsandconditions;
	}
	//@Column
   // @JsonIgnore
    private String password;
  //@Column
//@Size(min = 0, max = 10, message = "Number should have at least 10  digits")
private String phonenumber;
//@Column
private String countryCode;
//@Column
private Boolean termsandconditions;
	//@Column
    private String token;
	//@Column
    private String emailOtp;
	//@Column
    private String phonenumberOtp;
	//@Column
    private Boolean emailOtpExipry;
	//@Column
    private Boolean phonenumberOtpExpiry;
	
    //@Column
   // @Pattern(regexp=".+@.+\\..+", message="Wrong email!")
    private String email;
   // @Column
    private Date registrationDate;
   // @Column
    private Date lastLoginDate;
   // @Column
    private Boolean Enabled;
   // @Column
    private Boolean accountNonLocked;
    
    //@Column
    private Boolean credentialsNonExpired;
    
  //  @Column
    private Boolean accountNonExpired;
    
    public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Boolean isTermsandconditions() {
		return termsandconditions;
	}

	public void setTermsandconditions(Boolean termsandconditions) {
		this.termsandconditions = termsandconditions;
	}
	//@Column
    private String levels;


	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

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

	public String getPhoneNumber() {
		return phonenumber;
	}

	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getId() {
        return id;
    }

    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Boolean getEnabled() {
		return Enabled;
	}

	public void setEnabled(Boolean enabled) {
		Enabled = enabled;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
  }
