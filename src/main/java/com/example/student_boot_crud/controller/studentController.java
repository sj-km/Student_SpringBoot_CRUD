package com.example.student_boot_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.student_boot_crud.dto.Student;
import com.example.student_boot_crud.repository.StudentRepository;

@Controller
public class studentController {

	@Autowired
	StudentRepository repository;

	@GetMapping("/")
	public String loadHome() {
		return "home.html";
	}

	@GetMapping("/add-student")
	public String addStudent(ModelMap map) {
		map.put("add", "add");
		return "home.html";
	}

	@PostMapping("/add-student")
	public String addStudent(Student student, ModelMap map) {
		map.put("success", "Record Added Success");
		repository.save(student);
		return "home.html";
	}

	@GetMapping("/fetch-student")
	public String fetchStudent(ModelMap map) {
		map.put("records",repository.findAll());
		return "home.html";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id,ModelMap map) {
		repository.deleteById(id);
		map.put("success","Record Deleted Success");
		return "home.html";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int id,ModelMap map) {
		Student student=repository.findById(id).orElseThrow();
		map.put("emp", student);
		map.put("edit", "edit");
		return "home.html";
	}
	
	@PostMapping("/update-student")
	public String update(Student student,ModelMap map) {
		repository.save(student);
		map.put("success", "Record Updated Success");
		return "home.html";
	}
	
}
