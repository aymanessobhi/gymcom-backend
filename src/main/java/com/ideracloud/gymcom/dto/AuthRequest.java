package com.ideracloud.gymcom.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;

public class AuthRequest {

	private String email;

	@NotNull @Length(min = 5, max = 50)
	private String username;
	
	@NotNull @Length(min = 5, max = 10)
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
