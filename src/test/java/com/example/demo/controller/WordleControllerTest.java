package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Info;

@WebMvcTest(WordleController.class)
@AutoConfigureMockMvc
class WordleControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Test
	void testSearch() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	void testGoToIndexPage() throws Exception {
		//simulo que hay una jsp previa
		MvcResult result = mockMvc
							.perform(get("/"))
								.andExpect(status().isOk())
								.andReturn();
		//simulo que he marchado a otra jsp
		ModelAndView modelAndView = result.getModelAndView();
		//el nombre de la vista a la que redirige debe ser wordle.jsp
		assertEquals("wordle", modelAndView.getViewName());
		// el modelo debe contener un objeto llamado info
		assertTrue(modelAndView.getModel().keySet().contains("info"));
		Info info = (Info) modelAndView.getModel().get("info");
		// el objeto info del modelo no debe ser nulo
		assertNotNull(info);
	}

	@Test
	void testPlayMethodWinnerWord() throws Exception {
		// given
		// simulo un formulario
		MockHttpServletRequestBuilder form = post("/play")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("WordToPlay", "pez");
		// when
		//le doy al boton input subbmit del formulario 
		MvcResult result = mockMvc.perform(form).andExpect(status().isOk()).andReturn();
		ModelAndView modelAndView = result.getModelAndView();
		
		//then
		assertEquals("fin", modelAndView.getViewName());
		assertTrue(modelAndView.getModel().keySet().contains("info"));
		Info info = (Info) modelAndView.getModel().get("info");
		assertNotNull(info);
		assertEquals("", info.getWordToPlay());
	}
	
	@Test
	void testPlayWhenWordIncorrectSize() throws Exception {
		// given
		// simulo un formulario
		MockHttpServletRequestBuilder form = post("/play")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("WordToPlay", "ABCDEFGHIJKLMEN");
		// when
		//le doy al boton input subbmit del formulario 
		MvcResult result = mockMvc.perform(form).andExpect(status().isOk()).andReturn();
		ModelAndView modelAndView = result.getModelAndView();
		
		//then
		assertEquals("fin", modelAndView.getViewName());
		assertTrue(modelAndView.getModel().keySet().contains("info"));
		Info info = (Info) modelAndView.getModel().get("info");
		assertNotNull(info);
		assertEquals("", info.getWordToPlay());
	}

}
