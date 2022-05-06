package com.facchinil.rest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facchinil.dto.AccessInfoDTO;
import com.facchinil.exception.BadRequestException;
import com.facchinil.manager.AccessInfoManager;
import com.facchinil.request.AccessInfoRequest;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AccessInfoController {
	
	@Autowired
	private AccessInfoManager accessInfoManager;
	
	@PostMapping("/accessInfo")
	public ResponseEntity<AccessInfoDTO> postAccessInfo(
			@RequestBody AccessInfoRequest request){
		if(request == null)
			throw new BadRequestException("Missing request");
		if(StringUtils.isBlank(request.getId()))
			throw new BadRequestException("Missing id");
		AccessInfoDTO accessInfo = accessInfoManager.postAccessInfo(request);
		return new ResponseEntity<>(accessInfo, HttpStatus.CREATED);
	}
	
	@GetMapping("/accessInfo")
	public ResponseEntity<AccessInfoDTO> getAccessInfo(
			@RequestBody AccessInfoRequest request){
		if(request == null)
			throw new BadRequestException("Missing request");
		if(StringUtils.isBlank(request.getId()))
			throw new BadRequestException("Missing id");
		AccessInfoDTO accessInfo = accessInfoManager.getAccessInfo(request);
		return new ResponseEntity<>(accessInfo, HttpStatus.OK);
	}
}