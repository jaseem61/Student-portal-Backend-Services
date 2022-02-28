package com.springboot.management.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String password;
	
	@OneToMany(mappedBy="teacher")
	private List<Course> courses=new ArrayList<>();
	
	
	public List<Course> getCourses() {
		return courses;
	}
	public void addCourse(Course course) {
		this.courses.add(course);
	}
	public Teacher() {
		super();
	}
	public Teacher(String name) {
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
		return "Teacher [name=" + name + "]";
	}
	
	

}
