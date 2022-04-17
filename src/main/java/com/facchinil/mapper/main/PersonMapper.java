package com.facchinil.mapper.main;

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
		return dto;
	}

	@Override
	public Person toEntity(PersonDTO dto) {
		Person entity = new Person();
		entity.setId(dto.getId());
		entity.setFullName(dto.getFullName());
		return entity;
	}
	
}
