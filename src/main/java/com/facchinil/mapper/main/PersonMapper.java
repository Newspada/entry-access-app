package com.facchinil.mapper.main;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Component;

import com.facchinil.dto.PersonDTO;
import com.facchinil.entity.Person;
import com.facchinil.mapper.Mapper;

@Component
public class PersonMapper implements Mapper<PersonDTO, Person> {

	@Override
	public PersonDTO toDTO(Person entity) {
		PersonDTO dto = new PersonDTO();
		dto.setId(entity.getId());
		dto.setFullName(entity.getFullName());
		dto.setActive(BooleanUtils.toBoolean(entity.getActive(), "Y", "N"));
		return dto;
	}

	@Override
	public Person toEntity(PersonDTO dto) {
		Person entity = new Person();
		entity.setId(dto.getId());
		entity.setFullName(dto.getFullName());
		entity.setActive(BooleanUtils.isTrue(dto.getActive()) ? "Y" : "N");
		return entity;
	}
	
}
