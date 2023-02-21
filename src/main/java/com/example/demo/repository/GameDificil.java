package com.example.demo.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("Dificil")
@Component
public class GameDificil extends AbstractGame implements Game {
	final static String correctWord = "pescados";
	final static int tries = 6;
	@Override
	public int getNumTries() {
		return tries;
	}

	@Override
	public String getCorrectAnswer() {
		return correctWord;
	}

}
