package com.firstproject.chatapp.dto;
//it is a wrapper class/package which takes data from user and send it to DAO
public class UserDTO {
	
	private String userid;
	private char[] password;
	private String email;
//	private String city;
//	private String number;
	
	public UserDTO(String userid,char[] password,String email) 
	{
	
	this.userid = userid;
	this.password = password;
	this.email = email;
//	this.city = city;
//	this.number = number;

	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getNumber() {
//		return number;
//	}
//
//	public void setNumber(String number) {
//		this.number = number;
//	}
	
}
