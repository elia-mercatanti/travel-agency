package travel_agency.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import travel_agency.exception.NoMoreAvailablePullmanException;
import travel_agency.transport.Pullman;
import travel_agency.users.Address;
import travel_agency.users.Driver;
import travel_agency.users.Hostess;
import travel_agency.users.Manager;

public class FleetVehicleTest {

	private FleetVehicle fleetV;
	private Manager manager;
	private Pullman pullman1;
	private Pullman pullman2;
	private Address address;
	
	@Before
	public void setUp(){
		address= new Address("Via Roma", 12, 23600);
		manager=new Manager("Mario Rossi", address, 1200);
		fleetV=new FleetVehicle(manager);
		pullman1 = new Pullman(new Driver("Marco Rossi", address, 5000),
				new Hostess("Maria Rossi", address, 1500), 20);
		pullman2 =new Pullman(new Driver("Marco Rossi", address, 5000),
				new Hostess("Maria Rossi", address, 1500), 60);
	}
	
	@Test
	public void testGetFirstAvailablePullman() throws NoMoreAvailablePullmanException {
		fleetV.addVehicles(pullman1);
		fleetV.addVehicles(pullman2);
		fleetV.getVehicles().get(0).setBusy(true);
		assertEquals(pullman2, fleetV.getFirstAvailablePullman());
	}
	
	
	@SuppressWarnings("deprecation")
	@Rule
	  public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void TestNoMoreAvailablePullman() throws NoMoreAvailablePullmanException { 
		exception.expect(NoMoreAvailablePullmanException.class);
		assertEquals(pullman2, fleetV.getFirstAvailablePullman());
	}
	
	@Test
	public void testGetManager() {
		assertEquals(manager, fleetV.getManager());
	}

	@Test
	public void testSetManager() {
		Manager newManager = new Manager("Marco Bianchi", address, 1500);
		fleetV.setManager(newManager);
		assertEquals(newManager, fleetV.getManager());
	}
	
	@Test
	public void testAddVehicles(){
		fleetV.addVehicles(pullman1);
		assertEquals(1, fleetV.getVehicles().size());
	}
	
	@Test
	public void testRemoveVehicles(){
		fleetV.addVehicles(pullman1);
		fleetV.removeVehicles(pullman1);
		assertEquals(0, fleetV.getVehicles().size());
	}
	
	@Test
	public void testGetVehicles(){
		fleetV.addVehicles(pullman1);
		assertEquals(pullman1, fleetV.getVehicles().get(0));
	}
	
	@Test
	public void testGetSize(){
		fleetV.addVehicles(pullman1);
		fleetV.addVehicles(pullman1);
		assertEquals(2, fleetV.getSize());
	}
}
