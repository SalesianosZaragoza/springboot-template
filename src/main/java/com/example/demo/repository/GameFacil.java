package com.example.demo.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("Facil")
@Component
public class GameFacil extends AbstractGame implements Game {
	final static String correctWord = "pez";
	final static int tries = 20;
	@Override
	public int getNumTries() {
		// TODO Auto-generated method stub
		return tries;
	}

	@Override
	public String getCorrectAnswer() {
		return correctWord;
	}

}
