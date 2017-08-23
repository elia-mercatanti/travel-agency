package travel_agency.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import travel_agency.exception.NoMoreAvailablePullmanException;
import travel_agency.transport.Pullman;
import travel_agency.transport.Vehicle;
import travel_agency.travel.SimpleTravelAd;
import travel_agency.travel.Travel;
import travel_agency.travel.TravelAd;
import travel_agency.users.Staff;

public class AgencyManagement {
	private FleetVehicle fleetV;
	private List <TravelAd> travelAdList;
	private List <Staff> staffList; 
	
	public AgencyManagement(FleetVehicle fleetV){
		this.fleetV = fleetV;
		travelAdList = new LinkedList<TravelAd>();
		staffList = new LinkedList<Staff>();
	}
	
	public void createTravelAd(String name, Travel travel) throws NoMoreAvailablePullmanException
	{
		Pullman pullman = fleetV.getFirstAvailablePullman();
		TravelAd travelAd = new SimpleTravelAd(name, travel, pullman, 10);
		addTravelAd(travelAd);
	}
	
	public void addTravelAd(TravelAd travelAd)
	{
		travelAdList.add(travelAd);
	}
	
	public List<TravelAd> getTravelAd()
	{
		return travelAdList;
	}
	
	public void removeTravelAd(TravelAd travelAd){
		travelAdList.remove(travelAd);
	}
	
	public void addVehicle(Vehicle vehicle){
		fleetV.addVehicles(vehicle);
	}
	
	public List<Vehicle> getVehicle(){
		  return fleetV.getVehicles();
	}
	
	public void removeVehicle(Vehicle vehicle){
		fleetV.removeVehicles(vehicle);
	}
	
	public void checkPayment(){
		Iterator<TravelAd> iterator = travelAdList.iterator();
		TravelAd current;
		while(iterator.hasNext()){
			current=iterator.next();
			current.checkTravelPayments();
		}
	}
	
	public void addStaff(Staff staff)
	{
		staffList.add(staff);
	}
	
	public void removeStaff(Staff staff)
	{
		staffList.remove(staff);
	}
	
	public List<Staff> getStaff()
	{
		return staffList;
	}
}