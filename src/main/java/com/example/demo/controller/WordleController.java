package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Info;
import com.example.demo.repository.Game;

@Controller
public class WordleController {
	List<String> wordsPlayed = new ArrayList<>();
	@Autowired
	Info info;

	@Autowired
	Game game;

	@GetMapping("/searchTry")
	public ModelAndView search(Info info) {
		if (info.getNumJugada() != 0) {
			String jugada = wordsPlayed.get(info.getNumJugada());
			info.setMessage(jugada);
		} else {
			info.setMessage(wordsPlayed.stream().collect(Collectors.joining(",")));
		}
		ModelAndView modelAndView = new ModelAndView("fin");
		modelAndView.addObject("info", info);
		return modelAndView;
	}

	@GetMapping("/")
	public ModelAndView goToIndexPage() {
		ModelAndView modelAndView = new ModelAndView("wordle");
		modelAndView.addObject("info", info);
		return modelAndView;
	}

	@PostMapping("/play")
	public ModelAndView play(Info info) {
		String pageToReturn = "wordle";
		String wordToPlay = info.getWordToPlay();
		wordsPlayed.add(wordToPlay);

		String correctAnswer = game.getCorrectAnswer();
		boolean wordsEqualsLenght = correctAnswer.length() == wordToPlay.length();
		if (!wordsEqualsLenght)
			info.setMessage("error en tamaño de jugada");
		else if (wordsEqualsLenght) {
			info.setAnswer(game.testWorldlePlay(info, wordToPlay, correctAnswer));
		} else {
			pageToReturn = "fin";
			info.setWordToPlay("");
		}

		info.setMessage("le quedan " + (game.getNumTries() - wordsPlayed.size()) + "intentos");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(pageToReturn);
		modelAndView.addObject("info", info);
		return modelAndView;
	}



}
