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
import travel_agency.users.Address;
import travel_agency.users.Client;
import travel_agency.users.Person;

public class AutumnPriceDecoratorTest {

	private AutumnPriceDecorator apDec;
	private Pullman pullman;
	private TravelAd travelAd;
	private City travel;
	private Calendar cal;
	private Date date;
	private final double EPSILON=0.01;
	private List<Reservation> reservList;
	private Person person1;
	private Person person2;
	
	private void setDate(int year, int month, int day){
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		date = cal.getTime();
	}
	
	@Before
	public void setUp() throws NoMoreAvailablePlacesException, NotEnoughMoneyException {
		reservList = new ArrayList<Reservation>();
		person1 = new Client("Marco Bianchi", new Address("Via montalese", 23, 59100), 200000);
		person2 = new Client("Mario Rossi", new Address("Via Roma", 53, 59830), 1000);
		pullman = new Pullman(null, null, 60);
		setDate(2015,11,10);
		travel = new City("Firenze", "Descrizione Firenze", 100, date, 6);
		travelAd = new SimpleTravelAd("Nome viaggio", travel, pullman, 10);
		apDec = new AutumnPriceDecorator(travelAd);
	}
	
	@Test
	public void testCalculatePrice() {
		assertEquals(90, apDec.calculatePrice(), EPSILON);
	}

	@Test
	public void testApplyAutumnSale() {
		assertEquals(90, apDec.applyAutumnSale(travelAd.calculatePrice()), EPSILON);
	}
	
	@Test
	public void getMaxReservations() {
		assertEquals(60, apDec.getMaxReservations());
	}

	@Test
	public void getDepositePercentage() {
		assertEquals(20, apDec.getDepositePercentage(), EPSILON);
	}
	
	@Rule
	  public ExpectedException exception = ExpectedException.none();
	
	
	@Test
	public void testAddReservation() throws NoMoreAvailablePlacesException, NotEnoughMoneyException{
		Client person =new Client("Maurizio Maurizio", new Address("Via Sesce", 18, 59600), 3500);
		apDec.addReservation(person);
		assertEquals(person, apDec.getReservList().get(0).getPerson());
		//testNoPlaceAvailable();
		//setUp();
		//testNotEnoughMoney();
	}
	
	@Test
	public void testNotEnoughMoney() throws NoMoreAvailablePlacesException, NotEnoughMoneyException {
		exception.expect(NotEnoughMoneyException.class);
		for(int i=0; i<pullman.getNumSeats()-4; i++){
			apDec.addReservation(person2);
		}
	}

	@Test
	public void testNoPlaceAvailable() throws NoMoreAvailablePlacesException, NotEnoughMoneyException {
		exception.expect(NoMoreAvailablePlacesException.class);
		for(int i=0; i<pullman.getNumSeats()+1; i++){
			apDec.addReservation(person1);
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
		apDec.addReservation(person);
		apDec.addReservation(person);
		assertEquals(3, apDec.getPullman().getFreeSeat());
		apDec.addReservation(person);
		assertEquals(4, apDec.getPullman().getFreeSeat());
	}
	
	@Test
	public void testCalculateTravelDeposit(){
		assertEquals(30, apDec.calculateTravelDeposit(), EPSILON);
	}
	
	@Test
	public void testCalculateTravelBalance(){
		assertEquals(80, apDec.calculateTravelBalance(), EPSILON);
	}

	@Test
	public void testPayBalances() throws NoMoreAvailablePlacesException, NotEnoughMoneyException{
		apDec.addReservation(person1);
		apDec.payBalances();
		assertEquals(true, apDec.getReservList().get(0).isBalancePaid());
	}
	
	@Test
	public void testCheckTravelPayments() throws NoMoreAvailablePlacesException, NotEnoughMoneyException{
		Client person =new Client("Maurizio Maurizio", new Address("Via Sesce", 18, 59600), 1000);
		apDec.addReservation(person);
		apDec.checkTravelPayments();
		assertEquals(1, apDec.getReservList().size());
	}
	
	@Test
	public void testGetName() {
		assertEquals("Nome viaggio", apDec.getName());
	}

	@Test
	public void testGetTravel() {
		assertEquals(travel, apDec.getTravel());
	}
	
	@Test
	public void testGetPullman() {
		assertEquals(pullman, apDec.getPullman());
	}
	
	@Test
	public void testGetReservList() {
		assertEquals(reservList, apDec.getReservList());
	}

	@Test
	public void testGetRegistrationFee() {
		assertEquals(10, apDec.getRegistrationFee(), EPSILON);
	}
}
