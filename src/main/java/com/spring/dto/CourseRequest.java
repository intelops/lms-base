package com.spring.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

public class CourseRequest {
	
	@Value("0")
private int category;
	@Value("0")
private int subCategory;
	@Value("0")
private int course;
	@Value("0")
private int branchId;
	@Value("0")
	private int country;
	@Value("0")
private int institute;
	@Value("0")
private int level;
	@Value("0")
private int duration;
	@Value("0")
private int price;
	@Value("0")
private int pageNumber;
	@Value("0")
	private int batchId;
	@Value("null")
	private String role;
	 @Value("5")
private int pageSize=5;
private int type ;
private String searchText ;
@Value("0")
private int courseTopic;
private String rating=null;
//private List<category> categoryList;
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public int getBranchId() {
	return branchId;
}
public void setBranchId(int branchId) {
	this.branchId = branchId;
}
public int getCourseTopic() {
	return courseTopic;
}
public void setCourseTopic(int courseTopic) {
	this.courseTopic = courseTopic;
}
public String getSearchText() {
	return searchText;
}
public void setSearchText(String searchText) {
	this.searchText = searchText;
}



public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getCountry() {
	return country;
}
public void setCountry(int country) {
	this.country = country;
}
public int getBatchId() {
	return batchId;
}
public void setBatchId(int batchId) {
	this.batchId = batchId;
}
public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
}
public int getSubCategory() {
	return subCategory;
}
public void setSubCategory(int subCategory) {
	this.subCategory = subCategory;
}
public int getCourse() {
	return course;
}
public void setCourse(int course) {
	this.course = course;
}
public int getInstitute() {
	return institute;
}
public void setInstitute(int institute) {
	this.institute = institute;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getPageNumber() {
	return pageNumber;
}
public void setPageNumber(int pageNumber) {
	this.pageNumber = pageNumber;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}




}
