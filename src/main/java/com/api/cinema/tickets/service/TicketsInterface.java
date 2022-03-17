package com.api.cinema.tickets.service;

import java.util.List;

import com.api.cinema.tickets.domain.Tickets;

public interface TicketsInterface {
	
	//abstract CRUD methods
	
	Tickets create(Tickets x);
	
	List<Tickets> read();

	Tickets update(Long id, Tickets y);

	Tickets delete(Long id);
}