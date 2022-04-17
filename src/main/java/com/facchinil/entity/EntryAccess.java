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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ENTRY_ACCESS")
public class EntryAccess {
	
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
	
	@Column(name = "DEVICE_ENTRY_DATE")
	private Timestamp deviceEntryDate;
	
	@NotNull
	@Column(name = "ENTRY_DATE")
	private Timestamp entryDate;
}
