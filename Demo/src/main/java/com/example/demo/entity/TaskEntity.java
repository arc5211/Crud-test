package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TASK")
public class TaskEntity implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private String title;
	private String description;
	@Column(name="Duedate")
	private String duedate;
	
	public TaskEntity() {
		// TODO Auto-generated constructor stub
	}
	public TaskEntity(long id, String title, String description,String duedate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.duedate = duedate;
	}
	
	/*
	@Override
	public String toString() {
		return "TaskEntity [id=" + id + ", title=" + title + ", decription=" + decription + ", dueDate=" + dueDate
				+ "]";
	} */
	
}
