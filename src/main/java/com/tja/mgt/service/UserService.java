package com.tja.mgt.service;

import com.tja.mgt.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tja.mgt.dto.*;

public interface UserService extends UserDetailsService {
	
	User save(UserDTO userDTO);
	
	User findUserByEmail(String email);
	
	
	

}
