package travel_agency.users;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClientTest {
	
	private Client client;
	private Address address;
	private final double EPSILON=0.01;

	@Before
	public void setUp(){
		address= new Address("Via Roma", 12, 23600);
		client=new Client("Mario Rossi", address, 1200);
	}
	
	@Test
	public void testClientCreation() {
		client=new Client("Dario Rossi", address);
		assertEquals(0, client.getBudget(),EPSILON);
	}
	
	@Test
	public void testGetBudget() {
		assertEquals(1200, client.getBudget(),EPSILON);
	}

	@Test
	public void testSetBudget() {
		client.setBudget(1000);
		assertEquals(1000, client.getBudget(),EPSILON);
	}
	
	@Test
	public void testGetName() {
		assertEquals("Mario Rossi", client.getName());
	}
	
	@Test
	public void testSetName() {
		client.setName("Gino Bianchi");
		assertEquals("Gino Bianchi", client.getName());
	}
	
	@Test
	public void testGetAddress() {
		assertEquals(address, client.getAddress());
	}
	
	@Test
	public void testSetAddress() {
		address=new Address("Via Strozzi", 53, 83560);
		client.setAddress(address);
		assertEquals(address, client.getAddress());
	}
	
	@Test
	public void testPay() {
		client.pay(200);
		assertEquals(1000, client.getBudget(), EPSILON);
	}

	@Test
	public void testRechargeBudget() {
		client.rechargeBudget(123.23);
		assertEquals(1323.23, client.getBudget(), EPSILON);
	}
	
	@Test
	public void testToString(){
		assertEquals("[Client"+"/"+"Mario Rossi"+"/"+address.toString()+"/Budget:"+1200.0+"]", client.toString());
	}
}
