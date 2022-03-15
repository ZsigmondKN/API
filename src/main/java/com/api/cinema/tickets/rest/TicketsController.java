package com.api.cinema.tickets.rest;

import java.util.ArrayList;
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

@RestController
public class TicketsController {

	//Store info
	private List<Tickets> tickets = new ArrayList<>();
	
	//CRUD
	//Create
	@PostMapping("/create") 
	public ResponseEntity<Tickets> createTicket(@RequestBody Tickets a) {
		a.setId((long) this.tickets.indexOf(a));
		this.tickets.add(a);
		Tickets created = this.tickets.get(this.tickets.size()-1);
		return new ResponseEntity<Tickets>(created, HttpStatus.CREATED);
	}
	
	//Read
	@GetMapping("/readAll")
	public ResponseEntity<List<Tickets>>readTicket() {
		return new ResponseEntity<List<Tickets>>(this.tickets, HttpStatus.FOUND);
	}
	
	//Read by id
	@GetMapping("/readById/{id}")
	public ResponseEntity<Tickets> readById(@PathVariable int id) {
		return new ResponseEntity<Tickets>(this.tickets.get(id), HttpStatus.FOUND);
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Tickets> update(@PathVariable int id, @RequestBody Tickets updated) {
		this.tickets.set(id, updated);
		return new ResponseEntity<Tickets>(this.tickets.get(id), HttpStatus.ACCEPTED);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Tickets> delete(@PathVariable int id) {
		return new ResponseEntity<Tickets>(this.tickets.remove(id), HttpStatus.ACCEPTED);
	}
}