package com.api.cinema.tickets.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.cinema.tickets.domain.Tickets;
import com.api.cinema.tickets.service.TicketsServiceDB;

@RestController
public class TicketsController {

	private TicketsServiceDB service;
	
	public TicketsController(TicketsServiceDB service) {
		super();
		this.service = service;
	}

	//CRUD
	//Create
	@PostMapping("/create") 
	public ResponseEntity<Tickets> createTicket(@RequestBody Tickets a) {
		return new ResponseEntity<Tickets>(this.service.create(a), HttpStatus.CREATED);
	}
	
	//Read
	@GetMapping("/readAll")
	public ResponseEntity<List<Tickets>>readTicket() {
		return new ResponseEntity<List<Tickets>>(this.service.read(), HttpStatus.FOUND);
	
	}
	 
	//Read by id
	@GetMapping("/readById/{id}")
	public ResponseEntity<Tickets> readById(@PathVariable Long id) {
		return new ResponseEntity<Tickets>(this.service.readOne(id), HttpStatus.FOUND);
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Tickets> update(@PathVariable Long id, @RequestBody Tickets updated) {
		return new ResponseEntity<Tickets>(this.service.update(id, updated), HttpStatus.ACCEPTED);
	}
	
	// DELETE
	@DeleteMapping("/delete/{id}")
	public Tickets delete(@PathVariable Long id) {
		return this.service.delete(id);
	}
		
	@DeleteMapping("/remove/{id}")
	public boolean remove(@PathVariable Long id) {
		return this.service.remove(id);
	}
}