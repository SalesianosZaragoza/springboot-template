package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Info;
import com.example.demo.repository.Game;

@Service
public class ServiceGame {

	@Autowired
	 private Game game;
	
	int getNumTries() {
		return getGame().getNumTries();
	};

	String getCorrectAnswer() {
		return getGame().getCorrectAnswer();
	};

	List<String> testWorldlePlay(Info info, String wordToPlay, String correctAnswer){
		return getGame().testWorldlePlay(info, wordToPlay, correctAnswer);
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	};

}
