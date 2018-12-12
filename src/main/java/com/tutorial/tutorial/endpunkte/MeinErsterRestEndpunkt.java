package com.tutorial.tutorial.endpunkte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.tutorial.komponenten.MeineErsteKomponenteI;

@RestController
public class MeinErsterRestEndpunkt {
	
	@Autowired
	protected MeineErsteKomponenteI meineErsteKomponente;

	@GetMapping(path="/meinersterendpunkt")
	public String ersterEndpunkt() {
		return meineErsteKomponente.helloWorld();
	}
	
}
