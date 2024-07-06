package com.onlineDemo.eventService.Test;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;
import com.onlineDemo.eventService.Entity.Event;
import com.onlineDemo.eventService.Repository.EventRepository;
import com.onlineDemo.eventService.Service.EventServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EventTest {
	
	@Autowired
	
	EventServiceImpl service;
	
	@MockBean
	EventRepository eventRepository;
	
	@Test
	public void testGetEvent() {
		when(eventRepository.findById(1L)).thenReturn(prepareEventData());
		
		Event event=service.getEvent(1L);
		assertEquals(1L,event.getEventId());
		assertEquals("Concert",event.getName());
	}
	
	private Optional<Event> prepareEventData(){
		Event e=new Event();
		e.setEventId(1L);
		e.setName("Concert");
		return Optional.of(e);
	}
	

}
