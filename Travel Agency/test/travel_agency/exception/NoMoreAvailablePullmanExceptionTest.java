package travel_agency.exception;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NoMoreAvailablePullmanExceptionTest {

	private NoMoreAvailablePullmanException excep;

	@Before
	public void setUp() throws Exception {
		excep=new NoMoreAvailablePullmanException();
	}

	@Test
	public void testToString() {
		assertEquals("Non ci sono piu' autobus disponibili.", excep.toString());
	}
}
