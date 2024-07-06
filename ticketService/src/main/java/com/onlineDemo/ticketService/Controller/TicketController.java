package com.onlineDemo.ticketService.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineDemo.ticketService.Entity.Ticket;
import com.onlineDemo.ticketService.Entity.User;
import com.onlineDemo.ticketService.Service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/tickets")
	public Ticket addTicket(@RequestBody Ticket ticket) {
		return ticketService.addTicket(ticket);
	}
	
	@GetMapping("/tickets")
	public List<Ticket> getAllTicket(){
		return ticketService.getAllTicket();
	}
	//rest template
	@GetMapping("/tickets/{ticketId}")
	public Ticket getTicket(@PathVariable Long ticketId) {
		return ticketService.getTicket(ticketId);
	}
	@PutMapping("/tickets/{ticketId}")
	public Ticket saveTicket(@RequestBody Ticket ticket,@PathVariable Long ticketId) {
		return ticketService.saveTicket(ticket,ticketId);
	}
	
	
	// Mapping
	
	@PostMapping("/users/{userId}/ticket")
	public void addTicketToUser(@RequestBody Ticket ticket,@PathVariable Long userId) {
		ticket.setUser(new User(userId,"","",null,null)); 
		 ticketService.addTicketToUser(ticket,userId);
	}
	
	@GetMapping("/users/{userId}/ticket")
	public List<Ticket> getEveryTicket(@PathVariable Long userId){
		return ticketService.getEveryTicket(userId);
	}
	
    @GetMapping("/users/{userId}/ticket/{ticketId}")
    public Ticket GetATicket(@PathVariable Long ticketId,@PathVariable Long userId) {
    	return ticketService.GetATicket(ticketId,userId);
    }
    
    @DeleteMapping("/users/{userId}/ticket/{ticketId}")
    public void deleteTicket(@PathVariable Long ticketId,@PathVariable Long userId) {
    	ticketService.deleteTicket(ticketId,userId);
    }
    
    @PutMapping("/users/{userId}/ticket/{ticketId}")
    public void updateTicket(@RequestBody Ticket ticket,@PathVariable Long ticketId) {
    	ticketService.updateTicket(ticket,ticketId);
    }
	
    // used for rest template
    
//    @GetMapping("ticketsdata/{ticketId}")
//    public UserTicket getUserTicket(@PathVariable Long ticketId) {
//    	List<Ticket> ticketList=ticketService.getUserTicket(ticketId);
//    	
//    	UserTicket user=new UserTicket();
//		user.setUserTicket(ticketList);
//		return user;
//    	
//    }
	

}
