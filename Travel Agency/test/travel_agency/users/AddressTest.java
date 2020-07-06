package travel_agency.users;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {

	private Address address1;
	private Address address2;
	
	@Before
	public void setUp() {
		address1 = new Address("Via garibaldi", 12, 23100);
		address2 = new Address("Via Mazzini", 12, 23100);
	}
	
	@Test
	public void testGetStreet() {
		assertEquals("Via garibaldi", address1.getStreet());
	}
	
	@Test
	public void testSetStreet() {
		address1.setStreet("Via Roma");
		assertEquals("Via Roma", address1.getStreet());
	}
	
	@Test
	public void testGetNumber() {
		assertEquals(12, address1.getNumber());
	}
	
	@Test
	public void testSetNumber() {
		address1.setNumber(45);
		assertEquals(45, address1.getNumber());
	}
	
	@Test
	public void testGetCap() {
		assertEquals(23100, address1.getCap());
	}
	
	@Test
	public void testSetCap() {
		address1.setCap(90399);
		assertEquals(90399, address1.getCap());
	}
	
	@Test
	public void testEquals() {
		assertFalse();
		assertEquals(true, address1.equals(address1));
	}

	private void assertFalse() {
		Object obj = new Object();
		assertEquals(false, address1.equals(obj));
		assertEquals(false, address1.equals(address2));
		address1.setStreet("Via Mazzini");
		address2.setNumber(32);
		assertEquals(false, address1.equals(address2));
		address1.setNumber(32);
		address1.setCap(32655);
		assertEquals(false, address1.equals(address2));
	}
}
