package com.springboot.management.resources;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.management.authentication.AuthenticationUser;
import com.springboot.management.entity.Assignment;
import com.springboot.management.entity.Course;
import com.springboot.management.entity.FileResponse;
import com.springboot.management.entity.Student;
import com.springboot.management.repository.AssignmentRepository;
import com.springboot.management.repository.CourseRepository;
import com.springboot.management.repository.StudentRepository;
import com.springboot.management.service.FileServices;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ManagementResources {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private FileServices fservice;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private AssignmentRepository assignmentRepository;

	@PostMapping(path="/authentication")
	public ResponseEntity<Void> authenticate(@RequestBody AuthenticationUser user)
	{
		Student temp= studentRepository.getStudentByName(user.getUsername());
		
		if(temp.getName().equalsIgnoreCase(user.getUsername())&&temp.getPassword().equalsIgnoreCase(user.getPassword()))
		{
			logger.info("authenticated");
		return ResponseEntity.noContent().build();
		}
		
		else
		{
			logger.info("not authenticated");
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(path="/courses/{name}")
	public List<Course> getCoursesByStudentName(@PathVariable String name)
	{
		Student temp=studentRepository.getStudentByName(name);
		List<Course> courses= courseRepository.giveNotEnrolledCourses(temp.getId());
		logger.info("COURSES ARE +==> {}",courses);
		return courses;
	}

	
//	GET ASSIGNMENT V.1.0
//	@GetMapping(path="/assignments/{name}")
//	public List<Assignment> getAssignmentsByStudentName(@PathVariable String name)
//	{
//		Student student=studentRepository.getStudentByName(name);
//		List<Course> courses= student.getCourses();
//		List<Assignment> list=new ArrayList<Assignment>();
//		for(Course course:courses)
//		{
//			for(Assignment assignment:course.getAssignments())
//			{
//				list.add(assignment);
//			}
//		}
//		return list;
//	}
	
	@GetMapping(path="/enroll/{username}/{cid}")
	public ResponseEntity<Void> enrollToTheCourse(@PathVariable String username,@PathVariable Long cid)
	{
		Course course = courseRepository.getCourseById(cid);
		if(course!=null)
		{
			studentRepository.addStudentToCourse(course, username);
//			courseRepository.addCourseToStudent(student, cid);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping(path="/assignment/id/{id}")
	public Assignment getAssignmentBy(@PathVariable Long id)
	{
		return assignmentRepository.findAssignmentById(id);
	}
	
	
	@GetMapping(path="/assignments/{name}")
	public List<Assignment> getAssignmentsByStudentNameUpdated(@PathVariable String name)
	{
		Student student=studentRepository.getStudentByName(name);
		List<Assignment> list=student.getAssignments();
		return list;
	}
	
	@PostMapping(path="/submit/{name}/{id}")
	public FileResponse deleteAssignmentforUser(@RequestParam("file") MultipartFile file,@PathVariable String name,@PathVariable Long id) throws IOException
	{
		return fservice.SaveFile(file, name, id);
		
	}
	
	@DeleteMapping(path="/assignment/{name}/{id}")
	public ResponseEntity<?> deleteAssignmentFromStudent(@PathVariable String name, @PathVariable Long id)
	{
		studentRepository.removeAssignmentforUser(name,id);
		return ResponseEntity.noContent().build();
	}
	
	
}
