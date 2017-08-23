package travel_agency.core;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import travel_agency.exception.NoMoreAvailablePullmanException;
import travel_agency.transport.Pullman;
import travel_agency.transport.Taxi;
import travel_agency.travel.City;
import travel_agency.travel.SimpleTravelAd;
import travel_agency.travel.Travel;
import travel_agency.travel.TravelAd;
import travel_agency.users.Address;
import travel_agency.users.Driver;
import travel_agency.users.Hostess;
import travel_agency.users.Manager;

public class AgencyManagmentTest {
	private FleetVehicle fleetV;
	private AgencyManagement agencyManagement;
	private Travel travel;
	private TravelAd travelAd;
	private Calendar cal;
	private Date date;
	private Hostess hostess;
	private Driver driver;
	private Pullman pullman1;
	private Pullman pullman2;
	private Taxi taxi;
	private Address address;
	private final double EPSILON = 0.01;
	
	private void setDate(int year, int month, int day){
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		date = cal.getTime();
	}
	
	@Before
	public void setUp() {
		address= new Address("Via Roma", 12, 23600);
		setDate(2015,11,10);
		driver = new Driver("Marco Rossi", address, 5000);
		hostess = new Hostess("Maria Rossi", address, 5500);
		travel = new City("Firenze", "Descrizione Firenze", 250, date, 8);
		pullman1 = new Pullman(driver, hostess, 20);
		pullman2 = new Pullman(driver, hostess, 60);
		taxi = new Taxi(new Driver("Mario Rossi", address, 6000), 5);
		fleetV = new FleetVehicle(new Manager("Maurizio Rossi", address, 4500));
		fleetV.addVehicles(taxi);
		fleetV.addVehicles(pullman1);
		fleetV.addVehicles(pullman2);
		agencyManagement = new AgencyManagement(fleetV);
		agencyManagement.addStaff(driver);
		travelAd = new SimpleTravelAd("Nome viaggio", travel, pullman1, 10);
		
	}
	
	@Test
	public void testAddTravelAd() throws NoMoreAvailablePullmanException {
		agencyManagement.addTravelAd(travelAd);
		assertEquals(1, agencyManagement.getTravelAd().size());
	}
	
	@Test
	public void testCreateTravelAd() throws NoMoreAvailablePullmanException {
		agencyManagement.createTravelAd("Nome viaggio", travel);
		assertEquals("Nome viaggio", agencyManagement.getTravelAd().get(0).getName());
		assertEquals(travel, agencyManagement.getTravelAd().get(0).getTravel());
		assertEquals(pullman1, agencyManagement.getTravelAd().get(0).getPullman());
		assertEquals(10, agencyManagement.getTravelAd().get(0).getRegistrationFee(), EPSILON);
	}
	
	@Test
	public void testGetTravelAd() throws NoMoreAvailablePullmanException {
		agencyManagement.addTravelAd(travelAd);
		assertEquals(travelAd, agencyManagement.getTravelAd().get(0));
	}
	
	@Test
	public void testRemoveTravelAd() throws NoMoreAvailablePullmanException {
		agencyManagement.removeTravelAd(travelAd);
		assertEquals(0, agencyManagement.getTravelAd().size());
	}
	
	@Test
	public void testAddVehicle() {
		agencyManagement.addVehicle(pullman2);
		assertEquals(4, agencyManagement.getVehicle().size());
	}
	
	@Test
	public void testRemoveVehicle() {
		agencyManagement.removeVehicle(pullman2);
		assertEquals(2, agencyManagement.getVehicle().size());
	}
	
	@Test
	public void testCheckPayment() {
		agencyManagement.addTravelAd(travelAd);
		agencyManagement.checkPayment();
		assertEquals(3, agencyManagement.getVehicle().size());
	}
	
	@Test
	public void testAddStaff() {
		agencyManagement.addStaff(hostess);
		assertEquals(2, agencyManagement.getStaff().size());
	}
	
	@Test
	public void testRemoveStaff() {
		agencyManagement.removeStaff(driver);
		assertEquals(0, agencyManagement.getStaff().size());
	}
	
	@Test
	public void testGetStaff() {
		assertEquals(driver, agencyManagement.getStaff().get(0));
	}
}