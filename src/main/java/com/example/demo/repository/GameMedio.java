package com.example.demo.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("Medio")
@Component
public class GameMedio extends AbstractGame implements Game {
	final static String correctWord = "peces";
	final static int tries = 10;

	@Override
	public int getNumTries() {
		return tries;
	}

	@Override
	public String getCorrectAnswer() {
		return correctWord;
	}

}
