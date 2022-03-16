package com.api.cinema.tickets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.cinema.tickets.domain.Tickets;
import com.api.cinema.tickets.repo.TicketsRepo;

@Service
public class TicketsServiceDB implements TicketsInterface{
	
	private TicketsRepo repo;
	
	public TicketsServiceDB(TicketsRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Tickets create(Tickets x) {
		return this.repo.save(x);
	}

	@Override
	public List<Tickets> read() {
		return this.repo.findAll();
	}
	
	public Tickets readOne(Long id) {
		Optional<Tickets> optRead = this.repo.findById(id);
		return optRead.orElse(null);
	}

	@Override
	public Tickets update(Long id, Tickets y) {
		Optional<Tickets> optAni =  this.repo.findById(id);
		Tickets found = optAni.get();
		found.setTitle(y.getTitle());
		found.setScreen(y.getScreen());
		found.setSeatRow(y.getSeatRow());
		found.setSeatNum(y.getSeatNum());
		return this.repo.save(found);
	}

	@Override
	public Tickets delete(Long id) {
		Optional<Tickets> toDelete = this.repo.findById(id);
		this.repo.deleteById(id);
		return toDelete.orElse(null);
	}
	
	public boolean remove(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
