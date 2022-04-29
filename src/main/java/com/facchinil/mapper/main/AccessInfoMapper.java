package com.facchinil.mapper.main;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.AccessInfoDTO;
import com.facchinil.entity.AccessInfo;
import com.facchinil.mapper.Mapper;

@Component
public class AccessInfoMapper implements Mapper<AccessInfoDTO, AccessInfo> {
	
	@Autowired
	private PersonMapper personMapper;
	
	@Override
	public AccessInfoDTO toDTO(AccessInfo entity) {
		AccessInfoDTO dto = new AccessInfoDTO();
		dto.setModality(entity.getModality());
		dto.setWay(entity.getWay());
		if(entity.getDeviceDate() != null)
			dto.setDeviceDate(new Date(entity.getDeviceDate().getTime()));
		dto.setAppDate(new Date(entity.getAppDate().getTime()));
		dto.setPerson(personMapper.toDTO(entity.getPerson()));
		return dto;
	}

	@Override
	public AccessInfo toEntity(AccessInfoDTO dto) {
		AccessInfo entity = new AccessInfo();
		entity.setModality(dto.getModality());
		entity.setWay(dto.getWay());
		if(dto.getDeviceDate() != null)
			entity.setDeviceDate(new Timestamp(dto.getDeviceDate().getTime()));
		entity.setAppDate(new Timestamp(dto.getAppDate().getTime()));
		entity.setPerson(personMapper.toEntity(dto.getPerson()));
		return entity;
	}

}
