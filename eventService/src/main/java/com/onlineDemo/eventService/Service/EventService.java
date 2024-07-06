package com.onlineDemo.eventService.Service;

import java.util.List;

import com.onlineDemo.eventService.Entity.Event;

public interface EventService {
	
	public Event addEvent(Event event);
	
	public List<Event> getAllEvent();
	
	public Event getEvent(Long eventId);
	
	public void updateEvent(Event event);
	
	public void deleteEvent(Long eventId);

}
