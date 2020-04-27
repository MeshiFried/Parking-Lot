package com.parking.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.parking.production.Ticket;

public class TicketsTest {
	
	static SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm");
	
	@Test
	public void testGetDays() throws ParseException {
		Date entry = format.parse("4/24 00:00");
		Date leave = format.parse("4/26 00:00");
		int expectedDays = 2;
		
		Ticket ticket = new Ticket(entry);
		ticket.setLeave(leave);
		
		int actualDays = ticket.getDays();
		
		Assert.assertEquals(expectedDays, actualDays);
	}

	@Test
	public void testGetHours() throws ParseException {
		Date entry = format.parse("4/24 12:00");
		Date leave = format.parse("4/24 15:00");
		int expectedHours = 3;
		
		Ticket ticket = new Ticket(entry);
		ticket.setLeave(leave);
		
		int actualHours = ticket.getHours();
		
		Assert.assertEquals(expectedHours, actualHours);
	}
	
	@Test
	public void testGetMinutes() throws ParseException {
		Date entry = format.parse("4/24 00:00");
		Date leave = format.parse("4/24 00:25");
		int expectedMinutes = 25;
		
		Ticket ticket = new Ticket(entry);
		ticket.setLeave(leave);
		
		int actualMinutes = ticket.getMinutes();
		
		Assert.assertEquals(expectedMinutes, actualMinutes);
	}

}
