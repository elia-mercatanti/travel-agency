package travel_agency.travel;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TravelCompound implements Travel{
	
	private List<Travel> travelList;
	
	public TravelCompound(){
		travelList= new LinkedList <Travel> ();
	}
	
	public List<Travel> getTravelList() {
		return travelList;
	}

	@Override
	public void add(Travel travel) throws UnsupportedOperationException {
		travelList.add(travel);
	}

	@Override
	public void remove(Travel travel) throws UnsupportedOperationException {
		travelList.remove(travel);
	}

	@Override
	public double getPrice() {
		double sum=0;
		Travel current;
		Iterator <Travel> iter= travelList.iterator();
		while(iter.hasNext()){
			current=iter.next();
			sum=sum+current.getPrice();
		}
		return sum;
	}

	@Override
	public int getNumDaysTravel() {
		int sum=0;
		Travel current;
		Iterator <Travel> iter= travelList.iterator();
		while(iter.hasNext()){
			current=iter.next();
			sum=sum+current.getNumDaysTravel();
		}
		return sum;
	}

	@Override
	public int getTravelCount() {
		int sum=0;
		Travel current;
		Iterator <Travel> iter= travelList.iterator();
		while(iter.hasNext()){
			current=iter.next();
			sum=sum+current.getTravelCount();
		}
		return sum;
	}

	@Override
	public String getDestinationsName() {
		String destinationsString="";
		Travel current;
		Iterator <Travel> iter= travelList.iterator();
		while(iter.hasNext()){
			current=iter.next();
			destinationsString=destinationsString + current.getDestinationsName() + "/";
		}
		destinationsString=destinationsString.substring(0,destinationsString.length()-1);
		return destinationsString;
	}

	@Override
	public String getDescription() {
		String descriptionString="";
		Travel current;
		Iterator <Travel> iter= travelList.iterator();
		while(iter.hasNext()){
			current=iter.next();
			descriptionString=descriptionString + current.getDescription() + "/";
		}
		descriptionString=descriptionString.substring(0,descriptionString.length()-1);
		return descriptionString;
	}

	@Override
	public Date getStartDate() {
		Date startDate=new Date(Long.MAX_VALUE-500);
		Travel current;
		Iterator <Travel> iter= travelList.iterator();
		while(iter.hasNext()){
			current=iter.next();
			if(current.getStartDate().before(startDate))
				startDate=current.getStartDate();
		}
		return startDate;
	}

	@Override
	public Date getEndDate() {
		Date endDate=new Date(Long.MIN_VALUE+500);
		Travel current;
		Iterator <Travel> iter= travelList.iterator();
		while(iter.hasNext()){
			current=iter.next();
			if(current.getEndDate().after(endDate))
				endDate=current.getEndDate();
		}
		return endDate;
	}
}
