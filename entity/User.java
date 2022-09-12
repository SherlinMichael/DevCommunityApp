package com.example.emp.entity;

import javax.persistence.*;

@Entity
@Table(name="user_details")
public class User{
	@Id
	private String userid;

	private String password;

	private String role;
	
    public User() {
    	
    }
	public User(String userid, String password, String role) {
		this.userid = userid;
		this.password = password;
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
}