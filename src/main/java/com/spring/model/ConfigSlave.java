package com.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
@Entity
@Table(name = " config_slave")
public class ConfigSlave implements Serializable {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
	 @Column
	    private String keyId;
   
    @Column
    private boolean  isActive;
    @Column
    private String  name;
    
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "keyId",nullable = false, insertable = false, updatable = false)
    private ConfigMaster configMaster;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	
}
