package com.facchinil.manager.main;

import java.util.Date;

import javax.transaction.Transactional;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.EntryAccessDTO;
import com.facchinil.dto.PersonDTO;
import com.facchinil.entity.EntryAccess;
import com.facchinil.entity.Person;
import com.facchinil.exception.PersonNotAllowedException;
import com.facchinil.exception.PersonNotFoundException;
import com.facchinil.manager.EntryAccessManager;
import com.facchinil.mapper.main.EntryAccessMapper;
import com.facchinil.mapper.main.PersonMapper;
import com.facchinil.repository.EntryAccessRepository;
import com.facchinil.repository.PersonRepository;
import com.facchinil.request.EntryAccessRequest;

@Component
public class EntryAccessManagerMain implements EntryAccessManager {

	@Autowired
	private EntryAccessRepository entryAccessRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private EntryAccessMapper entryAccessMapper;
	
	@Autowired
	private PersonMapper personMapper;
	
	@Override
	@Transactional
	public EntryAccessDTO postEntryAccess(EntryAccessRequest request) {
		PersonDTO personDTO = validatePerson(request.getId());
		EntryAccessDTO dto = new EntryAccessDTO();
		dto.setModality(request.getModality());
		dto.setDeviceEntryDate(request.getDeviceEntryDate());
		dto.setEntryDate(new Date());
		dto.setPerson(personDTO);
		EntryAccess entity = entryAccessRepository.save(entryAccessMapper.toEntity(dto));
		return entryAccessMapper.toDTO(entity);
	}
	
	private PersonDTO validatePerson(String id) {
		Person entity = personRepository.findById(id).orElse(null);
		if(entity == null)
			throw new PersonNotFoundException("Invalid id: " + id);
		PersonDTO dto = personMapper.toDTO(entity);
		if(BooleanUtils.isNotTrue(dto.getActive()))
			throw new PersonNotAllowedException(String.format("%s (id: %s) is not allowed to perform operations", dto.getFullName(), dto.getId()));
		return dto;
	}
}