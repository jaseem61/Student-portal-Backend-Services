package com.springboot.management.authentication;

public class AuthenticationUser {

	private String username;
	private String password;
	
	public AuthenticationUser()
	{
	}

	public AuthenticationUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	
	
	
	
}
