package travel_agency.users;

public abstract class Person {
	private String name;
	private Address address;
	private double budget;
	
	public Person(String name, Address address, double budget) {
		this.name = name;
		this.address = address;
		this.budget = budget;
	}
	
	public Person(String name, Address address) {
		this.name = name;
		this.address = address;
		budget = 0;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public abstract void pay(double ammount);
	
	public final void rechargeBudget(double ammount) {
		setBudget(getBudget()+ ammount);
	}
}
