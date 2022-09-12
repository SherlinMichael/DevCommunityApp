package com.example.emp.entity;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "users")
public class User{
	@Id
	private @NotBlank String  userid;

	private @NotBlank String  password;

	private String role;
	private @NotBlank boolean loggedIn;
	
    public User() {
    	
    }
	public User(@NotBlank String userid, @NotBlank String password, String role) {
		this.userid = userid;
		this.password = password;
		this.role = role;
		this.loggedIn = false;
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
	
	public boolean isLoggedIn() {
        return loggedIn;
    }  
	
	public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }  
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userid, user.userid) &&
                Objects.equals(password, user.password);
    }  
	
	@Override
    public int hashCode() {
        return Objects.hash(userid, password, 
                            loggedIn);
    }

	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + 
				", role=" + role +", loggedIn=" + loggedIn + "]";
	}
	
	
	
}
