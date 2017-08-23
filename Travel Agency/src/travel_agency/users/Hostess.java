package travel_agency.users;


public class Hostess extends Staff{

	public Hostess(String name, Address address, double budget) {
		super(name, address, budget);
	}
	
	public Hostess(String name, Address address) {
		super(name, address);
	}
	
	public String toString(){
		return "[Hostess"+"/"+getName()+ "/"+ getAddress().toString()+ "/Budget:"+getBudget()+"]";
	}
}
