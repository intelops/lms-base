package com.spring.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiResponse {
	private  boolean success;
	private  String message;
	private  int status;
	//private int id=0;
	// try again
	
	

	


	public boolean isSuccess() {
		return success;
	}

	

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ApiResponse() {
		super();
	}

	public ApiResponse(boolean success, String message, int status) {
		super();
		this.success = success;
		this.message = message;
		this.status = status;
	}

	

	

	

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
	
	public String getTimestamp() {
		return LocalDateTime.now().toString();
	}
}
