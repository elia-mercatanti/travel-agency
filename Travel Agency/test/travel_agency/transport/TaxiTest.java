package travel_agency.transport;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import travel_agency.exception.NoServiceException;
import travel_agency.users.Address;
import travel_agency.users.Driver;

public class TaxiTest {

	private Taxi taxi;
	private Driver driver;

	@Before
	public void setUp(){
		driver=new Driver("Marco Farina", new Address("Via Marco Polo", 12, 23100), 2000);
		taxi=new Taxi(driver, 100);
	}
	
	@Test
	public void testIsInService() {
		assertFalse(taxi.isInService());
	}

	@Test
	public void testSetInService() {
		taxi.setInService(true);
		assertTrue(taxi.isInService());
	}
	
	@Test
	public void testGetSeatList() {
		assertEquals(100, taxi.getSeatList().size());
	}
	
	@Test
	public void testGetDriver() {
		assertEquals(driver, taxi.getDriver());
	}
	
	@Test
	public void testSetDriver() {
		driver= new Driver("Laura Montelli", new Address("Via Centrale", 103, 83200), 1500);
		taxi.setDriver(driver);
		assertEquals(driver, taxi.getDriver());
	}
	
	@Test
	public void testGetNumSeats() {
		assertEquals(100, taxi.getNumSeats());
	}
	

	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testNoService() throws NoServiceException{
		exception.expect(NoServiceException.class);
		taxi.getFreeSeat();
	}
	
	@Test
	public void testGetFreeSeat() throws NoServiceException{
		taxi.setInService(true);
		assertEquals(1, taxi.getFreeSeat());
		testAllReserved();
	}

	private void testAllReserved() throws NoServiceException {
		Iterator<Seat> iter=taxi.getSeatList().iterator();
		Seat current;
		while(iter.hasNext()){
			current=iter.next();
			current.setReserved(true);
		}
		assertEquals(-1, taxi.getFreeSeat());
	}

	@Test
	public void testReserveSeat() {
		taxi.reserveSeat(5);
		assertTrue(taxi.getSeatList().get(4).isReserved());
	}
	
	@Test
	public void freeSeat() {
		taxi.freeSeat(12);
		assertFalse(taxi.getSeatList().get(11).isReserved());
	}
}
