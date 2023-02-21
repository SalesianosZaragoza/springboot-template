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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Info;

@SpringBootTest
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
		MvcResult result = mockMvc.perform(get("/")).andExpect(status().isOk()).andReturn();
		ModelAndView modelAndView = result.getModelAndView();

		assertEquals("wordle", modelAndView.getViewName());
		assertTrue(modelAndView.getModel().keySet().contains("info"));
		Info info = (Info) modelAndView.getModel().get("info");
		assertNotNull(info);
	}

	@Test
	void testPlay() throws Exception {
		MediaType type = MediaType.APPLICATION_FORM_URLENCODED;
		MockHttpServletRequestBuilder form = post("/play")
				.contentType(type )
				.param("WordToPlay", "pez");
		
		MvcResult result = mockMvc.perform(form).andExpect(status().isOk()).andReturn();
		ModelAndView modelAndView = result.getModelAndView();
		
		
		assertEquals("fin", modelAndView.getViewName());
		assertTrue(modelAndView.getModel().keySet().contains("info"));
		Info info = (Info) modelAndView.getModel().get("info");
		assertNotNull(info);
		assertEquals("", info.getWordToPlay());
	}

}
