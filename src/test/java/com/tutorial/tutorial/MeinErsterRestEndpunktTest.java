package com.tutorial.tutorial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorial.tutorial.endpunkte.MeinErsterRestEndpunkt;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MeinErsterRestEndpunktTest {
	
	@LocalServerPort
	private int port;
	
	@Test
	public void testEndpunkt() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpEntity<String> httpEntity = new HttpEntity<>(null);
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + MeinErsterRestEndpunkt.MEINERSTERENDPUNKT, HttpMethod.GET, httpEntity, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Hello World hinter einem Interface", response.getBody());
	}
}
