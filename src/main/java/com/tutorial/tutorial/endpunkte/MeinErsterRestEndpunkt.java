package com.tutorial.tutorial.endpunkte;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeinErsterRestEndpunkt {

	@GetMapping(path="/meinersterendpunkt")
	public String ersterEndpunkt() {
		return "Hello World";
	}
	
}
