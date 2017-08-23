package travel_agency.users;


public class Driver extends Staff{

	public Driver(String name, Address address, double budget) {
		super(name, address, budget);
	}
	
	public Driver(String name, Address address) {
		super(name, address);
	}
	
	public String toString(){
		return "[Driver"+"/"+getName()+ "/"+ getAddress().toString()+ "/Budget:"+getBudget()+"]";
	}
}
