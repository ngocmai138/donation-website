package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.annotation.CourseCode;

public class Customer {
	private String firstName;
	@NotNull()
	@Size(min=1, message="is required")
	private String lastName;
	@Min(value=0, message="must be greater or equal to 0")
	@Max(value = 10, message = "must be less than or equal to 0")
	private int freePasses;
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message="only 5 digits/chars")
	private String postCode;
	@CourseCode(value="LUV", message="must be started with LUV")
	private String courseCode;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}
