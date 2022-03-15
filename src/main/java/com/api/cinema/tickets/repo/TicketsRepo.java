package com.api.cinema.tickets.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.cinema.tickets.domain.Tickets;

@Repository
public interface TicketsRepo extends JpaRepository<Tickets, Long>{

}
