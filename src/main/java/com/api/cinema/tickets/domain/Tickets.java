package com.api.cinema.tickets.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Tickets {

	//Variables - columns in the table
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String title;
	private Long screen;
	private char seatRow;
	private Long seatNum;
	
	//Constructors - 3 types
	public Tickets() {
		super();
	}
	public Tickets(String title, Long screen, char seatRow, Long seatNum) {
		super();
		this.title = title;
		this.screen = screen;
		this.seatRow = seatRow;
		this.seatNum = seatNum;
	}
	public Tickets(Long id, String title, Long screen, char seatRow, Long seatNum) {
		super();
		this.id = id;
		this.title = title;
		this.screen = screen;
		this.seatRow = seatRow;
		this.seatNum = seatNum;
	}
	
	//Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getScreen() {
		return screen;
	}
	public void setScreen(Long screen) {
		this.screen = screen;
	}
	public char getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(char seatRow) {
		this.seatRow = seatRow;
	}
	public Long getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(Long seatNum) {
		this.seatNum = seatNum;
	}
}