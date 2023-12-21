package com.spring.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.spring.model.UserDto;

public class AllCourseRequest {
	@Value("null")
public List<Integer> category;
	@Value("null")
public List<Integer> courseType;
	@Value("null")
public List<Integer> level;
	@Value("null")
public List<Integer> publisher;
	@Value("null")
public List<Integer> course;
public String rating=null;
public String searchText=null;
@Value("0")
private int pageNumber;
 @Value("5")
private int pageSize=5;
 
public String getSearchText() {
	return searchText;
}
public void setSearchText(String searchText) {
	this.searchText = searchText;
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
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
public List<Integer> getCategory() {
	return category;
}
public void setCategory(List<Integer> category) {
	this.category = category;
}
public List<Integer> getCourseType() {
	return courseType;
}
public void setCourseType(List<Integer> courseType) {
	this.courseType = courseType;
}
public List<Integer> getLevel() {
	return level;
}
public void setLevel(List<Integer> level) {
	this.level = level;
}
public List<Integer> getPublisher() {
	return publisher;
}
public void setPublisher(List<Integer> publisher) {
	this.publisher = publisher;
}
public List<Integer> getCourse() {
	return course;
}
public void setCourse(List<Integer> course) {
	this.course = course;
}


}
