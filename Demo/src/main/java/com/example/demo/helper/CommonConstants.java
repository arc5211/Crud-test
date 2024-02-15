package com.example.demo.helper;

public final class CommonConstants {
	private CommonConstants() {
	}
	
	public static final String ERROR= "Error";
	public static final String SUCCESS = "Success";
	public static final String FAILURE = "Failure";
	public static final String CREATE_TASK_ENDPOINT = "http://localhost:8080/api/task";
	public static final String UPDATE_TASK_ENPOINT = "http://localhost:8080/api/updateTask/";
	public static final String DELETE_TASK_ENPOINT = "http://localhost:8080/api/taskDelete/";
	public static final String RETREIVE_ID_ENPOINT = "http://localhost:8080/api/task/";
	public static final String RETREIVE_ALL_ENPOINT = "http://localhost:8080/api/allTask";
	public static final String API_CRED="admin:admin";
	public static final String ENCODED_CRED = "YWRtaW46YWRtaW4=";
}
