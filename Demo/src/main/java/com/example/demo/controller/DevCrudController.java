package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.example.demo.entity.TaskEntity;
import com.example.demo.model.CrudTaskDecriptor;
import com.example.demo.repository.DevCrudRepository;


import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
@Validated
@Slf4j
public class DevCrudController {

	@Autowired
	DevCrudRepository devCrudRepository;
	
	@GetMapping("/task/{id}")
	public ResponseEntity<List<TaskEntity>> getTaskById(@PathVariable("id") long id) {
		//Optional<TaskEntity> taskData;
		List<TaskEntity> taskData = null;
		System.out.println("id entered"+id);
		try {
			//String task = "Task2";
			taskData = devCrudRepository.findById(id);
			//taskData = devCrudRepository.findByTitle(task);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task data "+taskData);
		if (taskData != null) {
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Total-Elements", 
        		Integer.toString(taskData.size()));
		return new ResponseEntity<List<TaskEntity>>(taskData,responseHeaders,HttpStatus.OK);  
		}else {
			return new ResponseEntity<List<TaskEntity>>(HttpStatus.NOT_FOUND);  
		}
	}
	
	@DeleteMapping("/taskDelete/{id}")
	public ResponseEntity<List<TaskEntity>> deleteTaskById(@PathVariable("id") long id) {
		//Optional<TaskEntity> taskData;
		List<TaskEntity> taskData = null;
		System.out.println("id entered"+id);
		try {
			taskData = devCrudRepository.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task data "+taskData);
		
		if (taskData != null && !taskData.isEmpty()) {
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Total-Elements", 
        		Integer.toString(taskData.size()));
		return new ResponseEntity<List<TaskEntity>>(HttpStatus.NOT_FOUND);  
		}else {
			return new ResponseEntity<List<TaskEntity>>(HttpStatus.ACCEPTED);  
		}
	}
	@PutMapping("/updateTask/{id}")
	public ResponseEntity<TaskEntity> UpdateTaskById(@PathVariable("id") long id,@RequestBody TaskEntity taskEntity) {
		//Optional<TaskEntity> taskData;
		List<TaskEntity> taskData = null;
		CrudTaskDecriptor crudTaskDecriptor = new CrudTaskDecriptor();
		System.out.println("id entered"+id);
		try {
			taskData = devCrudRepository.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task data "+taskData);
		
		if (taskData != null) {
			TaskEntity updateTask = taskData.get(0);
			updateTask.setTitle(Objects.toString(taskEntity.getTitle(), taskData.get(0).getTitle()));
			updateTask.setDescription(Objects.toString(taskEntity.getDescription(),taskData.get(0).getDescription()));
			updateTask.setDuedate(Objects.toString(taskEntity.getDuedate(),taskData.get(0).getDuedate()));
			//crudTaskDecriptor.setStatus("success");
		return new ResponseEntity<>(devCrudRepository.save(updateTask),HttpStatus.OK);  
		}else {
			//crudTaskDecriptor.setStatus("failed");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
		}
	}	
	//create task API
	@PostMapping("/task")
	public ResponseEntity<TaskEntity> createTutorial(@RequestBody TaskEntity taskEntity) {
		try {
			TaskEntity task = devCrudRepository
					.save(new TaskEntity(taskEntity.getId(),taskEntity.getTitle(), taskEntity.getDescription(), taskEntity.getDuedate()));
			return new ResponseEntity<>(task, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	@GetMapping("/allTask")
	public ResponseEntity<List<TaskEntity>> getAllTask() {
		//Optional<TaskEntity> taskData;
		List<TaskEntity> taskData = null;
		
		try {	
			taskData = devCrudRepository.findAll();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task data "+taskData);
		if (taskData != null) {
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Total-Elements", 
        		Integer.toString(taskData.size()));
		return new ResponseEntity<List<TaskEntity>>(taskData,responseHeaders,HttpStatus.OK);  
		}else {
			return new ResponseEntity<List<TaskEntity>>(HttpStatus.NOT_FOUND);  
		}
	}
}
