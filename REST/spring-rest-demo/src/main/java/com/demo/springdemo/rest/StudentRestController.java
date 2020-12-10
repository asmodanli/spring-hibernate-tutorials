package com.demo.springdemo.rest;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	// define @PostConstruct to load the student data, only once
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<Student>();
		
		theStudents.add(new Student("sena", "modanli"));
		theStudents.add(new Student("tomris", "modanli"));
		theStudents.add(new Student("ayse", "modanli"));
	}

	// define endpoint for /students - return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents() {
				
		return theStudents;
	}
	
	// define endpoint for "/students/studentId"
	@GetMapping("students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		return theStudents.get(studentId);
	}
}




