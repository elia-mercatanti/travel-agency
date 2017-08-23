package travel_agency.users;

public class Client extends Person{
	
	public Client(String name, Address address, double budget) {
		super(name, address, budget);
	}
	
	public Client(String name, Address address) {
		super(name, address);
	}
	
	@Override
	public void pay(double ammount) {
		setBudget(getBudget()- ammount);
	}
	
	public String toString(){
		return "[Client"+"/"+getName()+ "/"+ getAddress().toString()+ "/Budget:"+getBudget()+"]";
	}
}
