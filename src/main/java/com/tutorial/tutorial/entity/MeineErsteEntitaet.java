package com.tutorial.tutorial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name= "meineersteentitaet", schema = "public")
public class MeineErsteEntitaet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@NotNull(message="MeineErsteEntitaet.einDatenfeld:NOTNULL")
	@NotEmpty(message="MeineErsteEntitaet.einDatenfeld:NOTEMPTY")
	@Length(max=16, message="MeineErsteEntitaet.einDatenfeld:LENGTH")
	private String einDatenfeld;

	public String getEinDatenfeld() {
		return einDatenfeld;
	}

	public void setEinDatenfeld(String einDatenfeld) {
		this.einDatenfeld = einDatenfeld;
	}

	public Long getId() {
		return id;
	}

}
