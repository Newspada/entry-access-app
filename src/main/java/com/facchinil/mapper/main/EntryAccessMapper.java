package com.facchinil.mapper.main;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

import com.facchinil.dto.EntryAccessDTO;
import com.facchinil.entity.EntryAccess;
import com.facchinil.mapper.Mapper;

@Component
public class EntryAccessMapper implements Mapper<EntryAccessDTO, EntryAccess> {
	
	@Override
	public EntryAccessDTO toDTO(EntryAccess entity) {
		EntryAccessDTO dto = new EntryAccessDTO();
		//TODO: add mappings
		return dto;
	}

	@Override
	public EntryAccess toEntity(EntryAccessDTO dto) {
		throw new NotYetImplementedException();
	}
}
