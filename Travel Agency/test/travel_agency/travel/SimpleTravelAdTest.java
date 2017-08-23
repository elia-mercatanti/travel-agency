package travel_agency.travel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import travel_agency.exception.NoMoreAvailablePlacesException;
import travel_agency.exception.NotEnoughMoneyException;
import travel_agency.transport.Pullman;
import travel_agency.users.Client;
import travel_agency.users.Driver;
import travel_agency.users.Hostess;
import travel_agency.users.Person;
import travel_agency.users.Address;

public class SimpleTravelAdTest {
	
	private List<Reservation> reservList;
	private Person person1;
	private Person person2;
	private Driver driver;
	private Hostess hostess;
	private Pullman pullman;
	private TravelAd travelAd;
	private City travel;
	private Calendar cal;
	private Date date;

	private final double EPSILON=0.01;
	
	private void setDate(int year, int month, int day){
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		date = cal.getTime();
	}
	
	@Before
	public void setUp() throws NoMoreAvailablePlacesException, NotEnoughMoneyException{
		reservList = new ArrayList<Reservation>();
		person1 = new Client("Marco Bianchi", new Address("Via montalese", 23, 59100), 200000);
		person2 = new Client("Mario Rossi", new Address("Via Roma", 53, 59830), 1000);
		driver = new Driver("Maurizio", new Address("Via sesce", 20, 59060), 3500);
		hostess = new Hostess("Stefania Rossi", new Address("Via garibaldi", 4, 59100), 1500);
		pullman = new Pullman(driver, hostess, 60);
		setDate(2015,11,10);
		travel = new City("Firenze", "Descrizione Firenze", 150, date, 6);
		travelAd = new SimpleTravelAd("Nome viaggio", travel, pullman, 10);
		travelAd.addReservation(person1);
		travelAd.addReservation(person2);
		reservList=travelAd.getReservList();
	}
	
	@Test
	public void getMaxReservations() {
		assertEquals(60, travelAd.getMaxReservations());
	}

	@Test
	public void getDepositePercentage() {
		assertEquals(20, travelAd.getDepositePercentage(), EPSILON);
	}
	
	@Rule
	  public ExpectedException exception = ExpectedException.none();
	
	
	@Test
	public void testAddReservation() throws NoMoreAvailablePlacesException, NotEnoughMoneyException{
		Client person =new Client("Maurizio Maurizio", new Address("Via Sesce", 18, 59600), 3500);
		travelAd.addReservation(person);
		assertEquals(person, travelAd.getReservList().get(2).getPerson());
		//testNoPlaceAvailable();
		//setUp();
		//testNotEnoughMoney();
	}
	
	@Test
	public void testNotEnoughMoney() throws NoMoreAvailablePlacesException, NotEnoughMoneyException {
		exception.expect(NotEnoughMoneyException.class);
		for(int i=0; i<pullman.getNumSeats()-4; i++){
			travelAd.addReservation(person2);
		}
	}

	@Test
	public void testNoPlaceAvailable() throws NoMoreAvailablePlacesException, NotEnoughMoneyException {
		exception.expect(NoMoreAvailablePlacesException.class);
		for(int i=0; i<pullman.getNumSeats()-1; i++){
			travelAd.addReservation(person1);
		}
	}

	/*
	
	@Test
	public void testIsPlacesAvailable() {
		assertEquals(true, travelAd.isPlacesAvailable());
	}
	
	@Test
	public void testPayDeposit() {
		Client person =new Client("Maurizio Maurizio", new Address("Via Sesce", 18, 59600), 0);
		assertEquals(false, travelAd.payDeposit(person));
	}
	
	*/
	
	@Test
	public void testAssignPlace() throws NoMoreAvailablePlacesException, NotEnoughMoneyException {
		Client person =new Client("Maurizio Maurizio", new Address("Via Sesce", 18, 59600), 3500);
		assertEquals(3, travelAd.getPullman().getFreeSeat());
		travelAd.addReservation(person);
		assertEquals(4, travelAd.getPullman().getFreeSeat());
	}
	
	@Test
	public void testCalculatePrice(){
		assertEquals(150, travelAd.calculatePrice(), EPSILON);
	}
	
	@Test
	public void testCalculateTravelDeposit(){
		assertEquals(40, travelAd.calculateTravelDeposit(), EPSILON);
	}
	
	@Test
	public void testCalculateTravelBalance(){
		assertEquals(120, travelAd.calculateTravelBalance(), EPSILON);
	}

	@Test
	public void testPayBalances(){
		travelAd.payBalances();
		assertEquals(true, travelAd.getReservList().get(1).isBalancePaid());
	}
	
	@Test
	public void testCheckTravelPayments() throws NoMoreAvailablePlacesException, NotEnoughMoneyException{
		Client person =new Client("Maurizio Maurizio", new Address("Via Sesce", 18, 59600), 100);
		travelAd.addReservation(person);
		travelAd.checkTravelPayments();
		assertEquals(2, travelAd.getReservList().size());
	}
	
	@Test
	public void testGetName() {
		assertEquals("Nome viaggio", travelAd.getName());
	}

	@Test
	public void testGetTravel() {
		assertEquals(travel, travelAd.getTravel());
	}
	
	@Test
	public void testGetPullman() {
		assertEquals(pullman, travelAd.getPullman());
	}
	
	@Test
	public void testGetReservList() {
		assertEquals(reservList, travelAd.getReservList());
	}

	@Test
	public void testGetRegistrationFee() {
		assertEquals(10, travelAd.getRegistrationFee(), EPSILON);
	}
}
