package com.example.demo.controller;


import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.service.ServiceStudent;

@Controller
public class IndexController {
	
	Logger l = org.apache.logging.log4j.LogManager.getLogger();

	public ServiceUser serviceuser;

	public ServiceStudent serviceStudent;

	@Autowired
	public IndexController(ServiceStudent serviceStudent, ServiceUser serviceuser) {
		this.serviceStudent = serviceStudent;
		this.serviceuser = serviceuser;
	}

	@GetMapping("/")
	public ModelAndView goToIndexPage() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("estudiante", new Student());
		return modelAndView;
	}

	@PostMapping("addStudentForm")
	public String logStudentInfoAndSendToEndPage(@ModelAttribute("estudiante") Student student) {
		serviceStudent.guardar(student);
		l.info(student.toString());
		return "end";
	}

}
