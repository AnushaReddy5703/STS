package com.onlineDemo.ticketService.Service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineDemo.ticketService.Entity.Ticket;
import com.onlineDemo.ticketService.Repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;
	
	public Ticket addTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public List<Ticket> getAllTicket() {
		return ticketRepository.findAll();
	}

	public Ticket getTicket(Long ticketId) {
		return ticketRepository.findById(ticketId).get();
	}

	public Ticket saveTicket(Ticket ticket,Long ticketId) {
		return ticketRepository.save(ticket);
	}
	
	//Mapping
	
	public void addTicketToUser(Ticket ticket,Long userId) {
		 ticketRepository.save(ticket);
	}

	public List<Ticket> getEveryTicket(Long userId) {
		return ticketRepository.findAll();		
	}

	public Ticket GetATicket(Long ticketId,Long userId) {
		return ticketRepository.findById(ticketId).get();
	}

	public void deleteTicket(Long ticketId,Long userId) {
		ticketRepository.deleteById(ticketId);	
	}

	public void updateTicket(Ticket ticket,Long ticketId) {
		ticketRepository.save(ticket);
	}

	// Rest Template
//	public List<Ticket> getUserTicket(Long ticketId) {
//		return ticketRepository.findAll();
//	}

	

}
