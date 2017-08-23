package travel_agency.travel;

import travel_agency.users.Person;

public class Reservation {
	private Person person;
	private final int seatID;
	private boolean balancePaid;
	
	public Reservation(Person person, int seatID) {
		super();
		this.person = person;
		this.seatID = seatID;
	}

	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public int getSeatID() {
		return seatID;
	}

	public boolean isBalancePaid() {
		return balancePaid;
	}

	public void setBalancePaid(boolean balancePaid) {
		this.balancePaid = balancePaid;
	}
}
