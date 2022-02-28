package com.springboot.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.management.entity.FileDb;

@Repository
public interface FileRepository extends JpaRepository<FileDb, Long>{


}
