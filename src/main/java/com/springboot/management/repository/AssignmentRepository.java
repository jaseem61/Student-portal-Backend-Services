package com.springboot.management.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.management.entity.Assignment;


@Repository
@Transactional
public class AssignmentRepository {

	@Autowired
	EntityManager em;
	
	public Assignment findAssignmentById(Long id)
	{
		return em.find(Assignment.class, id);
	}
	
	
}
