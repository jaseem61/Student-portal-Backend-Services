package com.springboot.management.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FileDb {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String type;
	
	private String username;
	
	private Long assignment_id;
	
	@Lob
	private byte[] Data;
	
	public FileDb()
	{
		
	}
	

	public FileDb(String name, String type, String username, Long assignment_id, byte[] data) {
		super();
		this.name = name;
		this.type = type;
		this.username = username;
		this.assignment_id = assignment_id;
		Data = data;
	}



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Long getAssignment_id() {
		return assignment_id;
	}


	public void setAssignment_id(Long assignment_id) {
		this.assignment_id = assignment_id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return Data;
	}

	public void setData(byte[] data) {
		Data = data;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "FileDb [name=" + name + "]";
	}
	
	
}
