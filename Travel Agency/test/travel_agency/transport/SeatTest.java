package travel_agency.transport;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeatTest {
	
	private Seat seat;

	@Before
	public void setUp(){
		seat=new Seat(43);
	}
	
	@Test
	public void getSeatID() {
		assertEquals(43, seat.getSeatID());
	}
	
	@Test
	public void isReserved() {
		assertFalse(seat.isReserved());
	}
	
	@Test
	public void setReserved() {
		seat.setReserved(true);
		assertTrue(seat.isReserved());
	}
}
