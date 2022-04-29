package com.facchinil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.facchinil.entity.AccessInfo;
import com.google.common.base.Optional;

public interface AccessInfoRepository extends JpaRepository<AccessInfo, Long> {

	Optional<AccessInfo> findTopByPersonIdOrderByIdDesc(@Param("personId")String personId);
	
	List<AccessInfo> findTop2ByPersonIdOrderByIdDesc(@Param("personId")String personId);
}
