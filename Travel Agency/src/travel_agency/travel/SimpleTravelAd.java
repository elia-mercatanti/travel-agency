package travel_agency.travel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import travel_agency.exception.NoMoreAvailablePlacesException;
import travel_agency.exception.NotEnoughMoneyException;
import travel_agency.transport.Pullman;
import travel_agency.users.Person;

public class SimpleTravelAd implements TravelAd{

	private String name;
	private Travel travel;
	private final Pullman pullman;
	private final int MAX_RESERVATION;
	private List<Reservation> reservList;
    private double registrationFee;
    private final double DEPOSITE_PERCENTAGE;
    
	public SimpleTravelAd(String name, Travel travel, Pullman pullman, double registrationFee) {
		this.name=name;
		this.travel = travel;
		this.pullman = pullman;
		MAX_RESERVATION=pullman.getNumSeats();
		DEPOSITE_PERCENTAGE=20;
		reservList = new ArrayList <Reservation> (MAX_RESERVATION);
		this.registrationFee = registrationFee;
	}
	
	public void addReservation(Person person) throws NoMoreAvailablePlacesException, NotEnoughMoneyException{
		if(isPlacesAvailable())
		{
			if(payDeposit(person))
				assignPlace(person);
			else
				throw new NotEnoughMoneyException();
		}
		else
			throw new NoMoreAvailablePlacesException();
	}

	private boolean isPlacesAvailable(){
		if(reservList.size()>=MAX_RESERVATION)
			return false;
		return true;
	}
	
	private boolean payDeposit(Person person) {
		double travelDeposit=calculateTravelDeposit();
		if(person.getBudget()>=travelDeposit){
			person.pay(travelDeposit);
			return true;
		}
		else
			return false;		
	}
	
	private void assignPlace(Person person) {
		int seatID=pullman.getFreeSeat();
		reservList.add(new Reservation(person, seatID));
		pullman.reserveSeat(seatID);
	}
	
	public double calculatePrice(){ 
		double price = travel.getPrice();
		return price;
	}
	
	public double calculateTravelDeposit(){
		return calculatePrice()/100*DEPOSITE_PERCENTAGE+registrationFee;
	}
	
	public double calculateTravelBalance(){
		return calculatePrice() - calculatePrice()/100*DEPOSITE_PERCENTAGE;
	}

	public void payBalances(){
		Iterator<Reservation> iterator=reservList.iterator();
		Person currentP;
		Reservation currentR;
		double balanceAmmount=calculateTravelBalance();
		while(iterator.hasNext()){
			currentR=iterator.next();
			currentP=currentR.getPerson();
			if(currentP.getBudget()>=balanceAmmount){
				currentP.pay(balanceAmmount);
				currentR.setBalancePaid(true);
			}
		}
	}
	
	public void checkTravelPayments(){
		payBalances();
		Iterator<Reservation> iterator=reservList.iterator();
		Reservation currentR;
		while(iterator.hasNext()){
			currentR=iterator.next();
			if(!currentR.isBalancePaid()){
				pullman.freeSeat(currentR.getSeatID());    
				iterator.remove();
			}
		}
	}
	
	public int getMaxReservations() {
		return MAX_RESERVATION;
	}

	public double getDepositePercentage() {
		return DEPOSITE_PERCENTAGE;
	}

	public String getName() {
		return name;
	}

	public Travel getTravel() {
		return travel;
	}
	
	public Pullman getPullman() {
		return pullman;
	}
	
	public List<Reservation> getReservList() {
		return reservList;
	}

	public double getRegistrationFee() {
		return registrationFee;
	}
}
