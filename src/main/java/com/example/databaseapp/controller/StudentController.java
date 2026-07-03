package com.example.databaseapp.controller;

import com.example.databaseapp.model.Student;
import com.example.databaseapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Integer id) {

	    repository.deleteById(id);

	    return "Student Deleted Successfully";
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Integer id,
	                             @RequestBody Student student) {

	    Student s = repository.findById(id).orElse(null);

	    if (s != null) {
	        s.setName(student.getName());
	        s.setCourse(student.getCourse());

	        return repository.save(s);
	    }

	    return null;
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Integer id) {
	    return repository.findById(id).orElse(null);
	}

    @Autowired
    StudentRepository repository;

    @GetMapping
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repository.save(student);
    }
}