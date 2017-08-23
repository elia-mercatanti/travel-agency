package travel_agency.travel;

import java.util.Date;

public abstract class Destination implements Travel{
	
	private String name;
	private String description;
	private double price;
	private Date date;
	private int numDays;
	
	public Destination(String name, String description, double price, Date date, int numDays) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.date = date;
		this.numDays=numDays;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	public int getNumDays() {
		return numDays;
	}

	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}
	
	@Override
	public void add(Travel travel) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Operazione non consentita!");
	}

	@Override
	public void remove(Travel travel) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Operazione non consentita!");
	}

	@Override
	public int getTravelCount() {
		return 1;
	}

	@Override
	public String getDestinationsName() {
		return getName();
	}

	@Override
	public int getNumDaysTravel() {
		return getNumDays();
	}

	@Override
	public Date getStartDate() {
		return getDate();
	}

	@Override
	public Date getEndDate() {
		return getDate();
	}
}
