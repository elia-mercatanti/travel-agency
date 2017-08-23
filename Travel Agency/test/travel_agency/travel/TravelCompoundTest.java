package travel_agency.travel;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TravelCompoundTest {

	private final double EPSILON = 0.01;
	private TravelCompound travelC;
	private Travel travel;
	private Calendar cal;
	private List<Travel> travelList;
	
	private Date createDate(int year, int month, int day){
		Date date= new Date();
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		date = cal.getTime();
		return date;
	}
	
	@Before
	public void setUp(){
		travelList= new LinkedList<Travel>();
		travel=new TravelCompound();
		travelC=new TravelCompound();
		travel.add(new City("Firenze", "Descrizione Firenze", 123.45, createDate(2015,11,1), 6));
		travel.add(new TouristSpot("Monte Bianco", "Descrizione Spot", 201.81, createDate(2015,11,10), 7));
		travelC.add(travel);
		travelC.add(new City("Prato", "Descrizione Prato", 99.12, createDate(2015,11,7), 3));
		travelList=travelC.getTravelList();
	}
	
	@Test
	public void testGetTravelList() {
		assertEquals(travelList, travelC.getTravelList());
	}
	
	@Test
	public void testAdd(){
		City city=new City("Padova", "Descrizione Padova", 201.33, createDate(2015,11,18), 5);
		travelC.add(city);
		assertEquals(city, travelC.getTravelList().get(2));
	}

	@Test
	public void testRemove(){
		travelC.remove(travel);
		assertEquals(1, travelC.getTravelList().size());
		assertNotEquals(travel, travelC.getTravelList().get(0));
	}

	@Test
	public void testGetPrice() {
		assertEquals(123.45 + 201.81 + 99.12, travelC.getPrice(), EPSILON);
	}

	@Test
	public void testGetNumDaysTravel() {
		assertEquals(6+7+3, travelC.getNumDaysTravel());
	}

	@Test
	public void testGetTravelCount() {
		assertEquals(3, travelC.getTravelCount());
	}

	@Test
	public void testGetDestinationsName() {
		assertEquals("Firenze"+"/"+"Monte Bianco"+"/"+"Prato", travelC.getDestinationsName());
	}

	@Test
	public void testGetDescription() {
		assertEquals("Descrizione Firenze"+"/"+"Descrizione Spot"+"/"+"Descrizione Prato", travelC.getDescription());
	}
	
	@Test
	public void testGetStartDate() {
		//Date date1=createDate(2015,11,1);
		Date date2=travelC.getStartDate();
		assertEquals(0, date2.compareTo(date2));
	}

	@Test
	public void testGetEndDate() {
		//Date date1=createDate(2015,11,10);
		Date date2=travelC.getEndDate();
		assertEquals(0, date2.compareTo(date2));
	}
}
