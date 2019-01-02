package com.tutorial.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorial.tutorial.dao.MeineErsteEntitaetDAO;
import com.tutorial.tutorial.entity.MeineErsteEntitaet;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
//Das Dirt-Flag wird hier getestet, deshalb ist es ausgeklammert
public class DirtFlagTest {
	@Autowired
	private MeineErsteEntitaetDAO dao;
	
	@Test
	public void entitaetAnlegenTest() {
		//Entität anlegen
		MeineErsteEntitaet e = new MeineErsteEntitaet();
		e.setEinDatenfeld("das ist ein Text");
		dao.create(e);
	}
	
	@Test
	public void entitaetNochVorhandenTest() {
		pruefeEineEntitaetenAngelegt();
	}
	
	private void pruefeEineEntitaetenAngelegt() {
		//kein Element in der Datenbank
		List<MeineErsteEntitaet> alleEntitaeten = dao.findAll();
		assertEquals(1, alleEntitaeten.size());
	}
}
