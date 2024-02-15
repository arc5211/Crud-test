package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CrudTaskDecriptor;
import com.example.demo.repository.DevCrudRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DevCrudTaskService {

	@Autowired
	 DevCrudRepository devCrudRepository;
	
	public CrudTaskDecriptor createTask(CrudTaskDecriptor crudTaskDecriptor) {
		
		
		return crudTaskDecriptor;
		
	}
}
