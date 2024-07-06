package com.onlineDemo.eventService.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Event {
	
	@Id
	private Long eventId;
    private String name;
    private String location;
    private String dateTime;
    private Long ticketId;
    
    public Event() {
    	
    }
    public Event(Long eventId, String name, String location, String dateTime,Long ticketId) {
		super();
		this.eventId = eventId;
		this.name = name;
		this.location = location;
		this.dateTime = dateTime;
		this.ticketId=ticketId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
    
	
	

}
