package com.parking.production;

public class ParkingLot {
	
	private int getBillableDays(int days, int hours, int minutes) {
		int billableDays = days;
		
		//every 7th day is free
		int freeDays = days/7;
		billableDays -= freeDays;
		
		return billableDays;
	}
	
	private int getBillableHours(int days, int hours, int minutes) {
		int billableHours = hours;
		int billableMinutes = minutes;
		
		//first half hour of first day is free
		if(days == 0) {
			if(billableMinutes >= 30) {
				billableMinutes -= 30;
			}else {
				billableMinutes = 0;
			}
		}
		
		//minutes round up to the hour
		if(billableMinutes > 0) {
			billableHours += 1;
		}
		
		//every 7th day is free
		if(days % 7 == 6) {
			billableHours = 0;
		}
		
		return billableHours;
	}
	
	public int getCharges(ITicket ticket) {
		int days = ticket.getDays();
		int hours = ticket.getHours();
		int minutes = ticket.getMinutes();
		int baseFare = 2;
		int dailyMax = 15;
		int charge = 0;
		
		charge += getBillableHours(days, hours, minutes) * baseFare;
		if(charge > dailyMax) {
			charge = dailyMax;
		}
		
		charge += getBillableDays(days, hours, minutes) * dailyMax;
	
		return charge;
	}

}
