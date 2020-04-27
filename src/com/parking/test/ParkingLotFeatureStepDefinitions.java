package com.parking.test;

import java.text.SimpleDateFormat;

import com.parking.production.ParkingLot;
import com.parking.production.Ticket;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ParkingLotFeatureStepDefinitions {

	static SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm");
	Ticket ticket;
	
	@Given("^I enter the parking lot at \"([^\"]*)\"$")
	public void i_enter_the_parking_lot_at(String enterDate) throws Throwable {
		ticket = new Ticket(format.parse(enterDate));
	}

	@When("^I leave at \"([^\"]*)\"$")
	public void i_leave_at(String leaveDate) throws Throwable {
		ticket.setLeave(format.parse(leaveDate));
	}

	@Then("^my charge is (\\d+)$")
	public void my_charge_is(int expectedCharge) throws Throwable {
		ParkingLot parking = new ParkingLot();
		int actualCharge = parking.getCharges(ticket);
		
		Assert.assertEquals(expectedCharge, actualCharge);
	}
}
