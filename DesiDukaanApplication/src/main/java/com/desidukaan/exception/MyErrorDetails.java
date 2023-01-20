package com.desidukaan.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class MyErrorDetails {
	
	private LocalDateTime timestamp;
	private String message;
	private HttpStatus httpStatus;
	private String details;
	
	public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public MyErrorDetails(LocalDateTime timestamp, String message, HttpStatus httpStatus, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.httpStatus = httpStatus;
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "MyErrorDetails [timestamp=" + timestamp + ", message=" + message + ", httpStatus=" + httpStatus
				+ ", details=" + details + "]";
	}

}
