package travel_agency.travel;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import travel_agency.exception.NoMoreAvailablePlacesException;
import travel_agency.exception.NotEnoughMoneyException;
import travel_agency.transport.Pullman;

public class LastMinutePriceDecoratorTest {

	private LastMinutePriceDecorator lmpDec;
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
	public void setUp() throws NoMoreAvailablePlacesException, NotEnoughMoneyException {
		pullman = new Pullman(null, null, 60);
		setDate(2015,11,10);
		travel = new City("Firenze", "Descrizione Firenze", 100, date, 6);
		travelAd = new SimpleTravelAd("Nome viaggio", travel, pullman, 10);
		lmpDec = new LastMinutePriceDecorator(travelAd);
		
	}
	
	@Test
	public void testCalculatePrice() {
		assertEquals(80, lmpDec.calculatePrice(), EPSILON);
	}

	@Test
	public void testApplyWinterSale() {
		assertEquals(80, lmpDec.applyLastMinuteSale(travelAd.calculatePrice()), EPSILON);
	}
}
