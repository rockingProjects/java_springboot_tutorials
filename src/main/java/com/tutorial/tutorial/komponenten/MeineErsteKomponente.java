package com.tutorial.tutorial.komponenten;

import org.springframework.stereotype.Component;

@Component
public class MeineErsteKomponente implements MeineErsteKomponenteI {
	
	@Override
	public String helloWorld() {
		return "Hello World hinter einem Interface";
	}
}
