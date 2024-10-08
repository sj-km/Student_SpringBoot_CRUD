package com.example.student_boot_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_boot_crud.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}
