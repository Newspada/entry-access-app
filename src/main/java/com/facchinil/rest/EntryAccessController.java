package com.facchinil.rest;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facchinil.dto.EntryAccessDTO;
import com.facchinil.exception.BadRequestException;
import com.facchinil.manager.EntryAccessManager;
import com.facchinil.request.EntryAccessRequest;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EntryAccessController {
	
	@Autowired
	private EntryAccessManager entryAccessManager;
	
	@PostMapping
	public ResponseEntity<EntryAccessDTO> postEntryAccess(
			@RequestBody EntryAccessRequest request){
		if(request == null)
			throw new BadRequestException("Missing request");
		if(StringUtils.isBlank(request.getId()))
			throw new BadRequestException("Missing id");
		request.setDeviceEntryDate(toUTC(request.getDeviceEntryDate()));
		EntryAccessDTO entryAccess = entryAccessManager.postEntryAccess(request);
		return new ResponseEntity<>(entryAccess, HttpStatus.CREATED);
	}
	
	private Date toUTC(Date date) {
		return date == null ? null : DateUtils.addHours(date, -2);
	}
}