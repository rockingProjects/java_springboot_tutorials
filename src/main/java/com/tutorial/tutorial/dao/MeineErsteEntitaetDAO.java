package com.tutorial.tutorial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tutorial.tutorial.entity.MeineErsteEntitaet;

@Repository
@Transactional
public class MeineErsteEntitaetDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public MeineErsteEntitaet create(MeineErsteEntitaet e) {
		this.entityManager.persist(e);
		return e;
	}
	
	public List<MeineErsteEntitaet> findAll() {
		return this.entityManager.createQuery("select e from MeineErsteEntitaet e", MeineErsteEntitaet.class).getResultList();
	}
	
}
