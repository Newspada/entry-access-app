package com.facchinil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "PERSON")
public class Person {
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@NotNull
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "F_ACTIVE")
	private String active;
}
