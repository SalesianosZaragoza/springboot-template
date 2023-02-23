package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Info;
import com.example.demo.repository.Game;
@ExtendWith(MockitoExtension.class)
class ServiceGameTest2 {
	ServiceGame serviceGame;
	
	Game game1 = new Game() {
		
		@Override
		public List<String> testWorldlePlay(Info info, String wordToPlay, String correctAnswer) {
			return null;
		}
		
		@Override
		public int getNumTries() {
			return 6;
		}
		
		@Override
		public String getCorrectAnswer() {
			return null;
		}
	};
	@Mock
	Game game2;
	
	@Spy
	Game game3;
	
	@BeforeEach
	void setup() {
		serviceGame = new ServiceGame();
		//Mockito.when(game3.getNumTries()).thenReturn(6);
		serviceGame.setGame(game3);
	}
	
	@Test
	void getNumTriesAndGameIsCalledTest() {
		serviceGame.getNumTries();
		verify(game3, times(1)).getNumTries();
	};

	
	@Test
	void getNumTriesTest() {
		assertEquals(6, serviceGame.getNumTries());
	};


}
