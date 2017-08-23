package travel_agency.exception;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NotEnoughMoneyExceptionTest {

	private NotEnoughMoneyException excep;

	@Before
	public void setUp() throws Exception {
		excep=new NotEnoughMoneyException();
	}

	@Test
	public void testToString() {
		assertEquals("No cash.", excep.toString());
	}
}
