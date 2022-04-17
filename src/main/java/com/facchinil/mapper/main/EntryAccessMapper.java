package com.facchinil.mapper.main;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.EntryAccessDTO;
import com.facchinil.entity.EntryAccess;
import com.facchinil.mapper.Mapper;

@Component
public class EntryAccessMapper implements Mapper<EntryAccessDTO, EntryAccess> {
	
	@Autowired
	private PersonMapper personMapper;
	
	@Override
	public EntryAccessDTO toDTO(EntryAccess entity) {
		EntryAccessDTO dto = new EntryAccessDTO();
		dto.setModality(entity.getModality());
		if(entity.getDeviceEntryDate() != null)
			dto.setDeviceEntryDate(new Date(entity.getDeviceEntryDate().getTime()));
		dto.setEntryDate(new Date(entity.getEntryDate().getTime()));
		dto.setPerson(personMapper.toDTO(entity.getPerson()));
		return dto;
	}

	@Override
	public EntryAccess toEntity(EntryAccessDTO dto) {
		EntryAccess entity = new EntryAccess();
		entity.setModality(dto.getModality());
		if(dto.getDeviceEntryDate() != null)
			entity.setDeviceEntryDate(new Timestamp(dto.getDeviceEntryDate().getTime()));
		entity.setEntryDate(new Timestamp(dto.getEntryDate().getTime()));
		entity.setPerson(personMapper.toEntity(dto.getPerson()));
		return entity;
	}

}
