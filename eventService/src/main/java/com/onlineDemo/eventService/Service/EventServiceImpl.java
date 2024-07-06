package com.onlineDemo.eventService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineDemo.eventService.Entity.Event;
import com.onlineDemo.eventService.Repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	
	
	@Autowired
	EventRepository eventRepository;

	public Event addEvent(Event event) {
		return eventRepository.save(event);
	}

	public List<Event> getAllEvent() {
		List<Event> eventList=new ArrayList<>();
		eventRepository.findAll().forEach(eventList::add);
		return eventList;
	}

	//rest template
	public Event getEvent(Long eventId) {
		return eventRepository.findById(eventId).get();
	}

	public void updateEvent(Event event) {
        eventRepository.save(event)	;	
	}

	public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);		
	}

}
