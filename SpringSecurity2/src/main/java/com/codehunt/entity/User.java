package com.codehunt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class User {
	@Id
	private String email;
	private String pass;
	private String role;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(String email, String pass, String role) {
		
		this.email = email;
		this.pass = pass;
		this.role = role;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", pass=" + pass + ", role=" + role + "]";
	}
	
	

}
