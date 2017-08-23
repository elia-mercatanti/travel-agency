package travel_agency.users;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ManagerTest {

	private Manager manager;
	private Address address;
	private final double EPSILON=0.01;

	@Before
	public void setUp(){
		address= new Address("Via Roma", 12, 23600);
		manager=new Manager("Mario Rossi", address, 1200);
	}
	
	@Test
	public void testClientCreation() {
		manager=new Manager("Dario Rossi", address);
		assertEquals(0, manager.getBudget(),EPSILON);
	}
	
	@Test
	public void testGetBudget() {
		assertEquals(1200, manager.getBudget(),EPSILON);
	}

	@Test
	public void testSetBudget() {
		manager.setBudget(1000);
		assertEquals(1000, manager.getBudget(),EPSILON);
	}
	
	@Test
	public void testGetName() {
		assertEquals("Mario Rossi", manager.getName());
	}
	
	@Test
	public void testSetName() {
		manager.setName("Gino Bianchi");
		assertEquals("Gino Bianchi", manager.getName());
	}
	
	@Test
	public void testGetAddress() {
		assertEquals(address, manager.getAddress());
	}
	
	@Test
	public void testSetAddress() {
		address=new Address("Via Strozzi", 53, 83560);
		manager.setAddress(address);
		assertEquals(address, manager.getAddress());
	}
	
	@Test
	public void testPay() {
		manager.pay(200);
		assertEquals(1020, manager.getBudget(), EPSILON);
	}

	@Test
	public void testRechargeBudget() {
		manager.rechargeBudget(123.23);
		assertEquals(1323.23, manager.getBudget(), EPSILON);
	}
	
	@Test
	public void testToString(){
		assertEquals("[Manager"+"/"+"Mario Rossi"+"/"+address.toString()+"/Budget:"+1200.0+"]", manager.toString());
	}
}
