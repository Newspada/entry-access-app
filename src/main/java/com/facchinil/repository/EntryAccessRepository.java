package com.facchinil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facchinil.entity.EntryAccess;

public interface EntryAccessRepository extends JpaRepository<EntryAccess, Long> {

}
