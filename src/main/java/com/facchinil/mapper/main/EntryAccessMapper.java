package com.facchinil.mapper.main;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.facchinil.dto.EntryAccessDTO;
import com.facchinil.dto.PersonDTO;
import com.facchinil.entity.EntryAccess;
import com.facchinil.entity.Person;
import com.facchinil.mapper.Mapper;

@Component
public class EntryAccessMapper implements Mapper<EntryAccessDTO, EntryAccess> {
	
	@Override
	public EntryAccessDTO toDTO(EntryAccess entity) {
		EntryAccessDTO dto = new EntryAccessDTO();
		dto.setModality(entity.getModality());
		if(entity.getDeviceEntryDate() != null)
			dto.setDeviceEntryDate(new Date(entity.getDeviceEntryDate().getTime()));
		dto.setEntryDate(new Date(entity.getEntryDate().getTime()));
		PersonDTO personDTO = new PersonDTO();
		personDTO.setId(entity.getPerson().getId());
		personDTO.setFullName(entity.getPerson().getFullName());
		dto.setPerson(personDTO);
		return dto;
	}

	@Override
	public EntryAccess toEntity(EntryAccessDTO dto) {
		EntryAccess entity = new EntryAccess();
		entity.setModality(dto.getModality());
		if(dto.getDeviceEntryDate() != null)
			entity.setDeviceEntryDate(new Timestamp(dto.getDeviceEntryDate().getTime()));
		entity.setEntryDate(new Timestamp(new Date().getTime()));
		Person personEntity = new Person();
		personEntity.setId(dto.getPerson().getId());
		personEntity.setFullName(dto.getPerson().getFullName());
		entity.setPerson(personEntity);
		return entity;
	}

}
