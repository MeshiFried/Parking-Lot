package com.parking.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.parking.production.ParkingLot;
import com.parking.production.Ticket;

import org.junit.Assert;

public class ParkingLotRulesTest {

	@Mock
	Ticket ticket;
	
	ParkingLot parkingLot;
	
	int expectedCharge;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.parkingLot = new ParkingLot();
	}
	
	
	@Test
	public void test29Minutes() {
		expectedCharge = 0;
		Mockito.when(ticket.getDays()).thenReturn(0);
		Mockito.when(ticket.getMinutes()).thenReturn(29);
		Mockito.when(ticket.getHours()).thenReturn(0);
		int actualCharge = parkingLot.getCharges(ticket);
		Assert.assertEquals(expectedCharge, actualCharge );
		
	}
	
	@Test
	public void test30Minutes0Days() {
		expectedCharge = 0;
		Mockito.when(ticket.getDays()).thenReturn(0);
		Mockito.when(ticket.getMinutes()).thenReturn(30);
		Mockito.when(ticket.getHours()).thenReturn(0);
		int actualCharge = parkingLot.getCharges(ticket);
		Assert.assertEquals(expectedCharge, actualCharge );
		
	}
	
	@Test
	public void test31Minutes0Days() {
		expectedCharge = 2;
		Mockito.when(ticket.getDays()).thenReturn(0);
		Mockito.when(ticket.getMinutes()).thenReturn(31);
		Mockito.when(ticket.getHours()).thenReturn(0);
		int actualCharge = parkingLot.getCharges(ticket);
		Assert.assertEquals(expectedCharge, actualCharge );
		
	}
	
	@Test
	public void test7Hours29Minutes0Days() {
		expectedCharge = 14;
		Mockito.when(ticket.getDays()).thenReturn(0);
		Mockito.when(ticket.getMinutes()).thenReturn(29);
		Mockito.when(ticket.getHours()).thenReturn(7);
		int actualCharge = parkingLot.getCharges(ticket);
		Assert.assertEquals(expectedCharge, actualCharge );
		
	}
	
	@Test
	public void test7Hours30Minutes0Days() {
		expectedCharge = 14;
		Mockito.when(ticket.getDays()).thenReturn(0);
		Mockito.when(ticket.getMinutes()).thenReturn(30);
		Mockito.when(ticket.getHours()).thenReturn(7);
		int actualCharge = parkingLot.getCharges(ticket);
		Assert.assertEquals(expectedCharge, actualCharge );
		
	}
	
	@Test
	public void test7Hours31Minutes0Days() {
		expectedCharge = 15;
		Mockito.when(ticket.getDays()).thenReturn(0);
		Mockito.when(ticket.getMinutes()).thenReturn(31);
		Mockito.when(ticket.getHours()).thenReturn(7);
		int actualCharge = parkingLot.getCharges(ticket);
		Assert.assertEquals(expectedCharge, actualCharge );
		
	}
	
	@Test
	public void test0Hours30Minutes1Days() {
		expectedCharge = 17;
		Mockito.when(ticket.getDays()).thenReturn(01);
		Mockito.when(ticket.getMinutes()).thenReturn(30);
		Mockito.when(ticket.getHours()).thenReturn(0);
		int actualCharge = parkingLot.getCharges(ticket);
		Assert.assertEquals(expectedCharge, actualCharge );
		
	}
	
	@Test
	public void test4Hours0Minutes1Days() {
		expectedCharge = 23;
		Mockito.when(ticket.getDays()).thenReturn(1);
		Mockito.when(ticket.getMinutes()).thenReturn(0);
		Mockito.when(ticket.getHours()).thenReturn(4);
		int actualCharge = parkingLot.getCharges(ticket);
		Assert.assertEquals(expectedCharge, actualCharge );
		
	}
	
	@Test
	public void testLessThan7Days() {
		expectedCharge = 90;
		Mockito.when(ticket.getDays()).thenReturn(6);
		Mockito.when(ticket.getMinutes()).thenReturn(0);
		Mockito.when(ticket.getHours()).thenReturn(0);
		int actualCharge = parkingLot.getCharges(ticket);
		Assert.assertEquals(expectedCharge, actualCharge );
	}
	
	@Test
	public void test0Hours0Minutes7Days() {
		expectedCharge = 90;
		Mockito.when(ticket.getDays()).thenReturn(7);
		Mockito.when(ticket.getMinutes()).thenReturn(0);
		Mockito.when(ticket.getHours()).thenReturn(0);
		int actualCharge = parkingLot.getCharges(ticket);
		Assert.assertEquals(expectedCharge, actualCharge );
	}
	
	@Test
	public void testMorethan7Days() {
		expectedCharge = 105;
		Mockito.when(ticket.getDays()).thenReturn(8);
		Mockito.when(ticket.getMinutes()).thenReturn(0);
		Mockito.when(ticket.getHours()).thenReturn(0);
		int actualCharge = parkingLot.getCharges(ticket);
		Assert.assertEquals(expectedCharge, actualCharge );
	}
	
	@Test
	public void test14Days() {
		expectedCharge = 180;
		Mockito.when(ticket.getDays()).thenReturn(14);
		Mockito.when(ticket.getMinutes()).thenReturn(0);
		Mockito.when(ticket.getHours()).thenReturn(0);
		int actualCharge = parkingLot.getCharges(ticket);
		Assert.assertEquals(expectedCharge, actualCharge );
	}
	

	

}
