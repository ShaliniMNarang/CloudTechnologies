package com.themodestwhite.uploaddownloadfile.entity;

public class User {
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String active;
	
		
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
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
	
	public String getActive() {
		return active;
	}
	
	public void setActive(String active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", active=" + active + "]";
	}
	
	
	
}
