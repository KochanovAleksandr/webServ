package com.example.webServ;

import jakarta.validation.constraints.NotNull;



public class Users {
	//int a = 5;
	@NotNull
	private String login;
	@NotNull
	private String password;
	private String date = java.time.LocalDate.now().toString();
	
	
	public Users() {
		
	}
	public Users(String login, String password ) {
		super();
		this.login = login;
		this.password = password;
		
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		
		this.login = login;
	}
	
	public String getPassword () {
		return password;
	}
	
	public void setPassword(String password ) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	@Override
	public String toString() {
		return "{\"login\":\"" + login + "\",\"password\":\"" + password + "\",\"date\":\"" + date + "\"}";
	}

}
