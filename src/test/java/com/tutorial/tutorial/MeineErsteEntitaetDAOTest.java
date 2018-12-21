package com.tutorial.tutorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorial.tutorial.dao.MeineErsteEntitaetDAO;
import com.tutorial.tutorial.entity.MeineErsteEntitaet;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class MeineErsteEntitaetDAOTest {
	
	@Autowired
	private MeineErsteEntitaetDAO dao;
	
	/**
	 * 1. MeineErsteEntitaet anlegen
	 * 2. Alle Objekte aus der Datenbank holen
	 * 3. Prüfen, dass die Entität korrekt angelegt wurde
	 * @throws Exception
	 */
	@Test
	public void simplerDAOTest() throws Exception {

		List<MeineErsteEntitaet> alleEntitaeten = pruefeKeineEntitaetenAngelegt();
		
		//Entität anlegen
		MeineErsteEntitaet e = new MeineErsteEntitaet();
		e.setEinDatenfeld("das ist ein Text");
		dao.create(e);
		
		//eine neue Entität wurde angelegt
		alleEntitaeten = dao.findAll();
		assertEquals(1, alleEntitaeten.size());
		
		//in der Entität wurde der richtige Inhalt abgelegt
		String inhalt = alleEntitaeten.get(0).getEinDatenfeld();
		assertEquals("das ist ein Text", inhalt);
	}
	
	@Test
	public void testConstraints() throws Exception {
		//Entität anlegen
		try {
			MeineErsteEntitaet e = new MeineErsteEntitaet();
			dao.create(e);			
		} catch (ConstraintViolationException e) {
			assertEquals(2, e.getConstraintViolations().size());
			Iterator<ConstraintViolation<?>> iterator = e.getConstraintViolations().iterator();
			ConstraintViolation<?> constraint1 = iterator.next();
			ConstraintViolation<?> constraint2 = iterator.next();
			
			assertTrue(constraint1.getMessage().equals("MeineErsteEntitaet.einDatenfeld:NOTEMPTY") 
					|| constraint1.getMessage().equals("MeineErsteEntitaet.einDatenfeld:NOTNULL"));
			assertTrue(constraint2.getMessage().equals("MeineErsteEntitaet.einDatenfeld:NOTEMPTY") 
					|| constraint2.getMessage().equals("MeineErsteEntitaet.einDatenfeld:NOTNULL"));
			
			assertTrue(!constraint1.getMessage().equals(constraint2.getMessage()));
			
			pruefeKeineEntitaetenAngelegt();
		}

		try {
			MeineErsteEntitaet e = new MeineErsteEntitaet();
			e.setEinDatenfeld("12345678912345678");
			dao.create(e);
		} catch (ConstraintViolationException e) {
			assertEquals(1, e.getConstraintViolations().size());
			assertEquals("MeineErsteEntitaet.einDatenfeld:LENGTH", e.getConstraintViolations().iterator().next().getMessage());
			pruefeKeineEntitaetenAngelegt();
		}
		
		try {
			MeineErsteEntitaet e = new MeineErsteEntitaet();
			e.setEinDatenfeld("");
			dao.create(e);			
		} catch (ConstraintViolationException e) {
			assertEquals(1, e.getConstraintViolations().size());
			assertEquals("MeineErsteEntitaet.einDatenfeld:NOTEMPTY", e.getConstraintViolations().iterator().next().getMessage());
			pruefeKeineEntitaetenAngelegt();
		}
	}
	
	private List<MeineErsteEntitaet> pruefeKeineEntitaetenAngelegt() {
		//kein Element in der Datenbank
		List<MeineErsteEntitaet> alleEntitaeten = dao.findAll();
		assertEquals(0, alleEntitaeten.size());
		return alleEntitaeten;
	}
}
