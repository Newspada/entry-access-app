package com.facchinil.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class EntryAccessDTO implements DataTransferObject {
	private static final long serialVersionUID = 885922026049859020L;
	
	@JsonIgnore
	private Long id;
	private String comune;
	private String provincia;
	private String regione;
	private String prefisso;
	private String cap;
}
