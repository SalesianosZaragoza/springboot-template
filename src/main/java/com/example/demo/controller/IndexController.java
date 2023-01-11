package com.example.demo.controller;


import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;

@Controller
public class IndexController {
	
	Logger l = org.apache.logging.log4j.LogManager.getLogger();

	@GetMapping("/")
	public ModelAndView goToIndexPage() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	@PostMapping("addStudentForm")
	private String logStudentInfoAndSendToEndPage(Student student) {
		l.info(student.toString());
		return "end";
	}

}
