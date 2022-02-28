package com.springboot.management.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.management.entity.Assignment;
import com.springboot.management.entity.Course;
import com.springboot.management.entity.Student;

@Repository
@Transactional
public class CourseRepository {

	@PersistenceContext
	EntityManager em;
	
	
	public List<Assignment> getAssignmentsfromCourse(Course course)
	{
		return course.getAssignments();
	}
	
	public List<Course> giveNotEnrolledCourses(Long id)
	{
		TypedQuery<Course> query= em.createQuery("SELECT c FROM Course c where c NOT IN (SELECT c1 FROM Student s JOIN s.courses c1 WHERE s.id = :id )",Course.class);
		query.setParameter("id", id);
		List<Course> results= query.getResultList();
//		System.out.println("NOT ENROLLED COURSES");
//		System.out.println(results);
		return results;
	}	
	
	public Course getCourseById(Long id)
	{
		return em.find(Course.class, id);
	}
	
	public void addCourseToStudent(Student student,Long id)
	{
		Course course=getCourseById(id);
		student.addCourse(course);
	}
	
	
	
}
