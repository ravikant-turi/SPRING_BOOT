package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamp; 
	private String message;
	private String Details;
	/**
	 * @param localDateTime
	 * @param message
	 * @param details
	 */
//	public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
//		super();
//		this.timestamp = localDateTime;
//		this.message = message;
//		Details = details;
//	}
	public ErrorDetails(LocalDateTime localDateTime, String message2, String description) {
		// TODO Auto-generated constructor stub
		super();
		this.timestamp = localDateTime;
		this.message=message2;
	    this.Details=description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	
	

}
