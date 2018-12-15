package com.tutorial.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
		//kein Element in der Datenbank
		List<MeineErsteEntitaet> alleEntitaeten = dao.findAll();
		assertEquals(0, alleEntitaeten.size());
		
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
}
