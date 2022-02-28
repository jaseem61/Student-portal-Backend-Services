package com.springboot.management.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@JsonIgnore
	@ManyToOne
	private Teacher teacher;
	
	@JsonIgnore
	@OneToMany(mappedBy="course")
	private List<Assignment> assignments= new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy="courses")
	private List<Student> students=new ArrayList();
	
	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void addAssignment(Assignment assignment) {
		this.assignments.add(assignment);
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course() {
		
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
	
	
	
}
