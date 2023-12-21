package com.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//@SuppressWarnings("serial")
//@Entity
//@Table(name="userorganization")
public class UserOrganization implements Serializable {
	//@Id
  //  @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

  //  @Column
    private int userId;
  
   // @Column
    private int organizationId;
   // @ManyToOne(cascade= CascadeType.ALL)
  // 	@JoinColumn(name = "organizationId", nullable = false, insertable = false, updatable = false)
   	private Organization organization;
  //  @ManyToOne(cascade= CascadeType.ALL)
   //	@JoinColumn(name = "userId", nullable = false, insertable = false, updatable = false)
   	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
    


}