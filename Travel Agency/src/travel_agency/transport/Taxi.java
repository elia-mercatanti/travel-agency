package travel_agency.transport;

import java.util.Iterator;

import travel_agency.exception.NoServiceException;
import travel_agency.users.Driver;

public class Taxi extends Vehicle{

	private boolean inService;
	
	public Taxi(Driver driver, int numSeats) {
		super(driver, numSeats);
		inService=false;
	}
	
	public boolean isInService() {
		return inService;
	}

	public void setInService(boolean inService) {
		this.inService = inService;
	}

	public int getFreeSeat() throws NoServiceException {
		if(inService){
			Iterator<Seat> iterator=getSeatList().iterator();
			Seat current;
			while(iterator.hasNext()){
				current=iterator.next();
				if(!current.isReserved())
					return current.getSeatID();
			}
			return -1;
		}
		else
			throw new NoServiceException();
	}
}
