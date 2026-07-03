package com.example.databaseapp.model;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   // Change int to Integer

    private String name;
    private String course;

    public Student() {
    }

    public Student(Integer id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    // getters and setters for name and course
}