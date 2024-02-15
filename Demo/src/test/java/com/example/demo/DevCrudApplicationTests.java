package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.example.demo.controller.DevCrudController;
import com.example.demo.entity.TaskEntity;
import com.example.demo.helper.CommonConstants;
import com.example.demo.repository.DevCrudRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DevCrudApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DevCrudApplicationTests {

	@Autowired
	DevCrudController devCrudController;
	@Autowired
	DevCrudRepository devCrudRepository;
	@Autowired
	TestRestTemplate restTemplate;
	
	HttpHeaders headers = new HttpHeaders();

	@Test
	void createTaskTest() {
		String url = CommonConstants.CREATE_TASK_ENDPOINT;
		String plainCreds = CommonConstants.API_CRED;
		// byte[] plainCredsBytes = plainCreds.getBytes();
		// byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		// String base64Creds = new String(base64CredsBytes);
		TaskEntity testTask = new TaskEntity();
		testTask.setId(11);
		testTask.setTitle("Task11");
		testTask.setDescription("Description11");
		testTask.setDuedate("05/06/2024");
	// cred for API auth
		String encoded = CommonConstants.ENCODED_CRED;
		headers.add("Authorization", "Basic " + encoded);
		HttpEntity<TaskEntity> getTaskEntity = new HttpEntity<TaskEntity>(testTask,headers);
		ResponseEntity<TaskEntity> response = restTemplate.exchange(url,HttpMethod.POST,getTaskEntity,TaskEntity.class);
		assertEquals(testTask.getTitle(),response.getBody().getTitle());
	}
	
	@Test
	void updateTaskTest() {
		String findID="10";
		String url = CommonConstants.UPDATE_TASK_ENPOINT+ "10";
		String plainCreds = CommonConstants.API_CRED;
		// byte[] plainCredsBytes = plainCreds.getBytes();
		// byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		// String base64Creds = new String(base64CredsBytes);
		TaskEntity testTask = new TaskEntity();
	
		testTask.setTitle("Task101");
		testTask.setDescription("Description101");
		testTask.setDuedate("05/06/2024");
	// cred for API auth
		String encoded = CommonConstants.ENCODED_CRED;
		headers.add("Authorization", "Basic " + encoded);
		HttpEntity<TaskEntity> getTaskEntity = new HttpEntity<TaskEntity>(testTask,headers);
		ResponseEntity<TaskEntity> response = restTemplate.exchange(url,HttpMethod.PUT,getTaskEntity,TaskEntity.class);
		assertEquals(testTask.getTitle(),response.getBody().getTitle());
	}
	
	@Test
	void deleteByTaskTest() {
		String findID="7";
		String url = CommonConstants.DELETE_TASK_ENPOINT+ findID;
		String plainCreds = CommonConstants.API_CRED;
		// byte[] plainCredsBytes = plainCreds.getBytes();
		// byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		// String base64Creds = new String(base64CredsBytes);
		TaskEntity testTask = new TaskEntity();
	
	// cred for API auth
		String encoded = CommonConstants.ENCODED_CRED;
		headers.add("Authorization", "Basic " + encoded);
		HttpEntity<TaskEntity> getTaskEntity = new HttpEntity<TaskEntity>(testTask,headers);
		ResponseEntity<TaskEntity> response = restTemplate.exchange(url,HttpMethod.DELETE,getTaskEntity,TaskEntity.class);
		assertEquals(HttpStatus.ACCEPTED,response.getStatusCode());
	}
	//@Test
	void findTaskByIdTest() {
		String findID="10";
		String url = CommonConstants.RETREIVE_ID_ENPOINT+ findID;
		String plainCreds = CommonConstants.API_CRED;
		// byte[] plainCredsBytes = plainCreds.getBytes();
		// byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		// String base64Creds = new String(base64CredsBytes);
		TaskEntity testTask = new TaskEntity();
		Map<String,String> parameter = new HashMap<>();
	// cred for API auth
		String encoded = CommonConstants.ENCODED_CRED;
		headers.add("Authorization", "Basic " + encoded);
		HttpEntity<String> getTaskEntity = new HttpEntity<>(null,headers);
		ResponseEntity<TaskEntity> response = restTemplate.exchange(url,HttpMethod.GET,getTaskEntity, new ParameterizedTypeReference<TaskEntity>(){},parameter);
		assertEquals(testTask.getTitle(),response.getBody().getTitle());
	}

}
