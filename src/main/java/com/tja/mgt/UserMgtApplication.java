package com.tja.mgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SpringBootApplication
public class UserMgtApplication {
	
	private final Log logger = LogFactory.getLog(UserMgtApplication.class);

	public static void main(String[] args) {		
		SpringApplication.run(UserMgtApplication.class, args);
	}

}
