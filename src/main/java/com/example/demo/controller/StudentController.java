package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
	
	//Test Data
	private static final List<Student> STUDENTS = Arrays.asList(
			new Student(1,"James Bond"),
			new Student(2,"Dekard Shaw"),
			new Student(3,"Randy Rhoads")
	);
	
	@GetMapping(path = "{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentId) {
		
		System.out.println("StudentController.getStudent");
		
		return STUDENTS.stream()
				.filter(student -> studentId.equals(student.getStudentId()))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist"));
	}

}
