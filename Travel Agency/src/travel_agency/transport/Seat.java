package travel_agency.transport;

public class Seat {
	private final int seatID;
	private boolean reserved;
	
	public Seat(int seatID) {
		this.seatID = seatID;
		reserved = false;
	}

	public int getSeatID() {
		return seatID;
	}
	
	public boolean isReserved() {
		return reserved;
	}
	
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}	
}
