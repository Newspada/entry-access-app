package com.facchinil.dto;

import lombok.Data;

@Data
public class PersonDTO implements DataTransferObject {
	private static final long serialVersionUID = 6956908143744127651L;

	private String id;
	private String fullName;
	private Boolean active;
}
