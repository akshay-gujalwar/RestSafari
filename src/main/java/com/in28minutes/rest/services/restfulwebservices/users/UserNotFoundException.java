package com.in28minutes.rest.services.restfulwebservices.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundException extends RuntimeException {


	public UserNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
}
