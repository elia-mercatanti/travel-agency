package travel_agency.exception;

@SuppressWarnings("serial")
public class NotEnoughMoneyException extends Exception{
	
	public final String toString() {
		  return "No cash.";
	}
}
