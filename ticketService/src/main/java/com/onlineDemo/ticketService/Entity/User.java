package com.onlineDemo.ticketService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	private Long userId;
	private String fullName;
	private String email;
	private Long ticketId;
	private Long eventId;
	
	public User() {
		
	}
	
	public User(Long userId, String fullName, String email,Long ticketId,Long eventId) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.ticketId=ticketId;
		this.eventId=eventId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}  
	
	
	

}
