package com.prodyna.academy.patty.domain;

public class EventMessage {
	private String message;
	
	public EventMessage(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
