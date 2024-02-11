package com.sprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sprint.beans.Student;
import com.sprint.repository.StudentRepository;

@SpringBootApplication
public class Sprintdemo2Application implements CommandLineRunner{
	
	@Autowired
	StudentRepository stRepository;

	public static void main(String[] args) {
		SpringApplication.run(Sprintdemo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setStudentId(101);
		student.setStudentName("Anup");
		student.setAge(24);
		
		stRepository.save(student);
	}

}
