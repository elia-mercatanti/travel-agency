package travel_agency.users;


public abstract class Staff extends Person{
	
	private final double staffDiscount=10;

	public Staff(String name, Address address, double budget) {
		super(name, address, budget);
	}
	
	public Staff(String name, Address address) {
		super(name, address);
	}

	public void pay(double ammount){
    	ammount=applyDiscount(ammount);
    	setBudget(getBudget()- ammount);
    }
	
	private double applyDiscount(double ammount) {
		return ammount-ammount/100*staffDiscount;
	}
}
