package com.spring.dto;
import java.util.List;

public class DropDownData {
public String name;
public List<DataDto> data;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<DataDto> getData() {
	return data;
}
public void setData(List<DataDto> data) {
	this.data = data;
}
public DropDownData(String name, List<DataDto> data) {
	super();
	this.name = name;
	this.data = data;
}
public DropDownData() {
	// TODO Auto-generated constructor stub
}

}
