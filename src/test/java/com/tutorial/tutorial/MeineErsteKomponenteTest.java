package com.tutorial.tutorial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorial.tutorial.komponenten.MeineErsteKomponenteI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeineErsteKomponenteTest {
	
	@Autowired
	private MeineErsteKomponenteI meineErsteKomponente;
	
	@Test
	public void einfacherKomponentenTest() throws Exception {
		String helloWorld = meineErsteKomponente.helloWorld();
		assertEquals("Hello World hinter einem Interface", helloWorld);
	}
}
