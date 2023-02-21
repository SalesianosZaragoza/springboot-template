package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Info;

public interface Game {

	int getNumTries();

	String getCorrectAnswer();

	List<String> testWorldlePlay(Info info, String wordToPlay, String correctAnswer);
}
