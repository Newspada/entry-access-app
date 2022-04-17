package com.facchinil.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "No person found")
public class PersonNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -5372892236900120307L;

	public PersonNotFoundException() {
		
	 }

	 public PersonNotFoundException(String message) {
        super(message);
    }

}
