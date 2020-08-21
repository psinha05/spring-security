package com.tja.mgt.dto;

import java.util.Collection;

import com.tja.mgt.model.Role;

public class UserDTO {
	
	private String email; 
	private String firstName;
	private String lastName;
	private String password; 
	private String enabled;

	//added roles for testing purpose
	private Collection<Role> roles;
	
	public UserDTO() {
		
	}
	
	
	public UserDTO(String email, String firstName, String lastName, String password, String enabled, Collection<Role> roles) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String isEnabled() {
		return enabled;
	}


	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	// roles added 

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	

}
