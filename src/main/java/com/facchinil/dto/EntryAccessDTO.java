package com.facchinil.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EntryAccessDTO implements DataTransferObject {
	private static final long serialVersionUID = 885922026049859020L;
	
	private String modality;
	private PersonDTO person;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSS")
	private Date deviceEntryDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSS")
	private Date entryDate; 
}
