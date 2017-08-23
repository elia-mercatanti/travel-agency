package travel_agency.users;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HostessTest {

	private Hostess hostess;
	private Address address;
	private final double EPSILON=0.01;

	@Before
	public void setUp(){
		address= new Address("Via Roma", 12, 23600);
		hostess=new Hostess("Mario Rossi", address, 1200);
	}
	
	@Test
	public void testClientCreation() {
		hostess=new Hostess("Dario Rossi", address);
		assertEquals(0, hostess.getBudget(),EPSILON);
	}
	
	@Test
	public void testGetBudget() {
		assertEquals(1200, hostess.getBudget(),EPSILON);
	}

	@Test
	public void testSetBudget() {
		hostess.setBudget(1000);
		assertEquals(1000, hostess.getBudget(),EPSILON);
	}
	
	@Test
	public void testGetName() {
		assertEquals("Mario Rossi", hostess.getName());
	}
	
	@Test
	public void testSetName() {
		hostess.setName("Gino Bianchi");
		assertEquals("Gino Bianchi", hostess.getName());
	}
	
	@Test
	public void testGetAddress() {
		assertEquals(address, hostess.getAddress());
	}
	
	@Test
	public void testSetAddress() {
		address=new Address("Via Strozzi", 53, 83560);
		hostess.setAddress(address);
		assertEquals(address, hostess.getAddress());
	}
	
	@Test
	public void testPay() {
		hostess.pay(200);
		assertEquals(1020, hostess.getBudget(), EPSILON);
	}

	@Test
	public void testRechargeBudget() {
		hostess.rechargeBudget(123.23);
		assertEquals(1323.23, hostess.getBudget(), EPSILON);
	}
	
	@Test
	public void testToString(){
		assertEquals("[Hostess"+"/"+"Mario Rossi"+"/"+address.toString()+"/Budget:"+1200.0+"]", hostess.toString());
	}
}
