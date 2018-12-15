package com.tutorial.tutorial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "meineersteentitaet", schema = "public")
public class MeineErsteEntitaet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
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
