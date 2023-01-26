package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Student;
import com.example.demo.service.ServiceStudent;

class IndexControllerTest {

	IndexController indexController;

	@BeforeEach
	public void setup() {
		ServiceStudent serviceStudent = new ServiceStudent() {

			@Override
			public void guardar(Student student) {
			}
		};

		indexController = new IndexController(serviceStudent, null);
	}

	@Test
	void testGoToIndex() {
		assertEquals("index", indexController.goToIndexPage().getViewName());

		Map<String, Object> model = indexController.goToIndexPage().getModel();

		assertTrue(model.containsKey("estudiante"));
	}

	@Test
	void testAddStudentForm() {
		Student student = new Student();
		student.setName("gorka");
		student.setSurname("sanz");

		assertSame(student, indexController.logStudentInfoAndSendToEndPage(student).getModel().get("student"));
		assertEquals("end", indexController.logStudentInfoAndSendToEndPage(student).getViewName());
	}
	
	
	

}
