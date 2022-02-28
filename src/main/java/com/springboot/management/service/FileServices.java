package com.springboot.management.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.management.entity.FileDb;
import com.springboot.management.entity.FileResponse;
import com.springboot.management.repository.FileRepository;


@Service
public class FileServices {
	
	@Autowired
	private FileRepository repository;
	
	public FileResponse SaveFile(MultipartFile file,String uname,Long assignment_id) throws IOException
	{
		FileDb temp= new FileDb(file.getName(),file.getContentType(),uname,assignment_id,file.getBytes());
		repository.save(temp);
		return new FileResponse(temp.getId(),temp.getName(),temp.getType());
	}
	
	public FileDb fileById(Long id)
	{
		return repository.getById(id);
	}
	
	public List<FileDb> allFile()
	{
		return repository.findAll();
	}

}
