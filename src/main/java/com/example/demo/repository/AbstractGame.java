package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Info;

public abstract class AbstractGame implements Game {

	@Override
	public abstract int getNumTries();

	@Override
	public abstract String getCorrectAnswer();

	@Override
	public List<String> testWorldlePlay(Info info, String wordToPlay, String correctAnswer) {
//		int diffCount = (int) IntStream.range(0, str1.length())
//      .filter(i -> str1.charAt(i) != str2.charAt(i)) // corresponding characters from both the strings
//      .count();
		List<String> answer = info.getAnswer();
		char[] respuesta = correctAnswer.toCharArray();
		char[] jugada = wordToPlay.toCharArray();
		for (int i = 0; i < jugada.length; i++) {
			char j = jugada[i];
			char r = respuesta[i];
			answer.add(checkColor(correctAnswer, j, r));
		}
		return answer;
	}

	public String checkColor(String correctAnswer, char j, char r) {
		if (r == j) {
			return "verde";
		} else if (correctAnswer.contains(Character.toString(j))) {
			return "amarillo";
		} else {
			return "rojo";
		}
	}

}
