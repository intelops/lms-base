package com.spring.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
@Entity
@Table(name = "config_master")
public class ConfigMaster implements Serializable {
	
	    @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private int keyId;
	   
	    @Column
	    private String key;
	    @Column
	    private boolean  isActive;
	    
	    @OneToMany(fetch = FetchType.EAGER,mappedBy="configMaster",cascade = CascadeType.ALL)
	   
	    private List<ConfigSlave> configSlave;
	    
		public List<ConfigSlave> getConfigSlave() {
			return configSlave;
		}
		public void setConfigSlave(List<ConfigSlave> configSlave) {
			this.configSlave = configSlave;
		}
		public int getKeyId() {
			return keyId;
		}
		public void setKeyId(int keyId) {
			this.keyId = keyId;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public boolean isActive() {
			return isActive;
		}
		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}
	    
	 
	 
	   
}
