package com.onlineDemo.userService.Entity;

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
