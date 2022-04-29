package com.facchinil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "ACCESS_MATCH")
public class AccessMatch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "ENTRY_ID")
	private AccessInfo entryAccessInfo;
	
	@OneToOne
	@JoinColumn(name = "EXIT_ID")
	private AccessInfo exitAccessInfo;
	
	@Column(name = "F_VALID")
	private String valid;
}
