package travel_agency.users;


public class Manager extends Staff{

	public Manager(String name, Address address, double budget) {
		super(name, address, budget);
	}
	
	public Manager(String name, Address address) {
		super(name, address);
	}
	
	public String toString(){
		return "[Manager"+"/"+getName()+ "/"+ getAddress().toString()+ "/Budget:"+getBudget()+"]";
	}
}
