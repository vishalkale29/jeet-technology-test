package com.to;

import java.sql.Blob;

public class UserData {
	
	private String Username;
	private String Emailid;
	private Blob password;
	
	
	
	//-------------------------
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmailid() {
		return Emailid;
	}
	public void setEmailid(String emailid) {
		Emailid = emailid;
	}
	public Blob getPassword() {
		return password;
	}
	public void setPassword(Blob password) {
		this.password = password;
	}
	
	
	
	
	

}
