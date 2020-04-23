package com.parking.production;

public class ParkingLot {
	
	public int getCharges(Ticket ticket) {
		int days = ticket.getDays();
		int hours = ticket.getHours();
		int minutes = ticket.getMinutes();
		int dailyMax = 15;
		int charge = 0;
		if(days == 0) {
			if(minutes >= 30) {
				minutes -= 30;
			}else {
				minutes = 0;
			}
		}
		if(minutes > 0) {
			hours += 1;
		}
	
		if( hours <= 7 ) {
			charge += hours * 2;
		}else{
			charge += dailyMax;
		}
		charge += days*dailyMax;
		
		int weeks = days/7;
		charge -= weeks*15;
	
		return charge;
	}

}
