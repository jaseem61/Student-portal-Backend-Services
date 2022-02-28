package com.springboot.management.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


public class FileResponse {
	
	private Long id;
	private String name;
	private String type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public FileResponse(Long id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	@Override
	public String toString() {
		return "FileResponse [name=" + name + "]";
	}
	
	
	
	
}
