package com.springboot.management.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springboot.management.entity.Assignment;
import com.springboot.management.entity.Course;
import com.springboot.management.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	@PersistenceContext
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Student getStudentByName(String name)
	{
		TypedQuery<Student> query=em.createQuery("Select s from Student s where name = :name",Student.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
	
	public void addStudentToCourse(Course course,String name)
	{
		Student student =getStudentByName(name);
		course.addStudent(student);
		student.addCourse(course);
		em.persist(course);
		List<Assignment> assignments=course.getAssignments();
		for(Assignment assignment: assignments)
		{
			assignment.addStudent(student);
			student.addAssignment(assignment);
			em.persist(assignment);
		}
		em.persist(student);
	}
	
	public void removeAssignmentforUser(String name,Long id)
	{
		Student student = getStudentByName(name);
		student.removeAssignment(id);
		em.persist(student);
	}

}
