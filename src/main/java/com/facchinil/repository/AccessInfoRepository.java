package com.facchinil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.facchinil.entity.AccessInfo;

public interface AccessInfoRepository extends JpaRepository<AccessInfo, Long> {

	Optional<AccessInfo> findTopByPersonIdOrderByIdDesc(@Param("personId")String personId);
	
	List<AccessInfo> findTop2ByPersonIdOrderByIdDesc(@Param("personId")String personId);
}
