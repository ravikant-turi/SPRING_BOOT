package com.example.todowebapp.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.constraints.Size;
//data base

public class Todo {
	
	private int id;
	private String username;
//    @Size(min=10, message="enter atleast  10 charracter")
    private String description;
	private LocalDate targetData;
	private boolean done;
	
	/**
	 * @param id
	 * @param username
	 * @param description
	 * @param targetData
	 * @param done
	 */
	public Todo(int id, String username, String description, LocalDate targetData, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetData = targetData;
		this.done = done;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the targetData
	 */
	public LocalDate getTargetData() {
		return targetData;
	}

	/**
	 * @param targetData the targetData to set
	 */
	public void setTargetData(LocalDate targetData) {
		this.targetData = targetData;
	}

	/**
	 * @return the done
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * @param done the done to set
	 */
	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetData="
				+ targetData + ", done=" + done +"]";
	}

	
	

}
