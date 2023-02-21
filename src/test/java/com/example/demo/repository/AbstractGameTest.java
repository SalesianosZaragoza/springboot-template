package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class AbstractGameTest {

	AbstractGame game = new AbstractGame() {

		@Override
		public int getNumTries() {
			return 0;
		}

		@Override
		public String getCorrectAnswer() {
			return null;
		}
	};

	@Test
	void testTestWorldlePlay() {
		fail("not implemented yet");
	}

	@Test
	void testCheckColor() {
		// String verde = game.checkColor(null, 'a', 'b');

		String verde = game.checkColor(null, 'a', 'a');
		assertEquals("verde", verde);
		String amarillo = game.checkColor("aaaaa", 'a', 'b');
		assertEquals("amarillo", amarillo);
		String rojo = game.checkColor("zzzzz", 'a', 'b');
		assertEquals("rojo", rojo);

	}

}
