package com.springboot.management.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String name;
	private String password;
	
	@ManyToMany
	@JoinTable(name="Student_Course",
	joinColumns=@JoinColumn(name="student_id"),
	inverseJoinColumns=@JoinColumn(name="course_id"))
	@JsonIgnore
	private List<Course> courses=new ArrayList();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="student_assignment",
	joinColumns=@JoinColumn(name="Student_id"),
	inverseJoinColumns=@JoinColumn(name="assignment_id")
			)
	private List<Assignment> assignments= new ArrayList<>();
	
	
	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void removeAssignment(Long id)
	{
		for(Assignment assignment:assignments)
		{
			if(assignment.getId().equals(id))
			{
				assignments.remove(assignment);
				break;
			}
		}
	}
	
	public void addAssignment(Assignment assignment) {
		this.assignments.add(assignment);
	}
	
//	public void removeAssignment(Long id)
//	{
//		for(Assignment assignment: this.assignments)
//		{
//			if(assignment.getId()==id)
//			{
//				this.assignments.remove(assignment);
//				break;
//			}
//		}
//	}



	public List<Course> getCourses() {
		return courses;
	}

	
	
	public String getPassword() {
		return password;
	}



	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public Student()
	{ }

	public Student(String name) {
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
		return "Student [name=" + name + "]";
	}
	
	
}
