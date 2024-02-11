package com.sprint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.beans.Student;
import com.sprint.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentRepository stRepository;

	@PostMapping("/add")
	public Student addStudents(@Valid Student student) {
		return stRepository.save(student);
	}
	
	@GetMapping("/findAll")
	public List<Student> getAllStudents(){
		return stRepository.findAll();
	}
	
	@PutMapping("/update")
	public Student updateStudent(@Valid Student student) {
		return stRepository.save(student);
	}
	
	@DeleteMapping("/delete/{studentId}")
	public void removeStudent(Integer studentId) {
		stRepository.deleteById(studentId);
	}
	
}
