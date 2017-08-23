package travel_agency.travel;

import java.util.List;

import travel_agency.exception.NoMoreAvailablePlacesException;
import travel_agency.exception.NotEnoughMoneyException;
import travel_agency.transport.Pullman;
import travel_agency.users.Person;

public interface TravelAd {
	
	public double calculatePrice();
	public void addReservation(Person person) throws NoMoreAvailablePlacesException, NotEnoughMoneyException;
	public double calculateTravelDeposit();
	public double calculateTravelBalance();
	public void payBalances();
	public void checkTravelPayments();
	public int getMaxReservations();
	public double getDepositePercentage();
	public String getName();
	public Travel getTravel();
	public Pullman getPullman();
	public List<Reservation> getReservList();
	public double getRegistrationFee();
}
