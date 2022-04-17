package com.facchinil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facchinil.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

}
