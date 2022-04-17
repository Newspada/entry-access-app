package com.facchinil.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class PersonNotAllowedException extends RuntimeException {
	private static final long serialVersionUID = -5372892236900120307L;

	public PersonNotAllowedException() {
		
	 }

	 public PersonNotAllowedException(String message) {
        super(message);
    }

}
