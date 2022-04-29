package com.facchinil.manager.main;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.AccessInfoDTO;
import com.facchinil.dto.PersonDTO;
import com.facchinil.entity.AccessInfo;
import com.facchinil.entity.AccessMatch;
import com.facchinil.entity.Person;
import com.facchinil.exception.PersonNotAllowedException;
import com.facchinil.exception.PersonNotFoundException;
import com.facchinil.manager.AccessInfoManager;
import com.facchinil.mapper.main.AccessInfoMapper;
import com.facchinil.mapper.main.PersonMapper;
import com.facchinil.repository.AccessInfoRepository;
import com.facchinil.repository.AccessMatchRepository;
import com.facchinil.repository.PersonRepository;
import com.facchinil.request.AccessInfoRequest;

@Component
public class AccessInfoManagerMain implements AccessInfoManager {

	@Autowired
	private AccessInfoRepository accessInfoRepository;
	
	@Autowired
	private AccessMatchRepository accessMatchRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AccessInfoMapper accessInfoMapper;
	
	@Autowired
	private PersonMapper personMapper;
	
	@Override
	@Transactional
	public AccessInfoDTO postAccessInfo(AccessInfoRequest request) {
		PersonDTO personDTO = validatePerson(request.getId());
		AccessInfoDTO dto = new AccessInfoDTO();
		dto.setModality(request.getModality());
		dto.setWay(request.getWay());
		dto.setDeviceDate(request.getDeviceDate());
		dto.setAppDate(new Date());
		dto.setPerson(personDTO);
		AccessInfo entity = accessInfoRepository.save(accessInfoMapper.toEntity(dto));
		AccessMatch matchEntity = handleAccessMatch(request.getId());
		return accessInfoMapper.toDTO(entity);
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
	
	private AccessMatch handleAccessMatch(String personId) {
		List<AccessInfo> infos = accessInfoRepository.findTop2ByPersonIdOrderByIdDesc(personId);
		if(CollectionUtils.isEmpty(infos) || infos.size() == 1)
			return null;
		if("ENTRY".equalsIgnoreCase(infos.get(0).getWay()) && "EXIT".equalsIgnoreCase(infos.get(1).getWay()))
			return null;
		AccessMatch matchEntity = new AccessMatch();
		if("EXIT".equalsIgnoreCase(infos.get(0).getWay()))
			matchEntity.setExitAccessInfo(infos.get(0));
		if("ENTRY".equalsIgnoreCase(infos.get(1).getWay()))
			matchEntity.setEntryAccessInfo(infos.get(1));
		matchEntity.setValid(matchEntity.getEntryAccessInfo() != null && matchEntity != null ? "Y" : "N");
		return accessMatchRepository.save(matchEntity);
	}
}