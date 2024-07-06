package com.onlineDemo.ticketService.Entity;

import java.util.List;

public class UserTicket {
   
	private List<Ticket> userTicket;

	public List<Ticket> getUserTicket() {
		return userTicket;
	}

	public void setUserTicket(List<Ticket> userTicket) {
		this.userTicket = userTicket;
	}
	
	
}
