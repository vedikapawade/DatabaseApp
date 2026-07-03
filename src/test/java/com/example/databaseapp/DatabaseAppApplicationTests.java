package com.example.databaseapp;

import com.example.databaseapp.model.Student;
import com.example.databaseapp.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DatabaseAppApplicationTests {

    @Autowired
    StudentRepository repository;

    @Test
    void testSaveStudent() {

        Student student = new Student();
        student.setName("Test");
        student.setCourse("Java");

        Student saved = repository.save(student);

        assertNotNull(saved.getId());
    }
}