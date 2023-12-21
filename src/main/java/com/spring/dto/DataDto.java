package com.spring.dto;

public class DataDto {
	private int id;
    private String name;
	
	
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
	public DataDto(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public DataDto() {
		super();
	}
	
    
}
