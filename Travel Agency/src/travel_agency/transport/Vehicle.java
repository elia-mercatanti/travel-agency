package travel_agency.transport;

import java.util.ArrayList;
import java.util.List;

import travel_agency.exception.NoServiceException;
import travel_agency.users.Driver;

public abstract class Vehicle {
	
	private final List<Seat> seatList;
	private Driver driver;
	private boolean busy;
	
	public Vehicle(Driver driver, int numSeats) {
		this.driver = driver;
		seatList= new ArrayList<Seat> (numSeats);
		for(int i=0; i<numSeats; i++){
			seatList.add(new Seat(i+1));
		}
		busy=false;
	}
	
	
	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public List<Seat> getSeatList() {
		return seatList;
	}

	public Driver getDriver() {
		return driver;
	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public int getNumSeats() {
		return seatList.size();
	}
	
	public abstract int getFreeSeat() throws NoServiceException;

	public void reserveSeat(int seatID) {
		seatList.get(seatID-1).setReserved(true);
	}

	public void freeSeat(int seatID) {
		seatList.get(seatID-1).setReserved(false);
	}
}
