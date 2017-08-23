package travel_agency.transport;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import travel_agency.users.Address;
import travel_agency.users.Driver;
import travel_agency.users.Hostess;

public class PullmanTest {
	
	private Pullman pullman;
	private Driver driver;
	private Hostess hostess;

	@Before
	public void setUp(){
		driver=new Driver("Marco Farina", new Address("Via Marco Polo", 12, 23100), 2000);
		hostess=new Hostess("Sara Rossi", new Address("Via Vittoria", 45, 56477), 3000);
		pullman=new Pullman(driver, hostess, 100);
	}
	
	@Test
	public void testGetSeatList() {
		assertEquals(100, pullman.getSeatList().size());
	}
	
	@Test
	public void testGetDriver() {
		assertEquals(driver, pullman.getDriver());
	}
	
	@Test
	public void testSetDriver() {
		driver= new Driver("Laura Montelli", new Address("Via Centrale", 103, 83200), 1500);
		pullman.setDriver(driver);
		assertEquals(driver, pullman.getDriver());
	}
	
	@Test
	public void testGetHostess() {
		assertEquals(hostess, pullman.getHostess());
	}
	
	@Test
	public void testSetHostess() {
		hostess= new Hostess("Laura Montelli", new Address("Via Centrale", 103, 83200), 1500);
		pullman.setHostess(hostess);
		assertEquals(hostess, pullman.getHostess());
	}
	
	@Test
	public void testGetNumSeats() {
		assertEquals(100, pullman.getNumSeats());
	}
	
	@Test
	public void testGetFirstFreeSeat(){
		assertEquals(1, pullman.getFreeSeat());
		testAllReserved();
		
	}

	private void testAllReserved() {
		Iterator<Seat> iter=pullman.getSeatList().iterator();
		Seat current;
		while(iter.hasNext()){
			current=iter.next();
			current.setReserved(true);
		}
		assertEquals(-1, pullman.getFreeSeat());
	}

	@Test
	public void testReserveSeat() {
		pullman.reserveSeat(5);
		assertTrue(pullman.getSeatList().get(4).isReserved());
	}
	
	@Test
	public void freeSeat() {
		pullman.freeSeat(12);
		assertFalse(pullman.getSeatList().get(11).isReserved());
	}
}
