package travel_agency.travel;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import travel_agency.travel.City;

public class CityTest{

	private City city;
	private Date date;
	private Calendar cal;
	private final double EPSILON=0.01;
	
	private void setDate(int year, int month, int day){
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		date = cal.getTime();
	}
	
	@Before
	public void setUp() {
		setDate(2013,10,5);
		city = new City("Firenze", "Descrizione", 200.0, date, 4);
	}
	
	@Test
	public void testGetName() {
		assertEquals("Firenze", city.getName());
	}
	
	@Test
	public void testSetName() {
		city.setName("Prato");
		assertEquals("Prato", city.getName());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("Descrizione", city.getDescription());
	}
	
	@Test
	public void testSetDescription() {
		city.setDescription("Descrizione modificata");
		assertEquals("Descrizione modificata", city.getDescription());
	}
	
	@Test
	public void testGetDate() {
		assertEquals(date, city.getDate());
	}
	
	@Test
	public void testSetDate() {
		setDate(2007,3,21);
		city.setDate(date);
		assertEquals(date, city.getDate());
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(200.0, city.getPrice(), EPSILON);
	}
	
	@Test
	public void testSetPrice() {
		city.setPrice(300.23);
		assertEquals(300.23, city.getPrice(), EPSILON);
	}
	
	@Test
	public void testGetNumDays() {
		assertEquals(4, city.getNumDays());
	}
	
	@Test
	public void testSetNumDays() {
		city.setNumDays(7);
		assertEquals(7, city.getNumDays());
	}
	
	@Rule
	  public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testAdd() throws UnsupportedOperationException { 
		exception.expect(UnsupportedOperationException.class);
		exception.expectMessage("Operazione non consentita!");
		city.add(city);
	}

	@Test
	public void testRemove() throws UnsupportedOperationException{
		exception.expect(UnsupportedOperationException.class);
		exception.expectMessage("Operazione non consentita!");
		city.remove(city);
	}
	
	@Test
	public void testGetTravelCount() {
		assertEquals(1, city.getTravelCount());
	}

	@Test
	public void testGetDestinationsName() {
		assertEquals("Firenze", city.getDestinationsName());
	}

	@Test
	public void testGetNumDaysTravel() {
		assertEquals(4, city.getNumDaysTravel());
	}

	@Test
	public void testGetStartDate() {
		assertEquals(date, city.getStartDate());
	}

	@Test
	public void testGetEndDate() {
		assertEquals(date, city.getEndDate());
	}
}
