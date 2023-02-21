package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Info {

	String message;
	private String wordToPlay;
	private int numJugada = 0;
	List<String> answer = new ArrayList<>();

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getAnswer() {
		return answer;
	}

	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}

	public String getWordToPlay() {
		return wordToPlay;
	}

	public void setWordToPlay(String wordToPlay) {
		this.wordToPlay = wordToPlay;
	}

	public int getNumJugada() {
		return numJugada;
	}

	public void setNumJugada(int numJugada) {
		this.numJugada = numJugada;
	}

}
