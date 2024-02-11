package com.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.beans.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
}
