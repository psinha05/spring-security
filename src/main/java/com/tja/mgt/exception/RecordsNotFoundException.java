package com.tja.mgt.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.*;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordsNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 679559392826326760L;
	
	
	public RecordsNotFoundException(String message) {
		super(message);
	}


}
