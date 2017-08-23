package travel_agency.travel;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import travel_agency.travel.TouristSpot;

public class TouristSpotTest {

	private TouristSpot tourSpot;
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
		setDate(2014,4,25);
		tourSpot = new TouristSpot("Monte Bianco", "Descrizione", 199.21, date, 2);
	}
	
	@Test
	public void testGetName() {
		assertEquals("Monte Bianco", tourSpot.getName());
	}
	
	@Test
	public void testSetName() {
		tourSpot.setName("Prato");
		assertEquals("Prato", tourSpot.getName());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("Descrizione", tourSpot.getDescription());
	}
	
	@Test
	public void testSetDescription() {
		tourSpot.setDescription("Descrizione modificata");
		assertEquals("Descrizione modificata", tourSpot.getDescription());
	}
	
	@Test
	public void testGetDate() {
		assertEquals(date, tourSpot.getDate());
	}
	
	@Test
	public void testSetDate() {
		setDate(2007,3,21);
		tourSpot.setDate(date);
		assertEquals(date, tourSpot.getDate());
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(199.21, tourSpot.getPrice(), EPSILON);
	}
	
	@Test
	public void testSetPrice() {
		tourSpot.setPrice(300.23);
		assertEquals(300.23, tourSpot.getPrice(), EPSILON);
	}
	
	@Test
	public void testGetNumDays() {
		assertEquals(2, tourSpot.getNumDays());
	}
	
	@Test
	public void testSetNumDays() {
		tourSpot.setNumDays(7);
		assertEquals(7, tourSpot.getNumDays());
	}
	
	@Rule
	  public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testAdd() throws UnsupportedOperationException { 
		exception.expect(UnsupportedOperationException.class);
		exception.expectMessage("Operazione non consentita!");
		tourSpot.add(tourSpot);
	}

	@Test
	public void testRemove() throws UnsupportedOperationException{
		exception.expect(UnsupportedOperationException.class);
		exception.expectMessage("Operazione non consentita!");
		tourSpot.remove(tourSpot);
	}
	
	@Test
	public void testGetTravelCount() {
		assertEquals(1, tourSpot.getTravelCount());
	}

	@Test
	public void testGetDestinationsName() {
		assertEquals("Monte Bianco", tourSpot.getDestinationsName());
	}

	@Test
	public void testGetNumDaysTravel() {
		assertEquals(2, tourSpot.getNumDaysTravel());
	}

	@Test
	public void testGetStartDate() {
		assertEquals(date, tourSpot.getStartDate());
	}

	@Test
	public void testGetEndDate() {
		assertEquals(date, tourSpot.getEndDate());
	}
}
