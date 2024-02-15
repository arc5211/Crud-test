package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TaskEntity;

//@EnableJpaRepositories
@Repository
public interface DevCrudRepository extends JpaRepository<TaskEntity, Long> {

	//List<TaskEntity> findAll();
	
	List<TaskEntity> findById(long id);
	List<TaskEntity> findByTitle(String Task);
	List<TaskEntity> deleteById(long id);
	
}
