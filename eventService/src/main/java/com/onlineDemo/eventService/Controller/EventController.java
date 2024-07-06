package com.onlineDemo.eventService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineDemo.eventService.Entity.Event;
import com.onlineDemo.eventService.Service.EventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	EventService eventService;
	@ApiResponses({
		@ApiResponse(responseCode = "200",content= {
				@Content(mediaType = "application/json",
				schema=@Schema(implementation = Event.class))
				}),
		@ApiResponse(responseCode = "404",
		             description = "event not found",
		             content = @Content)})
	@PostMapping
	public Event addEvent(@RequestBody Event event) {
		return eventService.addEvent(event);
	}
	
	@Tag(name="get",description="get methods of event api")
	@GetMapping
	public List<Event> getAllEvent(){
		return eventService.getAllEvent();
	}
	// rest template
	@Tag(name="get",description="get methods of event api")
	@GetMapping("/{eventId}")
	public Event getEvent(@PathVariable Long eventId) {
		return eventService.getEvent(eventId);
	}
	@Operation(summary = "updating an event",
			description = "update an existing event. The response is updated on event table")
	@PutMapping("/{eventId}")
	public void updateEvent(@RequestBody Event event) {
		eventService.updateEvent(event);
	}
	@Operation(summary = "deleting an event",
			description = "delete an existing event. The response is deleted on event table")
	@DeleteMapping("/{eventId}")
	public void deleteEvent(@PathVariable Long eventId) {
		eventService.deleteEvent(eventId);
	}
	

}
