package com.facchinil.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "ACCESS_INFO")
public class AccessInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "PERSON_ID")
	private Person person;
	
	@NotNull
	@Column(name = "MODALITY")
	private String modality;
	
	@NotNull
	@Column(name = "WAY")
	private String way;
	
	@Column(name = "DEVICE_DATE")
	private Timestamp deviceDate;
	
	@NotNull
	@Column(name = "APPLICATION_DATE")
	private Timestamp appDate;
}
