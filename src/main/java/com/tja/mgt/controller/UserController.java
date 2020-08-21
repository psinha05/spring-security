package com.tja.mgt.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tja.mgt.dto.UserDTO;

import com.tja.mgt.model.User;
import com.tja.mgt.service.UserService;
import java.security.Principal;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
@RequestMapping("/registration")
public class UserController {
	
	private final Log logger = LogFactory.getLog(UserController.class);
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserDTO userRegistrationDTO() {
		return new UserDTO();
	}
	
	// we have replace the above userRegistrationDTO() by below method necessary changes 
	/*
	 * public String showReg(Model model) {
	 *  model.addAttribute("user", new UserDTO()); 
	 *  return "registration"; }
	 */
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String userRegistration(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result) {
		User existingUser = userService.findUserByEmail(userDTO.getEmail());
		
		if (existingUser!=null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}

		if (result.hasErrors()) {
			return "registration";
		}
		
		userService.save(userDTO);
		return "redirect:/registration?success";

	}
	
	
	
	  @GetMapping(value= {"/home"}) 
	  public ModelAndView home() { 
		  ModelAndView model  = new ModelAndView(); 
		  Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		  User user = userService.findUserByEmail(auth.getName());
	  
	  model.addObject("userName", user.getFirstName() + " " + user.getLastName());
	  model.setViewName("home"); return model; 
	  
	  }
	 
	
	
	@GetMapping(value= {"/access_denied"})
	 public ModelAndView accessDenied() {
	  ModelAndView model = new ModelAndView();
	  model.setViewName("access_denied");
	  return model;
	 }

}
