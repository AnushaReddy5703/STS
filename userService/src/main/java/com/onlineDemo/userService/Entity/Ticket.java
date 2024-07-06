package com.onlineDemo.userService.Entity;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {
	
	@Id
	private Long ticketId;
	private Long eventId;
	private String userName;
	private int seatNumber;
	
	@ManyToOne
	public User user;
	
	public Ticket() {
		
	}
	

	public Ticket(Long ticketId, Long eventId, String userName, int seatNumber, Long userId) {
		super();
		this.ticketId = ticketId;
		this.eventId = eventId;
		this.userName = userName;
		this.seatNumber = seatNumber;
		this.user = new User(userId,"","",null,null);
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", eventId=" + eventId + ", userName=" + userName + ", seatNumber="
				+ seatNumber + ", user=" + user + "]";
	}

	
	
	
}
