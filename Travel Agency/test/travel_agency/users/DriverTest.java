package travel_agency.users;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {

	private Driver driver;
	private Address address;
	private final double EPSILON=0.01;

	@Before
	public void setUp(){
		address= new Address("Via Roma", 12, 23600);
		driver=new Driver("Mario Rossi", address, 1200);
	}
	
	@Test
	public void testClientCreation() {
		driver=new Driver("Dario Rossi", address);
		assertEquals(0, driver.getBudget(),EPSILON);
	}
	
	@Test
	public void testGetBudget() {
		assertEquals(1200, driver.getBudget(),EPSILON);
	}

	@Test
	public void testSetBudget() {
		driver.setBudget(1000);
		assertEquals(1000, driver.getBudget(),EPSILON);
	}
	
	@Test
	public void testGetName() {
		assertEquals("Mario Rossi", driver.getName());
	}
	
	@Test
	public void testSetName() {
		driver.setName("Gino Bianchi");
		assertEquals("Gino Bianchi", driver.getName());
	}
	
	@Test
	public void testGetAddress() {
		assertEquals(address, driver.getAddress());
	}
	
	@Test
	public void testSetAddress() {
		address=new Address("Via Strozzi", 53, 83560);
		driver.setAddress(address);
		assertEquals(address, driver.getAddress());
	}
	
	@Test
	public void testPay() {
		driver.pay(200);
		assertEquals(1020, driver.getBudget(), EPSILON);
	}

	@Test
	public void testRechargeBudget() {
		driver.rechargeBudget(123.23);
		assertEquals(1323.23, driver.getBudget(), EPSILON);
	}
	
	@Test
	public void testToString(){
		assertEquals("[Driver"+"/"+"Mario Rossi"+"/"+address.toString()+"/Budget:"+1200.0+"]", driver.toString());
	}
}
