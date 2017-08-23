package travel_agency.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import travel_agency.exception.NoMoreAvailablePullmanException;
import travel_agency.transport.Pullman;
import travel_agency.transport.Vehicle;
import travel_agency.users.Manager;

public class FleetVehicle {
	
	private List <Vehicle> vehiclesList;
	private Manager manager;
	
	public FleetVehicle(Manager manager){
		this.manager=manager;
		vehiclesList=new LinkedList<Vehicle>();
	}
	
	public Pullman getFirstAvailablePullman() throws NoMoreAvailablePullmanException{
		Iterator<Vehicle> iterator=vehiclesList.iterator();
		Vehicle current;
		while(iterator.hasNext()){
			current=iterator.next();
			if(current instanceof Pullman){
				if(!current.isBusy())
				{
					current.setBusy(true);
					return (Pullman)current;
				}
			}
		}
		throw new NoMoreAvailablePullmanException();
	}
	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public void addVehicles(Vehicle vehicle){
		vehiclesList.add(vehicle);
	}
	
	public void removeVehicles(Vehicle vehicle){
		vehiclesList.remove(vehicle);
	}
	
	public List<Vehicle> getVehicles(){
		  return vehiclesList;
	}
	
	public int getSize(){
		return vehiclesList.size();
	}
}

