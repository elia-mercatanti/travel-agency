package travel_agency.travel;

import java.util.Date;

public interface Travel {
	public void add(Travel travel) throws UnsupportedOperationException;
	public void remove(Travel travel) throws UnsupportedOperationException;
	public double getPrice();
	public int getTravelCount();
	public String getDestinationsName();
	public String getDescription();
	public int getNumDaysTravel();
	public Date getStartDate();
	public Date getEndDate();
}
