package com.facchinil.request;

import java.util.Date;

import com.facchinil.dto.DataTransferObject;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryAccessRequest implements DataTransferObject {
	private static final long serialVersionUID = 885922026049859020L;
	
	private String modality;
	private String id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSS")
	private Date deviceEntryDate;
}
