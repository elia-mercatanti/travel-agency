package travel_agency.travel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import travel_agency.users.Address;
import travel_agency.users.Client;
import travel_agency.users.Person;

public class ReservationTest {
	
	private Reservation reserv;
	private Person person;
	private Person person2;

	@Before
	public void setUp(){
		person= new Client("Marco Bianchi", new Address("Via montalese", 23, 59100), 2000);
		person2=new Client("Mario Rossi", new Address("Via Roma", 53, 59830), 1000);
		reserv = new Reservation(person, 45);
	}
	
	@Test
	public void testGetperson() {
		assertEquals(person, reserv.getPerson());
	}
	
	@Test
	public void testSetPerson() {
		reserv.setPerson(person2);
		assertEquals(person2, reserv.getPerson());
	}
	
	@Test
	public void testGetSeatID() {
		assertEquals(45, reserv.getSeatID());
	}

	@Test
	public void testIsBalancePaid() {
		assertEquals(false, reserv.isBalancePaid());
	}

	@Test
	public void testSetBalancePaid() {
		reserv.setBalancePaid(true);
		assertEquals(true, reserv.isBalancePaid());
	}
}
