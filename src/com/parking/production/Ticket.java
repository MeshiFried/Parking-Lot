package com.parking.production;

import java.util.Date;

public class Ticket implements ITicket {
	Date entry;
	Date leave;
	public Ticket(Date entry) {
		this.entry = entry;
	}
	
	public void setLeave(Date leave) {
		this.leave = leave;
	}
	
	public int getDays() {
		long differenceInMillis = leave.getTime() - entry.getTime();
		return (int) (differenceInMillis / 1000 / 60 / 60 / 24);
	}
	
	public int getHours() {
		long differenceInMillis = leave.getTime() - entry.getTime();
		return (int) (differenceInMillis / 1000 / 60 / 60) % 24;
	}
	
	public int getMinutes() {
		long differenceInMillis = leave.getTime() - entry.getTime();
		return (int) (differenceInMillis / 1000 / 60) % 60;
	}
}
