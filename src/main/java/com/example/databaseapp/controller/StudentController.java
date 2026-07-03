package com.example.databaseapp.controller;

import com.example.databaseapp.model.Student;
import com.example.databaseapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    // Get all students
    @GetMapping
    public List<Student> getStudents() {
        return repository.findAll();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Add new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    // Update student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @RequestBody Student student) {

        Student existingStudent = repository.findById(id).orElse(null);

        if (existingStudent == null) {
            throw new RuntimeException("Student not found with id: " + id);
        }

        existingStudent.setName(student.getName());
        existingStudent.setCourse(student.getCourse());

        return repository.save(existingStudent);
    }

    // Delete student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {

        Student existingStudent = repository.findById(id).orElse(null);

        if (existingStudent == null) {
            return "Student not found with id: " + id;
        }

        repository.deleteById(id);

        return "Student deleted successfully.";
    }

    // Get students by course
    @GetMapping("/course/{course}")
    public List<Student> getStudentsByCourse(@PathVariable String course) {
        return repository.findByCourse(course);
    }
}