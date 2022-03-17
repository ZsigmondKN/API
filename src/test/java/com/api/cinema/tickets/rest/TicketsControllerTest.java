package com.api.cinema.tickets.rest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.api.cinema.tickets.domain.Tickets;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc//acts like postman
@Sql(scripts = {"classpath:tickets-schema.sql","classpath:tickets-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)//Used to pre-populate h2db
@ActiveProfiles("test")//run on test db
public class TicketsControllerTest {

	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper map;//Interprets JSON
	
	@Test
	void testCreate() throws Exception {
		//Request
		//body
		Tickets create = new Tickets("Siderman",1L,'K',14L);
		//convert to JASON STRIGN
		String createJSON = this.map.writeValueAsString(create);
		//build mock request
		RequestBuilder mocRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(createJSON);
		//Response
		Tickets saved = new Tickets(2L,"Siderman",1L,'K',14L);
		//convert to JASON STRIGN
		String savedJSON = this.map.writeValueAsString(saved);
		//test response
		ResultMatcher matchStatus = status().isCreated();
		ResultMatcher matchBody = content().json(savedJSON);
		//perform test
		this.mock.perform(mocRequest).andExpect(matchStatus).andExpect(matchBody);
	}
	
	@Test
	void testRemove() throws Exception {
		//Request
		Long id = 1L;
		RequestBuilder mockRequest = delete("/remove/"+id);
		//Response
		ResultMatcher status = status().isOk();
		ResultMatcher body = content().string("true");
		//Test
		this.mock.perform(mockRequest).andExpect(body).andExpect(status);
	}
}
