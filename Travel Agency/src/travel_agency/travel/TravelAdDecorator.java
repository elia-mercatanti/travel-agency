package travel_agency.travel;

import java.util.List;

import travel_agency.exception.NoMoreAvailablePlacesException;
import travel_agency.exception.NotEnoughMoneyException;
import travel_agency.transport.Pullman;
import travel_agency.users.Person;

public abstract class TravelAdDecorator implements TravelAd{
	
	protected TravelAd decTravel;

	public TravelAdDecorator(TravelAd decTravel)
	{
		this.decTravel = decTravel;
	}
	
	public void addReservation(Person person) throws NoMoreAvailablePlacesException, NotEnoughMoneyException {
		decTravel.addReservation(person);
	}
	
	public double calculateTravelDeposit() {
		return decTravel.calculateTravelDeposit();
	}
	
	public double calculateTravelBalance() {
		return decTravel.calculateTravelBalance();
	}
	
	public void payBalances() {
		decTravel.payBalances();
	}
	
	public void checkTravelPayments() {
		decTravel.checkTravelPayments();
	}
	
	public int getMaxReservations() {
		return decTravel.getMaxReservations();
	}
	
	public double getDepositePercentage() {
		return decTravel.getDepositePercentage();
	}
	
	public String getName() {
		return decTravel.getName();
	}
	
	public Travel getTravel() {
		return this.decTravel.getTravel();
	}
	
	public Pullman getPullman() {
		return this.decTravel.getPullman();
	}
	
	public List<Reservation> getReservList() {
		return this.decTravel.getReservList();
	}
	public double getRegistrationFee() {
		return this.decTravel.getRegistrationFee();
	}
	
	public double calculatePrice(){
		return decTravel.calculatePrice();
	}
}
