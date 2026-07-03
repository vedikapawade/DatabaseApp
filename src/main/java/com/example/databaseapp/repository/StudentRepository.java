package com.example.databaseapp.repository;

import com.example.databaseapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByCourse(String course);

}