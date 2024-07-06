package com.onlineDemo.ticketService.Service;

import java.util.List;

import com.onlineDemo.ticketService.Entity.Ticket;

public interface TicketService {

	public Ticket addTicket(Ticket ticket);
	
	public List<Ticket> getAllTicket();
	
	public Ticket getTicket(Long ticketId);
	
	public Ticket saveTicket(Ticket ticket,Long ticketId);
	
	public void addTicketToUser(Ticket ticket,Long userId);
	
	public List<Ticket> getEveryTicket(Long userId);
	
	public Ticket GetATicket(Long ticketId,Long userId);
	
	public void deleteTicket(Long ticketId,Long userId);
	
	public void updateTicket(Ticket ticket,Long ticketId);
	
	//public List<Ticket> getUserTicket(Long ticketId);
}
