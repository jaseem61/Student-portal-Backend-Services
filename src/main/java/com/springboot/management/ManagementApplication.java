package com.springboot.management;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.management.entity.Course;
import com.springboot.management.repository.CourseRepository;

@SpringBootApplication
public class ManagementApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}

	@Autowired
	CourseRepository repository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		List<Course> courses =repository.giveNotEnrolledCourses(30001L);
//		logger.info("COURSES ARE ==> {}",courses);
	}

}
