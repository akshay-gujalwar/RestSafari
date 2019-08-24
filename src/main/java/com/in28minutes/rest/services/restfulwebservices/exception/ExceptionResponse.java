package com.in28minutes.rest.services.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timeStam;
	private String message;
	private String details;
	
	public ExceptionResponse(Date timeStam, String message, String details) {
		super();
		this.timeStam = timeStam;
		this.message = message;
		this.details = details;
	}
	
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getTimeStam() {
		return timeStam;
	}
	public void setTimeStam(Date timeStam) {
		this.timeStam = timeStam;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
