package com.api.cinema.tickets.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.api.cinema.tickets.domain.Tickets;
import com.api.cinema.tickets.repo.TicketsRepo;

@SpringBootTest
@ActiveProfiles("test")
public class TicketsServiceDBTest {
	
	private Tickets input;
	private Tickets returned;
	
	@Autowired //class tested
	private TicketsServiceDB serv;
	
	@MockBean //class depended on
	private TicketsRepo rep;
	
	@BeforeEach
	void setUp() {
		input = new Tickets("Avatar",5L,'H',6L);
		returned = new Tickets(1L,"Avatar",5L,'H',6L);
	}
	
	@Test
	void testCreate() {
		//Given
		
		//When
		Mockito.when(this.rep.save(input)).thenReturn(returned);
		//Then
		assertThat(this.serv.create(input)).isEqualTo(returned);
		//Verify
		Mockito.verify(this.rep, Mockito.times(1)).save(input);
	}
	
	@Test
	void testRead() {
		//Given
		List<Tickets> readList = new ArrayList<>();
		readList.add(input);
		//When
		Mockito.when(this.rep.findAll()).thenReturn(readList);
		//Then
		assertThat(this.serv.read()).isEqualTo(readList);
		//Verify
		Mockito.verify(this.rep, Mockito.times(1)).findAll();	
	}
	
	@Test
	void testReadOne() {
		//Given
		Long id = 1L;
		//Variable
		Optional<Tickets> optTic = Optional.of(returned);
		//When
		Mockito.when(this.rep.findById(id)).thenReturn(optTic);
		//Then
		assertThat(this.serv.readOne(id)).isEqualTo(returned);
		//Verify
		Mockito.verify(this.rep, Mockito.times(1)).findById(id);	
	}
	
	@Test
	void testUpdate() {
		// Given
		Long id = 1L;
		// To update
		Tickets toUpdate = new Tickets("Avatar",5L,'H',6L);
		// To object
		Optional<Tickets> opt = Optional.of(returned);
		// Update
		Tickets updated = new Tickets(id, toUpdate.getTitle(), toUpdate.getScreen(), toUpdate.getSeatRow(), toUpdate.getSeatNum());
		// When
		Mockito.when(this.rep.findById(id)).thenReturn(opt);
		Mockito.when(this.rep.save(updated)).thenReturn(updated);
		// Then
		assertThat(this.serv.update(id, toUpdate)).isEqualTo(updated);
		// Verify
		Mockito.verify(this.rep, Mockito.times(1)).findById(id);
		Mockito.verify(this.rep, Mockito.times(1)).save(updated);
	}
	
	@Test
	void testDelete() {
		//Given
		Long id = 1L;
		//Variable
		Optional<Tickets> optTic = Optional.of(returned);
		//When
		Mockito.when(this.rep.findById(id)).thenReturn(optTic);
		//Then
		assertThat(this.serv.delete(id)).isEqualTo(returned);
		//Verify
		Mockito.verify(this.rep, Mockito.times(1)).deleteById(id);
		Mockito.verify(this.rep, Mockito.times(1)).findById(id);	
	}
	
	@Test
	void testRemove() {
		//Given
		Long id = 1L;
		//When
		Mockito.when(this.rep.existsById(id)).thenReturn(false);
		//Then
		assertThat(this.serv.remove(id)).isTrue();
		//Verify
		Mockito.verify(this.rep, Mockito.times(1)).deleteById(id);
		Mockito.verify(this.rep, Mockito.times(1)).existsById(id);	
	}
	
	
	@AfterEach
	void clear() {
		
	}
}
