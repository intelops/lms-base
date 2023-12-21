package com.spring.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class LmsResponse {
	private  boolean success;
	private  Map<String, Object> response;
	private  Map<String,List<DataDto>> dataList;
	private  List<Map<String, Object>> list;
	private int status;
	public LmsResponse(boolean success, Map<String, Object> response,int status) {
		this.success = success;
		this.response = response;
		this.status=status;
		this.dataList=null;
	}
	
	public LmsResponse() {
		
	}
	public LmsResponse(Map<String,List<DataDto>> dataList,int status) {
		super();
	//	this.success =true;
		//this.message = null;
		this.dataList = dataList;
		this.status=status;
		//this.message1=null;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	public LmsResponse(boolean success,List<Map<String, Object>> list,int status) {
		// TODO Auto-generated constructor stub
		this.success = success;
		this.status=status;
		//this.message = null;
		//this.list = null;
		this.list=list;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isSuccess() {
		return success;
	}

	
	
	
	

	public String getTimestamp() {
		return LocalDateTime.now().toString();
	}
	public Map<String, Object> getResponse() {
		return response;
	}
	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}
	public Map<String, List<DataDto>> getDataList() {
		return dataList;
	}
	public void setDataList(Map<String, List<DataDto>> dataList) {
		this.dataList = dataList;
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
	
	
	
}
