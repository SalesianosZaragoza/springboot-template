package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository("void")
public class VoidStudentRepository implements RepositoryStudent {

	@Override
	public void save(Student student) {

	}

}
