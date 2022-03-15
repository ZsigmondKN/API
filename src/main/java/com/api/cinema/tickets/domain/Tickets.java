package com.api.cinema.tickets.domain;

public class Tickets {

	//Variables - columns in the table
	private Long id;
	private String Title;
	private int Screen;
	private char Row;
	private int SeatNum;
	
	//Constructors - 3 types
	public Tickets() {
		super();
	}
	public Tickets(String title, int screen, char row, int seatNum) {
		super();
		Title = title;
		Screen = screen;
		Row = row;
		SeatNum = seatNum;
	}
	public Tickets(Long id, String title, int screen, char row, int seatNum) {
		super();
		this.id = id;
		Title = title;
		Screen = screen;
		Row = row;
		SeatNum = seatNum;
	}
	
	//Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getScreen() {
		return Screen;
	}
	public void setScreen(int screen) {
		Screen = screen;
	}
	public char getRow() {
		return Row;
	}
	public void setRow(char row) {
		Row = row;
	}
	public int getSeatNum() {
		return SeatNum;
	}
	public void setSeatNum(int seatNum) {
		SeatNum = seatNum;
	}
}