package com.example.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> optionCountry;
	private String favoriteLanguage;
	private String[] operatingSystems;
	public Student() {
		optionCountry = new LinkedHashMap<>();
		optionCountry.put("BR","Brazil");
		optionCountry.put("FR","Frace");
		optionCountry.put("DE","Germany");
		optionCountry.put("IN","India");
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getCountry() {
		return country;
	}
	public LinkedHashMap<String,String> getOptionCountry(){
		return optionCountry;
	}
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setOptionCountry(LinkedHashMap<String,String> option) {
		this.optionCountry = option;
	}
	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	public void setOperatingSystems(String[] os) {
		this.operatingSystems = os;
	}
}
