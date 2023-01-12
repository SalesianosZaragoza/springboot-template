package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository("list")
public class ListRepositoryStudent implements RepositoryStudent {

	static List<Student> list = new ArrayList<>();

	@Override
	public void save(Student student) {
		list.add(student);

		for (Student s : list) {
			System.out.println(s);
		}

		list.forEach(System.out::println);

		list.forEach((s) -> System.out.println(s));
	}

}
