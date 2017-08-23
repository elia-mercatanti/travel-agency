package travel_agency.exception;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NoMoreAvailablePlacesExceptionTest {
	
	private NoMoreAvailablePlacesException excep;

	@Before
	public void setUp() throws Exception {
		excep=new NoMoreAvailablePlacesException();
	}

	@Test
	public void testToString() {
		assertEquals("Non ci sono piu' posti disponibili per questo viaggio.", excep.toString());
	}
}
