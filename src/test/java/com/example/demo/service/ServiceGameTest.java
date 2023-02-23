package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
@SpringBootTest
@TestPropertySource("application_dificil.properties")
class ServiceGameTest {
	@Autowired
	ServiceGame serviceGame;
	
	
	@BeforeEach
	void setup() {
		//serviceGame = new ServiceGame();
	}
	
	@Test
	void getNumTriesTest() {
		assertEquals(6, serviceGame.getNumTries());
	};


}
