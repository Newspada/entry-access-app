package com.facchinil.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.facchinil.dto.DataTransferObject;
import com.google.common.collect.Lists;

public interface Mapper<A extends DataTransferObject, B> {
	public A toDTO(B entity);
	public B toEntity (A dto);
	
	public default List<A> toDTOs(List<B> entities){
		if(CollectionUtils.isNotEmpty(entities)) {
			return entities.stream().map(this::toDTO).collect(Collectors.toList());
		}
		return Lists.newArrayList();
	}
}
