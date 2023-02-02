package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
@RequestMapping("/api/")
public class StudentRestController {
	List<Student> list = new ArrayList<>();
	Logger l = org.apache.logging.log4j.LogManager.getLogger(IndexController.class);

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

	@GetMapping
	@RequestMapping(value = "/deleteAll")
	public ResponseEntity<List<Student>> deleteAll() {
		list.clear();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/delete1")
	public ResponseEntity<List<Student>> delete1(@RequestParam Integer id) {
		l.info("delete1:" + id);
		// list.remove(id.intValue() - 1);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/delete2/{id}")
	public ResponseEntity<List<Student>> delete2(@PathVariable("id") int id) {
		l.info("delete2:" + id);
		// list.remove(id.intValue() - 1);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
