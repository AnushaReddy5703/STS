package com.onlineDemo.ticketService.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineDemo.ticketService.Entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long>{


}
