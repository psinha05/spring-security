package com.tja.mgt.service;

import java.util.Arrays;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tja.mgt.dto.UserDTO;
import com.tja.mgt.model.Role;
import com.tja.mgt.model.User;
import com.tja.mgt.repository.UserRepository;
import com.tja.mgt.security.*;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
		
		

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User save(UserDTO userDTO) {
		
		User user = new User(userDTO.getFirstName(), userDTO.getLastName(),
				userDTO.getEmail(),passwordEncoder.encode(userDTO.getPassword()), userDTO.isEnabled(), Arrays.asList(new Role("ROLE_ADMIN")));
		//System.out.println("**********************DATA*****************" + userDTO.getEmail() + "::" + "Roles----->" + userDTO.getRoles());
		return userRepository.save(user);
		
		//Arrays.asList(new Role("ROLE_USER")
		
	}
	
	
	 @Override
	 public User findUserByEmail(String email) {
	  return userRepository.findByEmail(email);
	 }


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		
		System.out.println("******************" + user.getRoles().toString());
		
		if(user == null) {
           throw new UsernameNotFoundException("Invalid UserName or Password");
         }

	return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
	   return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		}
	
}
