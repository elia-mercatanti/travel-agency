package travel_agency.exception;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NoServiceExceptionTest {

	private NoServiceException excep;

	@Before
	public void setUp(){
		excep=new NoServiceException();
	}

	@Test
	public void testToString() {
		assertEquals("Il veicolo richiesto non è in servizio", excep.toString());
	}
}
