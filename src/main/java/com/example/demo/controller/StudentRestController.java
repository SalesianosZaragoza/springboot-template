package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
@RequestMapping("/api/")
public class StudentRestController {
	List<Student> list = new ArrayList<>();

	@GetMapping
	@RequestMapping(value = "/info")
	public ResponseEntity<Student> showInfo() {
		Student s = new Student();
		s.setName("gorka");
		s.setSurname("sanz");
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@PostMapping
	@RequestMapping(value = "/save")
	public ResponseEntity<List<Student>> saveStudent(@RequestBody Student student) {
		list.add(student);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
