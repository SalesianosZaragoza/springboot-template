package com.example.demo.service;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.RepositoryStudent;

@Profile("Test")
@Service
public class ServiceStudentTest implements ServiceStudent {
	Logger l = org.apache.logging.log4j.LogManager.getLogger();

	@Autowired
	@Qualifier("void")
	public RepositoryStudent repository;

	@Override
	public void guardar(Student student) {
		l.info("guardando en base de datos de TEST");
		repository.save(student);
	}

}
