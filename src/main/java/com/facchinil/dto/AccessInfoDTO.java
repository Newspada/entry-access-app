package com.facchinil.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AccessInfoDTO implements DataTransferObject {
	private static final long serialVersionUID = 885922026049859020L;
	
	private String modality;
	private String way;
	private PersonDTO person;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSS")
	private Date deviceDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSS")
	private Date appDate; 
}
