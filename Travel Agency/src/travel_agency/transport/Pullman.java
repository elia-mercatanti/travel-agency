package travel_agency.transport;

import java.util.Iterator;

import travel_agency.users.Driver;
import travel_agency.users.Hostess;

public class Pullman extends Vehicle{
	
	private Hostess hostess;
	
	public Pullman(Driver driver, Hostess hostess, int numSeats) {
		super(driver, numSeats);
		this.hostess = hostess;
	}
	
	public Hostess getHostess() {
		return hostess;
	}
	
	public void setHostess(Hostess hostess) {
		this.hostess = hostess;
	}

	@Override
	public int getFreeSeat() {
		Iterator<Seat> iterator=getSeatList().iterator();
		Seat current;
		while(iterator.hasNext()){
			current=iterator.next();
			if(!current.isReserved())
				return current.getSeatID();
		}
		return -1;
	}
}
