package com.tja.mgt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class LoginController {
	
	private final Log logger = LogFactory.getLog(LoginController.class);
	

	
	/*
	 * @GetMapping("/login") public String login() {
	 * System.out.println("############loginControllerMethod"); //User user = (User)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * //System.out.println("To print the ROOOOOOOOOOOOOOOLE" + user.getRoles());
	 * return "login"; }
	 */
	
	@GetMapping("/login")
	 public String login() {
	  System.out.println("###################loginMethod");
	  return "login";
	 }
	
	
	  @GetMapping("/")
	  public String index() {
	  System.out.println("@@@@@@@@@@@@@@@@indexControllerMethod");	  
	  return "index";
	  }
	 
	
	
	
}
